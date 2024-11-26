package com.til.wtcr_service.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.til.wtcr_service.config.JwtConfig;
import com.til.wtcr_service.eumn.ResultType;
import com.til.wtcr_service.pojo.Result;
import com.til.wtcr_service.pojo.User;
import com.til.wtcr_service.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.apache.ibatis.annotations.Param;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;


@RestController
@RequestMapping("/loginController")
@Validated
@ResponseBody
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private JwtConfig jwtConfig;


    private final SecureRandom secureRandom = new SecureRandom();

    private final MessageDigest instance = MessageDigest.getInstance("SHA-256");


    public LoginController() throws NoSuchAlgorithmException {
    }


    @PostMapping("/login")
    public Result<String> login(@RequestParam @Pattern(regexp = "^\\S{1,32}$") String account, @RequestParam @Pattern(regexp = "^\\S{1,32}$") String password) {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getAccount, account));
        if (user == null) {
            return Result.fail("账号不存在");
        }

        byte[] saltBytes = Base64.getDecoder().decode(user.getSalt());
        byte[] digest = instance.digest(password.getBytes());
        byte[] merge = new byte[digest.length + saltBytes.length];

        System.arraycopy(digest, 0, merge, 0, digest.length);
        System.arraycopy(saltBytes, 0, merge, digest.length, saltBytes.length);

        if (!Arrays.equals(instance.digest(merge), Base64.getDecoder().decode(user.getPassword()))) {
            return Result.fail("密码错误");
        }

        return new Result<>(ResultType.SUCCESS, "", jwtConfig.generateJwt(user));
    }


    @PostMapping("/register")
    public Result<Void> register(@RequestParam @Pattern(regexp = "^\\S{1,32}$") String account, @RequestParam @Pattern(regexp = "^\\S{1,32}$") String password) {
        if (userService.count(new LambdaQueryWrapper<User>().eq(User::getAccount, account)) >= 1) {
            return Result.error("注册失败，账号已存在");
        }

        byte[] saltBytes = new byte[32];
        secureRandom.nextBytes(saltBytes);


        byte[] digest = instance.digest(password.getBytes());

        byte[] merge = new byte[digest.length + saltBytes.length];
        System.arraycopy(digest, 0, merge, 0, digest.length);
        System.arraycopy(saltBytes, 0, merge, digest.length, saltBytes.length);

        byte[] passwordByte = instance.digest(merge);

        User user = new User();
        user.setAccount(account);
        user.setPassword(Base64.getEncoder().encodeToString(passwordByte));
        user.setSalt(Base64.getEncoder().encodeToString(saltBytes));
        userService.save(user);

        return Result.success("");

    }


}

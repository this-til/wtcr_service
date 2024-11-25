package com.til.wtcr_service.controller;

import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.til.wtcr_service.config.JwtConfig;
import com.til.wtcr_service.pojo.User;
import com.til.wtcr_service.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Controller
public class GraphQLController {

    @Resource
    private UserService userService;

    @Resource
    private JwtConfig jwtConfig;

    @QueryMapping
    public User self() {
        return userService.getById(1);
    }

    @QueryMapping
    public User getUserById(@Argument int id) {
        return userService.getById(id);
    }

    @QueryMapping
    public User getUserByAccount(@Argument String account) {
        return userService.getOne(new LambdaQueryWrapper<User>().eq(User::getAccount, account));
    }

    @QueryMapping
    public IPage<User> getUserList(@Argument int page, @Argument int size) {
        return userService.page(new Page<>(page, size));
    }

    @QueryMapping
    public IPage<User> getUserListByName(@Argument String name, @Argument int page, @Argument int size) {
        Page<User> userPage = new Page<>(page, size);
        userService.page(userPage, new LambdaQueryWrapper<User>().eq(User::getName, name));
        return userPage;
    }

}

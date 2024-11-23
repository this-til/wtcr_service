package com.til.wtcr_service.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.til.wtcr_service.pojo.User;
import com.til.wtcr_service.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {

    @Resource
    private UserService userService;

    @QueryMapping
    public User getUserById(@Argument String id) {
        return userService.getById(id);
    }


    @QueryMapping
    public User getUserByAccount(@Argument String account) {
        return userService.getOne(new LambdaQueryWrapper<User>().eq(User::getAccount, account));
    }

}

package com.til.wtcr_service.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.til.wtcr_service.config.JwtConfig;
import com.til.wtcr_service.eumn.ArticleType;
import com.til.wtcr_service.eumn.SelectModel;
import com.til.wtcr_service.eumn.UserGender;
import com.til.wtcr_service.eumn.UserPermission;
import com.til.wtcr_service.pojo.*;
import com.til.wtcr_service.service.ArticleService;
import com.til.wtcr_service.service.UserService;
import jakarta.annotation.Nullable;
import jakarta.annotation.Resource;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class GraphQLController {

    @Resource
    private UserService userService;

    @Resource
    private ArticleService articleService;

    @Resource
    private JwtConfig jwtConfig;

    @QueryMapping
    public User self() {
        //TODO 线程上下文中获取JWT令牌
        return userService.getById(1);
    }

    @QueryMapping
    public List<User> userList(@Argument UserFilter userFilter, @Argument PageModel pageModel) {
        return userService.page(pageModel.asPage(), userFilter.asWrapper()).getRecords();
    }

    @QueryMapping
    public List<Article> articleList(@Argument ArticleFilter articleFilter, @Argument PageModel pageModel) {
        return articleService.page(pageModel.asPage(), articleFilter.asWrapper()).getRecords();
    }

    @SchemaMapping(typeName = "User")
    public IPage<Article> articleList(User user, @Argument ArticleFilter articleFilter, @Argument PageModel pageModel) {
        //权限分级
        return articleService.page(pageModel.asPage(), articleFilter.asWrapper());
    }

    @SchemaMapping(typeName = "Article")
    public List<Integer> editorIds(Article article) {
        String editors = article.getEditors();
        String[] split = editors.split(",");
        return Arrays.stream(split).filter(s -> !s.isEmpty()).map(Integer::parseInt).collect(Collectors.toList());
    }

    @SchemaMapping(typeName = "Article")
    public User user(Article article) {
        return userService.getById(article.getUserId());
    }

    @SchemaMapping(typeName = "Article")
    public List<User> editors(Article article) {
        return userService.listByIds(editorIds(article));
    }

}

package com.til.wtcr_service.controller;

import com.til.wtcr_service.config.JwtConfig;
import com.til.wtcr_service.pojo.*;
import com.til.wtcr_service.pojo.filter.ArticleFilter;
import com.til.wtcr_service.pojo.filter.ArticleNodeFilter;
import com.til.wtcr_service.pojo.filter.UserFilter;
import com.til.wtcr_service.service.ArticleNodeService;
import com.til.wtcr_service.service.ArticleService;
import com.til.wtcr_service.service.UserService;
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
    private ArticleNodeService articleNodeService;

    @Resource
    private JwtConfig jwtConfig;

    @QueryMapping
    public User self() {
        //TODO 线程上下文中获取JWT令牌
        return userService.getById(1);
    }

    @QueryMapping
    public List<User> userList(@Argument UserFilter userFilter) {
        // TODO 权限分级
        return userService.page(userFilter.getPageModel().asPage(), userFilter.asWrapper()).getRecords();
    }

    @QueryMapping
    public List<Article> articleList(@Argument ArticleFilter articleFilter) {
        // TODO 权限分级
        return articleService.page(articleFilter.getPageModel().asPage(), articleFilter.asWrapper()).getRecords();
    }

    @SchemaMapping(typeName = "User")
    public List<Article> articleList(User user, @Argument ArticleFilter articleFilter) {
        // TODO 权限分级
        articleFilter.setEditorId(List.of(user.getId()));
        return articleService.page(articleFilter.getPageModel().asPage(), articleFilter.asWrapper()).getRecords();
    }

    @SchemaMapping(typeName = "Article")
    public List<Integer> editorIds(Article article) {
        String editors = article.getEditors();
        String[] split = editors.split(",");
        return Arrays.stream(split).filter(s -> !s.isEmpty()).map(Integer::parseInt).collect(Collectors.toList());
    }

    @SchemaMapping(typeName = "Article")
    public List<ArticleNode> articleNodeList(Article article,@Argument ArticleNodeFilter articleNodeFilter) {

    }

    @SchemaMapping(typeName = "Article")
    public User user(Article article) {
        return userService.getById(article.getUserId());
    }

    @SchemaMapping(typeName = "Article")
    public List<User> editors(Article article) {
        return userService.listByIds(editorIds(article));
    }


    @SchemaMapping(typeName = "ArticleNode")
    public ArticleNode previous(ArticleNode articleNode) {
        if (articleNode.getPreviousVersionId() == null) {
            return null;
        }
        return articleNodeService.getById(articleNode.getPreviousVersionId());
    }

    @SchemaMapping(typeName = "ArticleNode")
    public ArticleNode next(ArticleNode articleNode) {
        if (articleNode.getNextVersionId() == null) {
            return null;
        }
        return articleNodeService.getById(articleNode.getNextVersionId());
    }

    @SchemaMapping(typeName = "ArticleNode")
    public Article article(ArticleNode articleNode) {
        return articleService.getById(articleNode.getId());
    }

    @SchemaMapping(typeName = "ArticleNode")
    public User changeUser(ArticleNode articleNode) {
        return userService.getById(articleNode.getChangeUserId());
    }
}

package com.til.wtcr_service.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.til.wtcr_service.eumn.UserGender;
import com.til.wtcr_service.eumn.UserPermission;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 用户头像的目录
     */
    @TableField(value = "head_url")
    private String headUrl;

    /**
     * 用户的性别
     */
    @TableField(value = "gender")
    private UserGender gender;

    /**
     * 用户的权限
     */
    @TableField(value = "permission")
    private UserPermission permission;

    /**
     * 账号的注册时间
     */
    @TableField(value = "register_time")
    private LocalDateTime registerTime;

    /**
     * 最后登入时间
     */
    @TableField(value = "last_login_time")
    private LocalDateTime lastLoginTime;


    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
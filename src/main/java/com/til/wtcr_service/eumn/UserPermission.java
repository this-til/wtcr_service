package com.til.wtcr_service.eumn;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserPermission {

    /***
     * 游客，只能查看不能留言
     */
    TOURIST(0),

    /***
     * 拥有账户但是为验证身份，权限等同于游客
     */
    UNVERIFIED(1),

    /***
     * 普通用户，能够发布文章、评论
     */
    USER(5),

    /***
     * 编辑，能够修改任意文章评论、能够审核文章
     */
    EDITOR(10),

    /***
     * 最高权限
     */
    ADMIN(100),
    ;

    @EnumValue
    private final int id;

    @JsonValue
    @Override
    public String toString() {
        return super.toString();
    }
}

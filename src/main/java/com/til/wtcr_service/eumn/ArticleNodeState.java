package com.til.wtcr_service.eumn;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArticleNodeState {
    /***
     * 只是草稿
     */
    DRAFT(0),

    /***
     * 审核中
     */
    UNDER_REVIEW(1),

    /***
     * 发布了
     */
    PUBLISHED(2),

    /***
     * 旧版本
     */
    OLD(3),

    /***
     * 被删除了
     */
    DELETED(4);

    @EnumValue
    private final int id;

    @JsonValue
    @Override
    public String toString() {
        return super.toString();
    }
}

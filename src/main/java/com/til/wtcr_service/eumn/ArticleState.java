package com.til.wtcr_service.eumn;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArticleState {

    /***
     * 只是草稿
     * 从未进行审核的状态
     */
    DRAFT(0),

    /***
     * 审核中
     * 新版本正在审核，旧版本可正常查阅
     */
    UNDER_REVIEW(1),

    /***
     * 发布了
     */
    PUBLISHED(2),

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

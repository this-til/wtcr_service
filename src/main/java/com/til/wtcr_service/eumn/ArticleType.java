package com.til.wtcr_service.eumn;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArticleType {

    ARTICLE(0),
    ANNOUNCEMENT(1);

    @EnumValue
    private final int id;

    @JsonValue
    @Override
    public String toString() {
        return super.toString();
    }
}

package com.til.wtcr_service.eumn;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ArticleVisibility {

    PRIVATE(0),
    ADMIN_ONLY(1),
    PUBLIC(2);

    @EnumValue
    private final int id;

    @JsonValue
    @Override
    public String toString() {
        return super.toString();
    }

}


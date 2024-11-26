package com.til.wtcr_service.pojo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageModel {
    private Integer page;
    private Integer size;

    public <E> Page<E> asPage() {
        return new Page<>(page, size);
    }
}

package com.til.wtcr_service.pojo.data;

import lombok.Data;

@Data
public class Ranger<V> {
    private V min;
    private V max;
}

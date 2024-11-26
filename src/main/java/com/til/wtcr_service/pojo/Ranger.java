package com.til.wtcr_service.pojo;

import lombok.Data;

@Data
public class Ranger<V> {
    private V min;
    private V max;
}

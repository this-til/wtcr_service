package com.til.wtcr_service.pojo.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class TimeRanger extends Ranger<LocalDateTime>{
}

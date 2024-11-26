package com.til.wtcr_service.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class TimeRanger extends Ranger<LocalDateTime>{
}

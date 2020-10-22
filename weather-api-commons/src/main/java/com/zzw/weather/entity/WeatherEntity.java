package com.zzw.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherEntity implements Serializable {
    private String name; //城市名字
    private String text; //天气状况
    private String temperature; //当前温度
    private String last_update; //当前时间
}

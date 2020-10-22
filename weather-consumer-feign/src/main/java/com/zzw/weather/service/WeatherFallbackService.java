package com.zzw.weather.service;

import com.zzw.weather.entity.WeatherEntity;
import org.springframework.stereotype.Component;

@Component
public class WeatherFallbackService implements IWeatherProviderService {

    @Override
    public String weather() {
        WeatherEntity weatherEntity = new WeatherEntity("北京", "晴", "9","2020-10-23T02:10:00+08:00");
        return weatherEntity.toString();
    }
}

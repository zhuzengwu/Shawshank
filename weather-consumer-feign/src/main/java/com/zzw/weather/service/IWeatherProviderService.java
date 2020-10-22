package com.zzw.weather.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "weather-provider-payment",fallback = WeatherFallbackService.class)
public interface IWeatherProviderService {

    @RequestMapping(value = "/getWeather")
    public String weather();
}

package com.zzw.weather.controller;

import com.zzw.weather.service.IWeatherProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;

@RestController
public class WeatherConsumerController {

    @Resource
    private IWeatherProviderService weatherProviderService;

    @RequestMapping("/consumer/getWeather")
    public String getWeatherData(){
        return weatherProviderService.weather();
    }
}

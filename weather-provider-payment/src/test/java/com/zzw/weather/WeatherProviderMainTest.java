package com.zzw.weather;

import com.sun.deploy.panel.TextFieldProperty;
import com.zzw.weather.entity.WeatherEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherProviderMainTest {

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void test(){
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setLast_update("aa");
        weatherEntity.setName("朱");
        weatherEntity.setText("00");
        weatherEntity.setTemperature("22");
        redisTemplate.opsForValue().set("weatherEntity",weatherEntity);
        WeatherEntity weatherEntity1 = (WeatherEntity) redisTemplate.opsForValue().get("weatherEntity");

        System.out.println(weatherEntity1);
        System.out.println(weatherEntity1.getLast_update());
        System.out.println(weatherEntity1.getName());
        System.out.println(weatherEntity1.getTemperature());
        System.out.println(weatherEntity1.getText());
    }
}

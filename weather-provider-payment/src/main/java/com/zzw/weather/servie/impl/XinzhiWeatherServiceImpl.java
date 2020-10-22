package com.zzw.weather.servie.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zzw.weather.entity.WeatherEntity;
import com.zzw.weather.servie.IXinzhiWeatherService;
import com.zzw.weather.util.PureNetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class XinzhiWeatherServiceImpl implements IXinzhiWeatherService {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String WEATHER_URI = "https://api.seniverse.com/v3/weather/now.json?key=SxVz2C_UKm1gf9OEt&language=zh-Hans&unit=c&";
    WeatherEntity weather;

    @Override
    public String getXinzhiWeatherByLocation(String location) {

        //从redis获取缓存对象
        weather =(WeatherEntity) redisTemplate.opsForValue().get("weather");

        //判断该对象是否为空
        if (weather!=null){
            //对象不为空，返回redis缓存获取的天气json数据
            System.out.println(weather);
            return weather.toString();
        }else {
            //对象为空，从心知天气api获取天气json数据
            String weatherData = PureNetUtil.get(WEATHER_URI + "location=" + location);
            //对weatherData进行解析，判断从心知天气api获取天气json数据是否成功
            JSONObject jsonObject = JSON.parseObject(weatherData);
            String results = jsonObject.getString("results");
            weather = new WeatherEntity();
            //对获取的results进行判断，result不为空，返回json数据
            if (results!=null) {
                JSONArray jsonArray = JSON.parseArray(results);
                System.out.println(jsonArray);
                System.out.println(WEATHER_URI + "location=" + location);
                //解析需要的数据为weather初始化
                for (Object o : jsonArray) {

                    JSONObject o1 = (JSONObject) o;
                    weather.setName(o1.getJSONObject("location").getString("name"));
                    weather.setText(o1.getJSONObject("now").getString("text"));
                    weather.setTemperature(o1.getJSONObject("now").getString("temperature"));
                    weather.setLast_update(o1.getString("last_update"));
                    //缓存进redis
                    redisTemplate.opsForValue().set("weather", weather);
                    System.out.println(redisTemplate.opsForValue().get("weather"));
                }
                return weather.toString();
            //result为空，返回空数据
            }else {
                return null;
            }
        }
    }
}

/**
 *
 String weatherData = PureNetUtil.get(WEATHER_URI + "location=" + location);

 JSONObject jsonObject = JSON.parseObject(weatherData);
 String results = jsonObject.getString("results");
 JSONArray jsonArray = JSON.parseArray(results);
 System.out.println(jsonArray);
 System.out.println(WEATHER_URI+"location="+location);
 WeatherEntity weather=new WeatherEntity();
 for (Object o:jsonArray) {
 JSONObject o1 = (JSONObject) o;

 weather.setName(o1.getJSONObject("location").getString("name"));
 weather.setText(o1.getJSONObject("now").getString("text"));
 weather.setTemperature(o1.getJSONObject("now").getString("temperature"));
 weather.setLast_update(o1.getString("last_update"));
 }
 */
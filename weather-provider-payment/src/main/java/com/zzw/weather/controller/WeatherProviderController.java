package com.zzw.weather.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zzw.weather.servie.IXinzhiWeatherService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class WeatherProviderController {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    private IXinzhiWeatherService xinzhiWeatherService;

    @RequestMapping(value = "/getWeather")
    @ResponseBody
    @SentinelResource(value = "weather", fallback = "fallback")
    public String weather() {
        String weather = xinzhiWeatherService.getXinzhiWeatherByLocation("aa");
        return weather;
    }
    public String fallback() {
        return "网络异常，请稍后再试";
    }

    /**
     *
    @RequestMapping(value = "/getWeather3")
    @ResponseBody
    public String weather3() {
        WeatherEntity weather1 = new WeatherEntity();
        String weatherByChina = "{\"resultcode\":\"200\",\"reason\":\"successed!\",\"result\":{\"sk\":{\"temp\":\"20\",\"wind_direction\":\"东北风\",\"wind_strength\":\"1级\",\"humidity\":\"65%\",\"time\":\"22:07\"},\"today\":{\"temperature\":\"14℃~28℃\",\"weather\":\"晴\",\"weather_id\":{\"fa\":\"00\",\"fb\":\"00\"},\"wind\":\"北风微风\",\"week\":\"星期六\",\"city\":\"北京\",\"date_y\":\"2020年09月19日\",\"dressing_index\":\"热\",\"dressing_advice\":\"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。\",\"uv_index\":\"强\",\"comfort_index\":\"\",\"wash_index\":\"较适宜\",\"travel_index\":\"较适宜\",\"exercise_index\":\"较适宜\",\"drying_index\":\"\"},\"future\":{\"day_20200919\":{\"temperature\":\"14℃~28℃\",\"weather\":\"晴\",\"weather_id\":{\"fa\":\"00\",\"fb\":\"00\"},\"wind\":\"北风微风\",\"week\":\"星期六\",\"date\":\"20200919\"},\"day_20200920\":{\"temperature\":\"15℃~26℃\",\"weather\":\"晴转多云\",\"weather_id\":{\"fa\":\"00\",\"fb\":\"01\"},\"wind\":\"南风微风\",\"week\":\"星期日\",\"date\":\"20200920\"},\"day_20200921\":{\"temperature\":\"16℃~26℃\",\"weather\":\"多云转阴\",\"weather_id\":{\"fa\":\"01\",\"fb\":\"02\"},\"wind\":\"北风微风\",\"week\":\"星期一\",\"date\":\"20200921\"},\"day_20200922\":{\"temperature\":\"16℃~25℃\",\"weather\":\"多云转小雨\",\"weather_id\":{\"fa\":\"01\",\"fb\":\"07\"},\"wind\":\"东风微风\",\"week\":\"星期二\",\"date\":\"20200922\"},\"day_20200923\":{\"temperature\":\"14℃~18℃\",\"weather\":\"小雨\",\"weather_id\":{\"fa\":\"07\",\"fb\":\"07\"},\"wind\":\"东北风微风\",\"week\":\"星期三\",\"date\":\"20200923\"},\"day_20200924\":{\"temperature\":\"15℃~26℃\",\"weather\":\"晴转多云\",\"weather_id\":{\"fa\":\"00\",\"fb\":\"01\"},\"wind\":\"南风微风\",\"week\":\"星期四\",\"date\":\"20200924\"},\"day_20200925\":{\"temperature\":\"15℃~26℃\",\"weather\":\"晴转多云\",\"weather_id\":{\"fa\":\"00\",\"fb\":\"01\"},\"wind\":\"南风微风\",\"week\":\"星期五\",\"date\":\"20200925\"}}},\"error_code\":0}";
        JSONObject jsonObject = JSON.parseObject(weatherByChina);
        String result1 = jsonObject.getString("result");
        String today = jsonObject.getJSONObject("result").getString("today");
        JSONObject today1 = JSON.parseObject(today);
        String city = today1.getString("city");
        String weather = today1.getString("weather");
        String date_y = today1.getString("date_y");
        String sk = jsonObject.getJSONObject("result").getString("sk");
        JSONObject sk1 = JSON.parseObject(sk);
        String temp = sk1.getString("temp");
        weather1.setName(city);
        weather1.setText(weather);
        weather1.setTemperature(temp);
        weather1.setLast_update(date_y);
        return weatherByChina;
    }
     */
}

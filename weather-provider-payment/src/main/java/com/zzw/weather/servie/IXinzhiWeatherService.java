package com.zzw.weather.servie;

public interface IXinzhiWeatherService {

    /** 通过location参数获取城市json数据
     *   location 参数支持以下形式：
     *    WX4FBXXFKE4F	城市 ID
     *    北京	城市中文名
     *    北京朝阳	省市名称组合
     *    beijing	城市拼音/英文名（如拼音相同城市，可在之前加省份和空格，例：shanxi yulin）
     *    39.93:116.40	经纬度（格式是 纬度:经度，英文冒号分隔）
     *    220.181.111.86	IP 地址（某些 IP 地址可能无法定位到城市）
     *    ip “ip”两个字母 自动识别请求 IP 地址
     *
     *    String key  心知天气秘钥
     *
     */
    String getXinzhiWeatherByLocation(String location);
}

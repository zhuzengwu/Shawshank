package com.zzw.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WeatherProviderMain {
    public static void main(String[] args) {
        SpringApplication.run(WeatherProviderMain.class, args);
    }
}

package com.relsola.order;

import com.relsola.order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * WeatherTest
 *
 * @author relsola
 */
@SpringBootTest
public class WeatherTest {
    @Autowired
    WeatherFeignClient weatherFeignClient;


    @Test
    void testGetWeather() {
        String weather = weatherFeignClient.getWeatherData("b0c1f2d4e", "3b0c1f2d4e", "101010100");
        System.out.println(weather);
    }
}

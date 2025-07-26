package com.relsola.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * WeatherFeignClient
 *
 * @author relsola
 */
@FeignClient(value = "weather-client", url = "http://aliv18.data.moji.com")
public interface WeatherFeignClient {

    @PostMapping("/whapi/json/WeatherQuery?city=101010100&token=3b0c1f2d4e")
    String getWeatherData(@RequestHeader("Authorization") String auth,
                          @RequestParam("token") String token,
                          @RequestParam("cityId") String cityId
    );
}

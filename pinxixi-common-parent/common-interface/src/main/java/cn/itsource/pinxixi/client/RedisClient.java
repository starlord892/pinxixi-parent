package cn.itsource.pinxixi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("PINXIXI-COMMON")
public interface RedisClient {

    @PostMapping("/redis" )
    void set(@RequestParam String key, @RequestParam String value);

    @GetMapping("/redis")
    String get(@RequestParam String key);
}

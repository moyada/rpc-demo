package cn.moyada.spring.cloud.service.controller;

import cn.moyada.spring.cloud.service.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xueyikang
 * @since 1.0
 **/
public interface TestController {

    @GetMapping("/info")
    public String getInfo(@RequestParam("key") String key);

    @GetMapping("/{id}")
    public Result getResultById(@PathVariable("id") Long id);
}

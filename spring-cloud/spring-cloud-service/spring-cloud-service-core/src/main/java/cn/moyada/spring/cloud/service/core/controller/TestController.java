package cn.moyada.spring.cloud.service.core.controller;

import cn.moyada.spring.cloud.service.core.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueyikang
 * @since 1.0
 **/
@RestController
public class TestController {

    @GetMapping("/info")
    public String getInfo(@RequestParam("key") String key) {
        return "info" + key;
    }

//    @GetMapping("/{id}")
//    public String getResultById(@PathVariable("id") Long id) {
//        return id.toString();
//    }

    @GetMapping("/{id}")
    public Result getResultById(@PathVariable("id") Long id) {
        Result result = new Result();
        result.setCode(200);
        result.setSuccess(true);
        result.setData(id.toString());
        return result;
    }
}

package cn.moyada.spring.cloud.service.controller;

import cn.moyada.spring.cloud.service.model.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xueyikang
 * @since 1.0
 **/
@RestController
public class TestControllerImpl implements TestController {

//    @RequestLine("GET /info")
//    @GetMapping("/info")
    public String getInfo(@RequestParam("key") String key) {
        return "info" + key;
    }

//    @GetMapping("/{id}")
//    public String getResultById(@PathVariable("id") Long id) {
//        return id.toString();
//    }

//    @RequestLine("GET /{id}")
//    @GetMapping("/{id}")
    public Result getResultById(@PathVariable("id") Long id) {
        Result result = new Result();
        result.setCode(200);
        result.setSuccess(true);
        result.setData(id.toString());
        return result;
    }
}

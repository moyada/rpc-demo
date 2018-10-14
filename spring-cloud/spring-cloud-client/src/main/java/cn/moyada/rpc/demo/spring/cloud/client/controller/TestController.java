package cn.moyada.rpc.demo.spring.cloud.client.controller;

import cn.moyada.rpc.demo.spring.cloud.client.service.TestService;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TestService testService;

    @RequestLine("GET /{id}")
    @GetMapping("/{id}")
    public String sayHi(@PathVariable("id") Long id){
        return testService.get(id);
    }

    @RequestLine("GET /info")
    @GetMapping("/info")
    public String sayHi(@RequestParam("key") String key){
        return testService.info(key);
    }
}

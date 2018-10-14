package cn.moyada.rpc.demo.spring.cloud.client.spi;

import feign.RequestLine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xueyikang
 * @since 1.0
 **/
//@Component
//@FeignClient(value = "SPRINGCLOUDSERVER", configuration = FeignConfig.class)
public interface TestControllerSPI {

    @RequestLine("GET /info")
    @GetMapping(value = "/info")
    String getInfo(@RequestParam("key") String key);

    @RequestLine("GET /{id}")
    @GetMapping(value = "/{id}")
    String getResultById(@PathVariable("id") Long id);
}

package cn.moyada.rpc.demo.spring.cloud.client.service;


import cn.moyada.rpc.demo.spring.cloud.service.api.TestControllerFeign;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xueyikang
 * @since 1.0
 **/
//@Service
public class TestService {

    @Autowired
    private TestControllerFeign testControllerFeign;

    public String get(Long id){
        return testControllerFeign.getResultById(id);
    }

    public String info(String key){
        return testControllerFeign.getInfo(key);
    }
}

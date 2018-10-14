import cn.moyada.rpc.demo.spring.cloud.client.ClientApplication;
import cn.moyada.rpc.demo.spring.cloud.client.spi.TestControllerFeign;
import feign.*;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.cloud.openfeign.FeignLoggerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xueyikang
 * @since 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeignTest implements ApplicationContextAware {

    @Autowired
    private FeignContext feignContext;

    @Test
    public void test() {
        Encoder encoder = feignContext.getInstance("Encoder", Encoder.class);
        Decoder decoder = feignContext.getInstance("Decoder", Decoder.class);
        Contract contract = feignContext.getInstance("Contract", Contract.class);
        Retryer retryer = feignContext.getInstance("Retryer", Retryer.class);
        FeignLoggerFactory loggerFactory = feignContext.getInstance("FeignLoggerFactory", FeignLoggerFactory.class);
        Request.Options options = feignContext.getInstance("Options", Request.Options.class);
        Client client = feignContext.getInstance("LoadBalancerFeignClient", LoadBalancerFeignClient.class);
        Logger logger = loggerFactory.create(TestControllerFeign.class);

        Feign.Builder builder = Feign.builder()
                .client(client)
                .logger(logger)
                .logLevel(Logger.Level.FULL)
                .encoder(encoder)
                .decoder(decoder)
                .decode404()
                .options(options)
                .contract(contract)
                .retryer(retryer);

        TestControllerFeign testControllerFeign = builder.target(TestControllerFeign.class, "http://SPRINGCLOUDSERVER");

        String s = testControllerFeign.getInfo("dfs");
        System.out.println(s);
//        System.out.println(reflectiveFeign.newInstance());
    }

    @Test
    public void testTemp() {
        Client client = feignContext.getInstance(LoadBalancerFeignClient.class.getName(), LoadBalancerFeignClient.class);
        Request.Options options = feignContext.getInstance("Options", Request.Options.class);
        Decoder decoder = feignContext.getInstance("Decoder", Decoder.class);

        RequestTemplate template = new RequestTemplate();
        template.append("/{id}");
        template.insert(0, "http://SPRINGCLOUDSERVER");

        template.method("GET");
        // template.query("key", "123");
        Map<String, Object> map = new HashMap<>();
        map.put("id", 123);
        template.resolve(map);

        Request request = template.request();
        Response response;
        try {
            response = client.execute(request, options);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Object data;
        try {
            data = decoder.decode(response, String.class);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
//        System.out.println(response.toString());
        System.out.println(data);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        FeignContext context = applicationContext.getBean(FeignContext.class);
        System.out.println(context);
    }
}

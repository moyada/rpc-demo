package cn.moyada.spring.cloud.service.core;

import feign.Request;
import feign.RequestTemplate;

/**
 * @author xueyikang
 * @since 1.0
 **/
public class Test {

    public static void main(String[] args) {
        RequestTemplate template = new RequestTemplate();
        template.append("/info");

        template.method("GET");
        template.query("key", "{key}");
        template.insert(0, "http://SPRINGCLOUDSERVICE");
        Request request = template.request();
        System.out.println(new String(request.body()));
//        template.
    }
}

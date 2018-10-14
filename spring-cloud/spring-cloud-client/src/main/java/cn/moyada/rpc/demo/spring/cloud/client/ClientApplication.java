package cn.moyada.rpc.demo.spring.cloud.client;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@EnableDiscoveryClient
// @EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApplication.class).run(args);
	}
}

package cn.moyada.spring.cloud.service;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceApplication.class).run(args);
	}
}

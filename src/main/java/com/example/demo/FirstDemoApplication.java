package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.example.demo.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.example.demo", "org.n3r.idworker"})
//开启事务支持
@EnableTransactionManagement
public class FirstDemoApplication {


	@Configuration
	public class RestTemplateConfig {
	 
	    @Bean
	    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
	        return new RestTemplate(factory);
	    }
	 
	    @Bean
	    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
	        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
	        factory.setConnectTimeout(15000);
	        factory.setReadTimeout(5000);
	        return factory;
	    }
	 
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FirstDemoApplication.class, args);
	}

}

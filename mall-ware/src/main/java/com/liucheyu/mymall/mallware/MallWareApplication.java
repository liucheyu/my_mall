package com.liucheyu.mymall.mallware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.liucheyu.mymall.mallware.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MallWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallWareApplication.class, args);
	}

}

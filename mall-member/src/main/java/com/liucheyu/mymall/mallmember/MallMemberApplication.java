package com.liucheyu.mymall.mallmember;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.liucheyu.mymall.mallmember.dao")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.liucheyu.mymall.mallmember.feign")
@SpringBootApplication
public class MallMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallMemberApplication.class, args);
	}

}

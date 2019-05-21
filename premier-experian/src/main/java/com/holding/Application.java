/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @author Nicolas Sierra
 */
@SpringBootApplication
@EnableEurekaClient
public class Application extends SpringBootServletInitializer {

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}
}

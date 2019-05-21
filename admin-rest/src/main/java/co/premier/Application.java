package co.premier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "co.premier")
@EnableJpaRepositories(basePackages = {"co.premier.repository"})
@EnableEurekaClient
public class Application extends SpringBootServletInitializer { 

	public static void main(String ... args) {
		SpringApplication.run(Application.class, args);
	}
}

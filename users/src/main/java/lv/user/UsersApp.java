package lv.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "users", configuration = AppConfig.class)
@EnableEurekaClient
@EnableFeignClients
public class UsersApp {

    public static void main(String[] args) {
        SpringApplication.run(UsersApp.class, args);
    }

}
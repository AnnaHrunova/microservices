package lv.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@RibbonClient(name = "items", configuration = AppConfig.class)
@EnableEurekaClient
@EnableFeignClients
@EnableAutoConfiguration
@ComponentScan(basePackages = {"lv.commands", "lv.handlers", "lv.item"})
public class ItemsApp {

    public static void main(String[] args) {
        SpringApplication.run(ItemsApp.class, args);
    }

}

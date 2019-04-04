package lv.item.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;

@Configuration
public class AppConfig {

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


}

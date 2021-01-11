package com.upstox.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TradeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeTestApplication.class, args);
    }

}

package com.upstox.trade.config;

import com.upstox.trade.service.FiniteStateMachine;
import com.upstox.trade.service.ReadTradeDataFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationConfig {

    @Autowired
    ReadTradeDataFile readTradeDataFile;

    @PostConstruct
    public void start() {
        new Thread(new FiniteStateMachine()).start();
        readTradeDataFile.readFiles();
    }
}

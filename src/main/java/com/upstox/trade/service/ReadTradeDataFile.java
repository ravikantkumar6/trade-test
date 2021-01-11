package com.upstox.trade.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upstox.trade.constant.TradeTestUtil;
import com.upstox.trade.model.BarOHLC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class ReadTradeDataFile {

    private static final Logger LOG = LoggerFactory.getLogger(ReadTradeDataFile.class);

    @Autowired
    ObjectMapper objectMapper;

    public static InputStream getResourceFileAsInputStream(String fileName) {
        ClassLoader classLoader = ReadTradeDataFile.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }

    public void readFiles() {
        LOG.debug("Reads the Trades data input (line by line from JSON), and sends " +
                "the packet to the FSM (Finite-State-Machine) thread");
        InputStream is = getResourceFileAsInputStream("trades.json");
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            reader.lines().forEach(line -> {
                try {
                    BarOHLC barOHLC = objectMapper.readValue(line, BarOHLC.class);
                    TradeTestUtil.BAR_OHLC_BLOCKING_QUEUE.add(barOHLC);
                    LOG.debug("Added to Blocking Queue :: {}", barOHLC);
                } catch (JsonProcessingException e) {
                    LOG.error("Error occurred While converting to pojo", e);
                }
            });
        } else {
            LOG.error("Resource is not available");
        }
    }
}

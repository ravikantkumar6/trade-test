package com.upstox.trade.service;

import com.upstox.trade.constant.TradeTestUtil;
import com.upstox.trade.model.BarResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebSocketService {

    private static final Logger LOG = LoggerFactory.getLogger(FiniteStateMachine.class);

    @Scheduled(fixedRate = 15000)
    @SendTo("/topic/uptrox")
    public BarResponse reportCurrentTime() {
        BarResponse barResponse = null;
        try {
            barResponse = TradeTestUtil.BAR_OHLC_RESPONSE_BLOCKING_QUEUE.take();
            LOG.info("Sending Data to web socket:: {}", barResponse);

        } catch (InterruptedException e) {
            LOG.error("Error occured while sending the Response to websocket", e);
        }
        return barResponse;
    }
}


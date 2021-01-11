package com.upstox.trade.service;

import com.upstox.trade.constant.TradeTestUtil;
import com.upstox.trade.model.BarOHLC;
import com.upstox.trade.model.BarResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FiniteStateMachine implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(FiniteStateMachine.class);

    @Override
    public void run() {
        long lowTimeLimmit = 0;
        long nextLimmit = 0;
        long currentTime = 0;
        BarResponse barResponse = null;
        int barNumber = 1;
        List<Integer> prices = null;
        while (true) {
            try {
                BarOHLC barOHLC = TradeTestUtil.BAR_OHLC_BLOCKING_QUEUE.take();
                if (barOHLC == null) {
                    continue;
                }
                int priceOfTrade = Integer.parseInt(barOHLC.getPriceOfTrade());
                if (lowTimeLimmit == 0) {
                    lowTimeLimmit = Long.valueOf(barOHLC.getTimestamp());
                    nextLimmit = lowTimeLimmit + 15000;
                    barResponse = new BarResponse(barNumber);
                    barResponse.setOpen(priceOfTrade);
                    prices = new ArrayList<>();
                }
                currentTime = Long.valueOf(barOHLC.getTimestamp());
                if (lowTimeLimmit <= currentTime && currentTime <= nextLimmit) {

                } else {
                    barResponse.setVolume(prices.stream().mapToInt(i -> i).average().getAsDouble());
                    barResponse.setClose(priceOfTrade);
                    TradeTestUtil.BAR_OHLC_RESPONSE_BLOCKING_QUEUE.add(barResponse);
                    barNumber++;
                    barResponse = new BarResponse(barNumber);
                    barResponse.setOpen(priceOfTrade);
                }
                barResponse.setSymbol(barOHLC.getStockName());
                prices.add(Integer.valueOf(barOHLC.getQuantityTraded()));
                if (barResponse.getHigh() == null || priceOfTrade > barResponse.getHigh()) {
                    barResponse.setHigh(priceOfTrade);
                }
                if (barResponse.getLow() == null || priceOfTrade < barResponse.getLow()) {
                    barResponse.setLow(priceOfTrade);
                }
                LOG.debug("Consumed:: {}", TradeTestUtil.BAR_OHLC_BLOCKING_QUEUE.take());

            } catch (InterruptedException ex) {
                LOG.error("Thread Intrupted ", ex);
                ex.printStackTrace();
            }
        }
    }
}

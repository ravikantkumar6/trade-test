package com.upstox.trade.constant;

import com.upstox.trade.model.BarOHLC;
import com.upstox.trade.model.BarResponse;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public interface TradeTestUtil {
    public BlockingQueue<BarOHLC> BAR_OHLC_BLOCKING_QUEUE = new LinkedBlockingDeque<>();
    public BlockingQueue<BarResponse> BAR_OHLC_RESPONSE_BLOCKING_QUEUE = new LinkedBlockingDeque<>();
}

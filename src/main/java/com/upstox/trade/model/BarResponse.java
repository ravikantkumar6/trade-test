package com.upstox.trade.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BarResponse {
    @JsonProperty("o")
    private Integer open;
    @JsonProperty("h")
    private Integer high;
    @JsonProperty("l")
    private Integer low;
    @JsonProperty("c")
    private Integer close = 0;
    private double volume;
    private String event = "ohlc_notify";
    private String symbol;
    @JsonProperty("bar_num")
    private int barNum;

    public BarResponse() {
    }

    public BarResponse(int barNum) {
        this.barNum = barNum;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getClose() {
        return close;
    }

    public void setClose(Integer close) {
        this.close = close;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getBarNum() {
        return barNum;
    }

    public void setBarNum(int barNum) {
        this.barNum = barNum;
    }

    @Override
    public String toString() {
        return "BarResponse{" +
                "open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume=" + volume +
                ", event='" + event + '\'' +
                ", symbol='" + symbol + '\'' +
                ", barNum=" + barNum +
                '}';
    }
}

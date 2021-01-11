package com.upstox.trade.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BarOHLC {

    @JsonProperty("sym")
    private String stockName;
    @JsonProperty("P")
    private String priceOfTrade;
    @JsonProperty("Q")
    private String quantityTraded;
    @JsonProperty("TS2")
    private String timestamp;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getPriceOfTrade() {
        return priceOfTrade;
    }

    public void setPriceOfTrade(String priceOfTrade) {
        this.priceOfTrade = priceOfTrade;
    }

    public String getQuantityTraded() {
        return quantityTraded;
    }

    public void setQuantityTraded(String quantityTraded) {
        this.quantityTraded = quantityTraded;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "BarOHLC{" +
                "stockName='" + stockName + '\'' +
                ", priceOfTrade='" + priceOfTrade + '\'' +
                ", quantityTraded='" + quantityTraded + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

package com.investment.Dto.Stock;

public class StockRead {
    public String ticker;

    public StockRead() {
    }

    public StockRead(String ticker) {
        this.ticker = ticker;
    }

    public String getTicker() {
        return ticker;
    }

    public StockRead setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }
}

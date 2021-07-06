package com.investment.Dto.Stock;

public class StockResponse {
    public long id;
    public String exchange;
    public String name;
    public String ticker;

    public StockResponse() {
    }

    public long getId() {
        return id;
    }

    public StockResponse setId(long id) {
        this.id = id;
        return this;
    }

    public String getExchange() {
        return exchange;
    }

    public StockResponse setExchange(String exchange) {
        this.exchange = exchange;
        return this;
    }

    public String getName() {
        return name;
    }

    public StockResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getTicker() {
        return ticker;
    }

    public StockResponse setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }
}

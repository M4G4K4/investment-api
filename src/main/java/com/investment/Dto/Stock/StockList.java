package com.investment.Dto.Stock;

import com.investment.Dto.User.UserResponse;

import java.util.List;

public class StockList {
    private List<StockResponse> stocks;

    public List<StockResponse> getStocks() {
        return stocks;
    }

    public StockList setStocks(List<StockResponse> stocks) {
        this.stocks = stocks;
        return this;
    }
}

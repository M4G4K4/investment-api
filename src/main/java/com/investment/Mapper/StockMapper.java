package com.investment.Mapper;

import com.investment.Dto.Stock.StockList;
import com.investment.Dto.Stock.StockResponse;
import com.investment.Entity.Stock;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class StockMapper {

    public StockResponse stockToStockResponse(Stock stock){
        StockResponse stockResponse = new StockResponse();
        stockResponse.setId(stock.getId());
        stockResponse.setTicker(stock.getTicker());
        return stockResponse;
    }

    public StockList stockResponseToStockList(List<StockResponse> stockResponses) {
        StockList stockList = new StockList();
        stockList.setStocks(stockResponses);
        return stockList;
    }
}

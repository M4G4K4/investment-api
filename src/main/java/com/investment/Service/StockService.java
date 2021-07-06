package com.investment.Service;

import com.investment.Dto.Stock.StockRead;
import com.investment.Dto.Stock.StockResponse;
import com.investment.Entity.Stock;
import com.investment.Mapper.StockMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class StockService {

    @Inject
    StockMapper mapper;

    @Transactional
    public StockResponse insertStock(final StockRead stockRead) {
        Stock stock = new Stock();
        stock.setTicker(stockRead.getTicker());
        stock.persist();
        return mapper.stockToStockResponse(stock);
    }

}

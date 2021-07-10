package com.investment.Service;

import com.investment.Dto.Stock.StockList;
import com.investment.Dto.Stock.StockRead;
import com.investment.Dto.Stock.StockResponse;
import com.investment.Dto.User.UserResponse;
import com.investment.Entity.Stock;
import com.investment.Entity.User;
import com.investment.Exception.CustomException;
import com.investment.Mapper.StockMapper;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StockService {

    @Inject
    StockMapper mapper;

    @Transactional
    public StockResponse insertStock(final StockRead stockRead, final long id) throws CustomException {
        //TODO: Get data from yahoofinanceAPI
        Stock stock = new Stock();
        stock.setTicker(stockRead.getTicker());
        stock.setUser(User.findUserById(id));
        stock.persist();
        return mapper.stockToStockResponse(stock);
    }

    public StockList getAllStocks() {
        final PanacheQuery<Stock> stocks = Stock.findAll();
        final List<StockResponse> stockResponses = stocks.stream()
                                                            .map(mapper::stockToStockResponse)
                                                            .collect(Collectors.toList());
        return mapper.stockResponseToStockList(stockResponses);
    }
}

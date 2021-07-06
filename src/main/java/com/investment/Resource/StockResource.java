package com.investment.Resource;

import com.investment.Dto.Stock.StockRead;
import com.investment.Entity.Stock;
import com.investment.Service.StockService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StockResource {

    @Inject
    StockService stockService;

    @GET
    public List<Stock> list() {
        //TODO: Refactor to service
        return Stock.listAll();
    }

    @POST
    public Response insertStock(@Valid StockRead stockRead) {
        return Response.ok(stockService.insertStock(stockRead)).build();
    }
}

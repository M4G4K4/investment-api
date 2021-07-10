package com.investment.Resource;

import com.investment.Dto.Stock.StockRead;
import com.investment.Exception.CustomException;
import com.investment.Service.StockService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StockResource {

    @Inject
    StockService stockService;

    @GET
    public Response list() {
        return Response.ok(stockService.getAllStocks()).build();
    }

    @POST
    public Response insertStock(@Valid StockRead stockRead, @QueryParam("user")final long id) throws CustomException {
        return Response.ok(stockService.insertStock(stockRead,id)).build();
    }
}

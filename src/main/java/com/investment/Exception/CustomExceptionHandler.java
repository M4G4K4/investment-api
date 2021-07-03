package com.investment.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionHandler implements ExceptionMapper<CustomException> {
    @Override
    public Response toResponse(CustomException exception) {
        return Response.status(exception.getError().getErrorCode()).entity(mapperPayload(exception)).build();
    }

    private Payload mapperPayload(CustomException exception){
        return new Payload(exception.getError().getMessage(),
                exception.getError().getErrorCode(),
                exception.getError().getDetails());
    }
}

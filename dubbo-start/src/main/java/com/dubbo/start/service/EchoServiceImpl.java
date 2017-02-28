package com.dubbo.start.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by bin on 2017/2/28.
 */
@Path(value = "echo")
public class EchoServiceImpl implements  EchoService{
    @GET
    @Path(value = "/{message}")
    public String echo(@PathParam("message") String message) {
        return message;
    }
}

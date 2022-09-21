package br.com.newcake.rest;

import java.ws.rs.core.Response;
import java.es.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;

public class UtilRest {
    
    public Response buildResponse(Object result) {

		try {

			String valorResposta = new Gson().toJson(result);
			return Response.ok(valorResposta).build();
		} catch (Exception ex) {
			ex.printStackTrace();

			return this.buildErrorResponse(ex.getMessage());
		}
	}

	public Response buildErrorResponse(String str) {

		ResponseBuilder rb = Response.status(Response.Status.INTERNAL_SERVER_ERROR);

		rb = rb.entity(str);

		rb = rb.type("text/plain");

		return rb.build();
	}

}

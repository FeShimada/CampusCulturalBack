package br.com.campuscultural.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LoginExceptionMapper implements ExceptionMapper<LoginException> {

    @Override
    public Response toResponse(LoginException exception) {
        String errorMessage = exception.getMessage();
        String jsonError = "{\"error\": \"" + errorMessage + "\"}";

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(jsonError)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

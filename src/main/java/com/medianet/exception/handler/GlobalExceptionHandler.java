package com.medianet.exception.handler;

import com.medianet.controller.responses.DataErrorResponse;
import com.medianet.controller.responses.ProfileNotFoundResponse;
import com.medianet.controller.responses.ServerErrorResponse;
import com.medianet.controller.responses.ServiceNotAvailableResponse;
import com.medianet.exception.ProfileNotFoundException;
import com.medianet.exception.IncorrectDataException;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Component
@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ProfileNotFoundResponse> handleProfileNotFound(ProfileNotFoundException ex) {
        ProfileNotFoundResponse response = new ProfileNotFoundResponse();
        response.setMessage("Profile not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    public ResponseEntity<DataErrorResponse> handleIncorrectDataException(IncorrectDataException ex) {
        DataErrorResponse errorResponse = new DataErrorResponse();
        errorResponse.setMessage("Try to put correct data");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    public ResponseEntity<ServerErrorResponse> handleInternalServerError(Exception ex) {
        ServerErrorResponse response = new ServerErrorResponse();
        response.setMessage("Server error");
        response.setRequest_id(MDC.get("requestId")); // Получаем из MDC
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    public ResponseEntity<ServiceNotAvailableResponse> handleServiceUnavailableException(Exception ex) {
        ServiceNotAvailableResponse response = new ServiceNotAvailableResponse();
        response.setMessage("Service Unavailable");
        response.setRequest_id(MDC.get("requestId"));
        response.setStatus(HttpStatus.SERVICE_UNAVAILABLE);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }
}
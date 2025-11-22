package paymentService.exception;

import java.time.Instant;

public class ApiErrorResponse {

    private Instant timestamp;
    private String error;
    private String message;
    private String path;

    public ApiErrorResponse(String error, String message, String path) {
        this.timestamp = Instant.now();
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Getters and Setters
}

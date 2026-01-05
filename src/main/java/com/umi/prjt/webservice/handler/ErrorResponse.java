package com.umi.prjt.webservice.handler;

public class ErrorResponse {
    private String message;
    private int status;
    private long timestamp;


    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMessage() {
        return message;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public int getStatus() {
        return status;
    }
}

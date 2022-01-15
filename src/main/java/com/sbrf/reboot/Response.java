package com.sbrf.reboot;

public class Response {
    private String statusCode;

    public Response(){
    }
    public Response(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return this.statusCode;
    }
}

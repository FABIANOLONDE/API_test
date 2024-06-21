package com.example.employee.Response;

public class Response {
    String responseMessage;
    String responseStatus;
    Object responseObject;

    public Response(String responseMessage, String responseStatus, Object responseObject) {
        this.responseMessage = responseMessage;
        this.responseStatus = responseStatus;
        this.responseObject = responseObject;
    }

    public Response() {

    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}

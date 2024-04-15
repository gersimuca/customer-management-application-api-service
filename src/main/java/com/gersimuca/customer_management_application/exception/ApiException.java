package com.gersimuca.customer_management_application.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) { super(message);}
    public ApiException() { super("An error occurred");}
}

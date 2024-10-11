package com.example.api_java.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("ID " + id + " không tồn tại");
    }
}

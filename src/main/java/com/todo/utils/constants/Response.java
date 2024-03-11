package com.todo.utils.constants;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Response<T> {
    private int code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Response() {
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Response<T> success(int code, String message, T data) {
        return new Response<>(code, message, data);
    }

    public static <T> Response<T> error(int code, String message) {
        return new Response<>(code, message);
    }
}

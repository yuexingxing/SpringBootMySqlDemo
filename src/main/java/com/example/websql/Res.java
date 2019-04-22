package com.example.websql;

public class Res {

    private int success;
    private int code;
    private Object data;
    private String message;

    public Res() {

    }

    public Res(int success, int code, String message, Object object) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = object;
    }

    public static Res build(int success, int code, String message, Object object) {
        return new Res(success, code, message, object);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
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
}

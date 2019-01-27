package com.example.demo.bean;
import java.util.HashMap;
import java.util.Map;

public class ResponseEntity {

    public static final String ERRORS_KEY = "errors";

    private final String message;
    private final int code;
    private final Map<String, Object> data = new HashMap();

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseEntity putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    private ResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseEntity ok() {
        return new ResponseEntity(200, "Ok");
    }

    public static ResponseEntity notFound() {
        return new ResponseEntity(404, "Not Found");
    }

    public static ResponseEntity badRequest() {
        return new ResponseEntity(400, "Bad Request");
    }

    public static ResponseEntity forbidden() {
        return new ResponseEntity(403, "Forbidden");
    }

    public static ResponseEntity unauthorized() {
        return new ResponseEntity(401, "unauthorized");
    }

    public static ResponseEntity serverInternalError() {
        return new ResponseEntity(500, "Server Internal Error");
    }

    public static ResponseEntity customerError() {
        return new ResponseEntity(1001, "Customer Error");
    }
}


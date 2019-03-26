package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

public class JSONResult {

    public static Map<String, ?> successResult(Object result) {
        return fillResult(Utils.ResultStatus.OK, result);
    }

    public static Map<String, ?> failResult(String message) {
        return fillResult(Utils.ResultStatus.Fail, "", message);
    }

    public static Map<String, ?> errorResult(Exception ex) {
        return fillResult(Utils.ResultStatus.Error, "", ex.getMessage());
    }

    public static Map<String, ?> fillResult(Utils.ResultStatus status, Object result) {
        return fillResult(status, result, "");
    }

    public static Map<String, ?> fillResult(Utils.ResultStatus status, Object result, String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("status", status.toString());
        json.put("message", message);
        json.put("result", result);
        return json;
    }

    public static Map<String, ?> fillPageResult(Object result
            , int pageNumber, int pageSize, long totalEles, int totalPages) {
        return fillPageResult(Utils.ResultStatus.OK, result, pageNumber, pageSize, totalEles, totalPages, "");
    }

    public static Map<String, ?> fillPageResult(Utils.ResultStatus status, Object result
            , int pageNumber, int pageSize, long totalEles, int totalPages) {
        return fillPageResult(status, result, pageNumber, pageSize, totalEles, totalPages, "");
    }

    public static Map<String, ?> fillPageResult(Utils.ResultStatus status, Object result
            , int pageNumber, int pageSize, long totalEles, int totalPages, String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("status", status.toString());
        json.put("message", message);
        json.put("result", result);
        json.put("page", pageNumber + 1);
        json.put("size", pageSize);
        json.put("totalElements", totalEles);
        json.put("totalPages", totalPages);
        return json;
    }
}


package com.wiperi.novuscrm.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private Integer code;
    private String message;
    private Object data;

    // success with data
    public static Result success(Object data) {
        return new Result(200, "Success", data);
    }

    // success no data
    public static Result success() {
        return new Result(200, "Success", null);
    }

    // error
    public static Result error(Integer code, String message) {
        return new Result(code, message, null);
    }
}

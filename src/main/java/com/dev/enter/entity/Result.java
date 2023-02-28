package com.dev.enter.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class Result<T> {
    private String message;
    private String status;
    private int code;
    private T data;
}

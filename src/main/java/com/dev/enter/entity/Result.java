package com.dev.enter.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class Result<T> {
    private String message;
    private boolean status;
    private int code;
    private T data;
}

package com.dev.enter.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {

    /**
     * 经度
     */
    private Double lng;

    /**
     * 纬度
     */
    private Double lat;
}


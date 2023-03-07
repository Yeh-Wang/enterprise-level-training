package com.dev.enter.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dev.enter.entity.Point;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * @Author: liangjunwei
 * @Date: 2021/12/30 16:31
 */
public class DistanceUtil {

    public static final String SHOW_LOCATION = "showLocation&&showLocation";
    public static final String STATUS = "status";
    /**
     * 通过字符串地址获取经纬度
     * @param address
     */
    public static Point getPoint(String address) {
        //配置上自己的百度地图应用的AK
        String applicationId = "6demko5GMTYMabNyxpWDWrMWKtkAnsDb";
        try {
            InputStream urlStream;
            URL url = new URL("https://api.map.baidu.com/geocoding/v3/?address=" + address + "&output=json&ak=" + applicationId + "&callback=showLocation");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            urlStream = connection.getInputStream();
            java.io.BufferedReader reader = new java.io.BufferedReader(new InputStreamReader(urlStream));
            String str = reader.readLine();
            System.out.println(str);
            if(StringUtils.hasLength(str) && str.startsWith(SHOW_LOCATION)){
                str = str.replaceAll("showLocation&&showLocation\\(","");
                str = str.replaceAll("\\)","");
            }
            JSONObject jsonObject = JSON.parseObject(str);
            if(jsonObject.getInteger(STATUS ) != 0) {
                return null;
            }
            JSONObject location = (JSONObject) ((JSONObject) jsonObject.get("result")).get("location");
            //用经度分割返回的网页代码
            return new Point(location.getDouble("lng"),location.getDouble("lat"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 地球半径,进行经纬度运算需要用到的数据之一
     */
    private static final double EARTH_RADIUS = 6378137;

    /**
     * 根据坐标点获取弧度
     * @param d
     * @return
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 根据两点之间经纬度坐标（double值），计算两点之间距离，单位为米
     * @param point1 A点坐标
     * @param point2 B点坐标
     * @return
     */
    public static double getDistance(Point point1, Point point2) {
        double radLat1 = rad(point1.getLat());
        double radLat2 = rad(point2.getLat());
        double a = radLat1 - radLat2;
        double b = rad(point1.getLng()) - rad(point2.getLng());
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }
}
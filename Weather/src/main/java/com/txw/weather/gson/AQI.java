package com.txw.weather.gson;

/**
 * 数据结构如下：
 *  "aqi": {
 *              city": {
 *                       aqi": "120",
 *                       "pm25": "80"
 *                      }
 *          }
 */
public class AQI {

    public AQICity city;

    public class AQICity{
        public String aqi;
        public String pm25;
    }
}

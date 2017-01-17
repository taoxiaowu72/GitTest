package com.txw.weather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 数据结构如下：
 * "basic": {
 *              "city": "苏州",
 *              "id": "CN101190401",
 *              "update": {
 *                          "loc": "2016-12-18 19:51"
 *                        }
 *          }
 */
public class Basic {

    /*
    http://guolin.tech/api/china/16/116
    {"id":937,"name":"苏州","weather_id":"CN101190401"}
    key=860720cc30624026b3ac16562da86357
    */

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }

}

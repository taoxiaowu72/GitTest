package com.txw.weather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 数据结构如下
 *  "now": {
 *              "tmp": "12"
 *              "cond": {
 *                          "code": "101",
 *                          "txt": "多云"
 *                      }
 *          }
 */
public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }

}

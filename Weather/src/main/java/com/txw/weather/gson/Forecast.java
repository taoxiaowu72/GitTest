package com.txw.weather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 数据结构如下：
 *   "daily_forecast": [
 *      {
 *          "date": "2016-12-18",
 *          "cond": {
 *                    "txt_d": "晴",
 *                  },
 *           "tmp": {
 *                     "max": "16",
 *                     "min": "8"
 *                  },
 *      }
 *      ...
 *   ]
 */
public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature{
        public String max;
        public String min;
    }

    public class More{
        @SerializedName("txt_d")
        public String info;
    }

}

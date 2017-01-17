package com.txw.weather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * 数据结构如下：
 *   "suggestion": {
 *                  "comf": {
 *                              "txt": "白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"
 *                          },
 *                  "cw": {
 *                              "txt": "较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"
 *                         },
 *                  "sport": {
 *                              "txt": "天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意防风。"
 *                           }
 *                  }
 */
public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Comfort {
        @SerializedName("txt")
        public String info;
    }

    public class CarWash {
        @SerializedName("txt")
        public String info;
    }

    public class Sport {
        @SerializedName("txt")
        public String info;
    }

}

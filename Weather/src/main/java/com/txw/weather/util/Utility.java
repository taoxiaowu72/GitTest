package com.txw.weather.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.txw.weather.db.City;
import com.txw.weather.db.County;
import com.txw.weather.db.Province;
import com.txw.weather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 解析和处理服务器返回的省市县级数据
 */
public class Utility {

    /**
     * 将服务器返回的JSON数据解析成Weather实体类
     * @param response JSON数据
     * @return Weather实体类
     */
    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 解析并处理省级数据
     *
     * @param response 服务器返回的数据
     * @return
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                //1.解析服务器数据
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    //2.组装省级实体数据
                    //{"id":16,"name":"江苏"}
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    //3.将数据存储到数据库当中
                    province.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析并处理城市级数据
     *
     * @param response   服务器返回的数据
     * @param provinceId 城市对应的省级Id
     * @return
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);

                    //{"id":116,"name":"苏州"}
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析并处理县级数据
     * @param response 服务器返回的数据
     * @param cityId 县对应的城市Id
     * @return
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties=new JSONArray(response);
                for (int i=0;i<allCounties.length();i++){
                    JSONObject countyObject= allCounties.getJSONObject(i);

                    //{"id":937,"name":"苏州","weather_id":"CN101190401"}
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}

package com.dstudio.janwelocampo.mvparchitecture.data.api.retrofit;

import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.CityList;
import com.dstudio.janwelocampo.mvparchitecture.utils.AppConstants;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

public interface ApiInterface {
    public static String APP_ID = "APPID";
    public static String ID = "id";

    @GET(AppConstants.WEATHER_GROUP_CITY_URL)
    Observable<CityList> getWeatherGroup(@QueryMap Map<String, String> params);

}

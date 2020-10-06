package com.app.mvvmkotlin.commons;

import com.app.mvvmkotlin.model.HolidayModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kashif on 9/27/2019.
 */
public interface ApiInterface {

    @GET("PublicHolidays/2019/us")
    Call<List<HolidayModel>> getHolidays();

    @GET("https://date.nager.at/api/v2/PublicHolidays/2020/us")
    Call<List<HolidayModel>> getHolidaysKotlin();

}

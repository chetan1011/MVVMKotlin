package com.app.mvvmkotlin.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.mvvmkotlin.commons.ApiInterface
import com.app.mvvmkotlin.commons.MyApplication
import com.app.mvvmkotlin.model.HolidayModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class HolidayViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = javaClass.simpleName
    fun getHolidayList(): MutableLiveData<List<HolidayModel>> {
        var mutableList: MutableLiveData<List<HolidayModel>> = MutableLiveData()
        var apiInterface=MyApplication.getRetrofitClient().create(ApiInterface::class.java)
        apiInterface.getHolidaysKotlin().enqueue(object: Callback<List<HolidayModel>>{

            override fun onResponse(call: Call<List<HolidayModel>>, response: Response<List<HolidayModel>>) {
                Log.e("TAG", "onResponse response="+response.toString() )

                if(response.isSuccessful){
                    Log.e(TAG, "onResponse response.size="+response.body()?.size )

                    if(response.body()!=null && response.body()?.size!!>0 ) {
                        mutableList.value = response.body()!!

                    }
                }
            }

            override fun onFailure(call: Call<List<HolidayModel>>, t: Throwable) {
                Log.e(TAG, "onFailure call="+call.cancel())
                Log.e(TAG, "onFailure call="+t.message )
            }

        })
        return mutableList
    }
}
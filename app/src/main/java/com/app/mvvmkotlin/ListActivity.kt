package com.app.mvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.mvvmkotlin.commons.MyApplication
import com.app.mvvmkotlin.databinding.ActivityListBinding
import com.app.mvvmkotlin.model.HolidayModel
import com.app.mvvmkotlin.viewmodel.HolidayViewModel

class ListActivity : AppCompatActivity() {
    var binding:ActivityListBinding?=null;
    var holidatViewModel:HolidayViewModel?=null;
    var holidayAdapterKotlin:HolidayAdapterKotlin?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_list)
//        holidatViewModel=ViewModelProviders.of(this).get(HolidayViewModel::class.java)
        holidatViewModel=HolidayViewModel(application);

        binding?.rvMovie?.setHasFixedSize(true);
        val layoutManager = LinearLayoutManager(this)
        binding?.rvMovie?.setLayoutManager(layoutManager)
        binding?.rvMovie?.setItemAnimator(DefaultItemAnimator())

        holidayAdapterKotlin= HolidayAdapterKotlin()
        binding?.rvMovie?.adapter=holidayAdapterKotlin

        if(MyApplication.getInstance().isNetworkAvailable){
            holidatViewModel?.getHolidayList()?.observe(this,object : Observer<List<HolidayModel>>{
                override fun onChanged(t: List<HolidayModel>?) {
                    if (t != null) {
                        holidayAdapterKotlin?.addData(t)
                    }
                }

            })
        }
    }
}
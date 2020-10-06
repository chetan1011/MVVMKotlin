package com.app.mvvmkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvmkotlin.databinding.ItemHolidayJavaBinding
import com.app.mvvmkotlin.model.HolidayModel


class HolidayAdapterKotlin() : RecyclerView.Adapter<HolidayAdapterKotlin.ViewHolder>() {

    var holidayList: List<HolidayModel>

    init {
        holidayList = ArrayList()
    }

    fun addData(arrList: List<HolidayModel>){
        this.holidayList = arrList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int):  ViewHolder {
        val binding: ItemHolidayJavaBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_holiday_java, parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(val binding: ItemHolidayJavaBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(data: Any) {
//            binding.setVariable(BR.viewModel, data)
//            binding.executePendingBindings()
//        }
    }

    override fun getItemCount(): Int {
        return holidayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
//        holder.bind(holidayList.get(pos))

        holder.binding.tvDate.text=holidayList.get(pos).date
        holder.binding.tvName.text=holidayList.get(pos).name
//        holder.binding.executePendingBindings()
    }//onBind


}
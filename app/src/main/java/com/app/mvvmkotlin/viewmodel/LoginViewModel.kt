package com.app.mvvmkotlin.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.app.mvvmkotlin.LoginListener

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val email:String?=null
    val password:String?=null

    var loginListener: LoginListener?=null

    fun onLoginClick(view:View){

        if(loginListener!=null){
            loginListener?.onSuccessLogin(email)
        }
    }

}
package com.app.mvvmkotlin

interface LoginListener {
    fun onSuccessLogin(email: String?)
    fun onFailureLogin()
}
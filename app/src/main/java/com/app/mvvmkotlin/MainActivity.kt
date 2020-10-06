package com.app.mvvmkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.app.mvvmkotlin.databinding.ActivityMainBinding
import com.app.mvvmkotlin.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity(),LoginListener {
    var binding:ActivityMainBinding?=null
    var loginViewModel:LoginViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        loginViewModel=ViewModelProviders.of(this).get(LoginViewModel::class.java)

        binding?.viewModel=loginViewModel

        loginViewModel?.loginListener=this
    }

    override fun onSuccessLogin(email: String?) {

        startActivity(Intent(this,ListActivity::class.java))
       Toast.makeText(this,"onSuccessLogin"+email,Toast.LENGTH_SHORT).show()
    }

    override fun onFailureLogin() {
        Toast.makeText(this,"onFailureLogin",Toast.LENGTH_SHORT).show()
    }
}
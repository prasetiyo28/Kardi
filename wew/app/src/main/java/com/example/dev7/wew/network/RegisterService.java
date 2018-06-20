package com.example.dev7.wew.network;

import android.content.Context;


import com.example.dev7.wew.network.config.RetrofitBuilder;
import com.example.dev7.wew.network.interfaces.RegisterInterface;

import retrofit2.Callback;


public class RegisterService {

    private RegisterInterface registerInterface;

    public RegisterService(Context context) {
        registerInterface = RetrofitBuilder.builder(context)
                .create(RegisterInterface.class);
    }

    public void doRegister(String firstname, String lastname, String email, String password, Callback callback) {
        registerInterface.register(firstname, lastname, email, password).enqueue(callback);
    }

}

package com.rawda.mvp_android_sample.login;

import android.annotation.TargetApi;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.rawda.mvp_android_sample.data.User;

public class LoginModel implements LoginMVP.IModel {
    User user;
    @Override
    public User createUser(String email, String password) {
        return new User(email, password);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean updateUser(String email, String password) {
       if (user != null){
           user.setEmail(email);
           user.setPassword(password);
           return true;
       }
       return false;
    }

    @Override
    public User getUser() {
        return user;
    }
}

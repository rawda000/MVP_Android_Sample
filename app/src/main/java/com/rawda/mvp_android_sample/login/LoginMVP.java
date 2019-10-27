package com.rawda.mvp_android_sample.login;

import android.view.View;

import com.rawda.mvp_android_sample.data.User;

public interface LoginMVP {
    interface IModel {
        //TODO notify view
        User createUser(String email, String password);

        boolean updateUser(String email, String password);

        User getUser();
    }

    interface IPresenter {
        boolean modifyUser(User newUser);

        boolean checkUserIsValid(User user);

        void setView(LoginMVP.IView view);

        boolean loginButtonClicked();
    }

    interface IView {
        void showSuccessMessage();

        void showError();

        void showProgressbar();

        void hideProgressBar();

        void setEmail(String email);

        void setPassword(String password);
    }
}

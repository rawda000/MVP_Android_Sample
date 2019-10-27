package com.rawda.mvp_android_sample.login;

import com.rawda.mvp_android_sample.data.User;

public class LoginPresenter implements LoginMVP.IPresenter {
    LoginMVP.IModel model;
    LoginMVP.IView view;

    public LoginPresenter(LoginMVP.IModel model) {
        this.model = model;
    }

    @Override
    public boolean modifyUser(User newUser) {
        if (newUser == null || !checkUserIsValid(newUser))
            return false;
        model.updateUser(newUser.getEmail(), newUser.getPassword());
        return true;
    }

    @Override
    public boolean checkUserIsValid(User user) {
        if (user == null || user.getEmail().trim().equals("") || user.getPassword().trim().equals(""))
            return false;
        return true;
    }

    @Override
    public void setView(LoginMVP.IView view) {
        this.view = view;
    }

    @Override
    public boolean loginButtonClicked() {
        User user = model.getUser();
        if (model == null || view == null || !checkUserIsValid(user)) {
            view.showError();
            return false;
        }
        model.createUser(user.getEmail(), user.getPassword());
        view.showSuccessMessage();
        return true;
    }
}

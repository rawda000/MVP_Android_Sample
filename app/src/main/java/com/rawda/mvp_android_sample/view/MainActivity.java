package com.rawda.mvp_android_sample.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rawda.mvp_android_sample.R;
import com.rawda.mvp_android_sample.data.User;
import com.rawda.mvp_android_sample.login.LoginMVP;
import com.rawda.mvp_android_sample.login.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginMVP.IView {
    private LoginMVP.IPresenter presenter;
    private LoginMVP.IModel model;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText = findViewById(R.id.email_editText);
        passwordEditText = findViewById(R.id.password_editText);
        loginButton = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.progressbar);

        model.createUser(emailEditText.getText().toString(), passwordEditText.getText().toString());
        presenter = new LoginPresenter(model);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });

    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setEmail(String email) {
        this.emailEditText.setText(email);
    }

    @Override
    public void setPassword(String password) {
        this.passwordEditText.setText(password);
    }

}

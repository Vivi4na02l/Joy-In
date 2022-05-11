package com.example.joyin.scenes.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.joyin.R;
import com.example.joyin.scenes.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnLogin = (Button) this.findViewById(R.id.btnLogin);

        //SETUP UI
        //this.spinner = (ProgressBar) this.findViewById(R.id.welcomeProgressBar);
        //this.loginButton = (Button) this.findViewById(R.id.welcomeLoginButton);
        //this.errorText =  (TextView) this.findViewById(R.id.welcomeErrorTextView);

        //SETUP EVENT LISTENERS
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.this.presenter.login();
            }
        });
    }
}
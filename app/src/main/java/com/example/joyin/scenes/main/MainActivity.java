package com.example.joyin.scenes.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.joyin.R;
import com.example.joyin.dasources.SessionDataSource;
import com.example.joyin.scenes.home.HomeActivity;
import com.example.joyin.scenes.login.LoginActivity;
import com.example.joyin.scenes.register.RegisterActivity;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private Button btnGoToLogin, btnGoToRegister;
    private TextView txtGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        if (SessionDataSource.shared.isUserLoggedIn()) {
            navigateToPrivate();
        }
        // else {
        //    navigateToPublic();
        //}

        btnGoToLogin = (Button) findViewById(R.id.btnGoToLogin);
        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLogin();
            }
        });

        btnGoToRegister = (Button) findViewById(R.id.btnGoToRegister);
        btnGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToRegister();
            }
        });

        txtGuest = (TextView) findViewById(R.id.txtGuest);
        txtGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMain();
            }
        });
    }

        public void navigateToPrivate() {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.setAction(Intent.ACTION_VIEW);
            MainActivity.this.startActivity(intent);
        }

        public void navigateToLogin() {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setAction(Intent.ACTION_VIEW);
            MainActivity.this.startActivity(intent);
        }

        public void navigateToRegister() {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            intent.setAction(Intent.ACTION_VIEW);
            MainActivity.this.startActivity(intent);
        }

        public void navigateToMain() {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            intent.setAction(Intent.ACTION_VIEW);
            MainActivity.this.startActivity(intent);
        }
}
package com.example.joyin.scenes.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.joyin.R;
import com.example.joyin.dasources.SessionDataSource;
import com.example.joyin.scenes.home.HomeActivity;
import com.example.joyin.scenes.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (SessionDataSource.shared.isUserLoggedIn()) {
            navigateToPrivate();
        } else {
            navigateToPublic();
        }

    }

    public void navigateToPublic() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        MainActivity.this.startActivity(intent);
    }

    public void navigateToPrivate() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        MainActivity.this.startActivity(intent);
    }
}
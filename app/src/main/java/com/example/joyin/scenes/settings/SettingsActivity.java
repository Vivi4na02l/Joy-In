package com.example.joyin.scenes.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.joyin.R;
import com.example.joyin.dasources.SessionDataSource;
import com.example.joyin.scenes.friends.FriendsActivity;
import com.example.joyin.scenes.home.HomeActivity;
import com.example.joyin.scenes.main.MainActivity;
import com.example.joyin.scenes.message.MessagesActivity;

public class SettingsActivity extends AppCompatActivity {
    private ImageButton btnGoBack;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnGoBack = (ImageButton) findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });

        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    public void goToHome() {
        Intent intent = new Intent(com.example.joyin.scenes.settings.SettingsActivity.this, HomeActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        com.example.joyin.scenes.settings.SettingsActivity.this.startActivity(intent);
    }

    public void logout() {
        SessionDataSource.shared.signOut();
        Intent intent = new Intent(com.example.joyin.scenes.settings.SettingsActivity.this, MainActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        com.example.joyin.scenes.settings.SettingsActivity.this.startActivity(intent);
    }
}

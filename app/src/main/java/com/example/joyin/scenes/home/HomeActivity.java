package com.example.joyin.scenes.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.joyin.R;
import com.example.joyin.scenes.login.LoginActivity;
import com.example.joyin.scenes.message.MessagesActivity;
import com.example.joyin.scenes.settings.SettingsActivity;
import com.example.joyin.scenes.friends.FriendsActivity;

public class HomeActivity extends AppCompatActivity {

    private ImageButton btnSett, btnFriends, btnMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnMessages = (ImageButton) findViewById(R.id.btnMessages);
        btnMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMessages();
            }
        });

        btnFriends = (ImageButton) findViewById(R.id.btnFriends);
        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFriends();
            }
        });

        btnSett = (ImageButton) findViewById(R.id.btnSett);
        btnSett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSett();
            }
        });
    }

    public void goToMessages() {
        Intent intent = new Intent(HomeActivity.this, MessagesActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        HomeActivity.this.startActivity(intent);

        //Intent intent = new Intent(HomeActivity.this, MessagesActivity.class);
        //intent.setAction(Intent.ACTION_VIEW);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //HomeActivity.this.startActivity(intent);
    }

    public void goToSett() {
        Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        HomeActivity.this.startActivity(intent);

        //Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
        //intent.setAction(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        HomeActivity.this.startActivity(intent);
    }

    public void goToFriends() {
        Intent intent = new Intent(HomeActivity.this, FriendsActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        HomeActivity.this.startActivity(intent);

//        Intent intent = new Intent(HomeActivity.this, FriendsActivity.class);
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        HomeActivity.this.startActivity(intent);
    }
}
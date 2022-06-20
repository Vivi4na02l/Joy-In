package com.example.joyin.scenes.message;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.joyin.R;
import com.example.joyin.scenes.home.HomeActivity;
import com.example.joyin.scenes.settings.SettingsActivity;
import com.example.joyin.scenes.friends.FriendsActivity;

public class MessagesActivity extends AppCompatActivity {

    private ImageButton btnSett, btnFriends, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
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

    public void goToHome() {
        Intent intent = new Intent(MessagesActivity.this, HomeActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        MessagesActivity.this.startActivity(intent);

//        Intent intent = new Intent(MessagesActivity.this, HomeActivity.class);
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        MessagesActivity.this.startActivity(intent);
    }

    public void goToSett() {
        Intent intent = new Intent(MessagesActivity.this, SettingsActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        MessagesActivity.this.startActivity(intent);
//        Intent intent = new Intent(MessagesActivity.this, SettingsActivity.class);
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        MessagesActivity.this.startActivity(intent);
    }

    public void goToFriends() {
        Intent intent = new Intent(MessagesActivity.this, FriendsActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        MessagesActivity.this.startActivity(intent);
//        Intent intent = new Intent(MessagesActivity.this, FriendsActivity.class);
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        MessagesActivity.this.startActivity(intent);
    }
}

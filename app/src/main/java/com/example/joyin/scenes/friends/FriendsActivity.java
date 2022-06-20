package com.example.joyin.scenes.friends;

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
import com.example.joyin.scenes.settings.SettingsActivity;

public class FriendsActivity extends AppCompatActivity {
    private ImageButton btnSett, btnMessages, btnHome;
    private Button btnCreateServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        btnCreateServ = (Button) findViewById(R.id.btnCreateServ);
        btnCreateServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCreateServ();
            }
        });

        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
            }
        });

        btnMessages = (ImageButton) findViewById(R.id.btnMessages);
        btnMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMessages();
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
        Intent intent = new Intent(FriendsActivity.this, HomeActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        FriendsActivity.this.startActivity(intent);

//        Intent intent = new Intent(MessagesActivity.this, HomeActivity.class);
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        MessagesActivity.this.startActivity(intent);
    }

    public void goToSett() {
        Intent intent = new Intent(FriendsActivity.this, SettingsActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        FriendsActivity.this.startActivity(intent);
//        Intent intent = new Intent(MessagesActivity.this, SettingsActivity.class);
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        MessagesActivity.this.startActivity(intent);
    }

    public void goToMessages() {
        Intent intent = new Intent(FriendsActivity.this, MessagesActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        FriendsActivity.this.startActivity(intent);
//        Intent intent = new Intent(MessagesActivity.this, FriendsActivity.class);
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        MessagesActivity.this.startActivity(intent);
    }

    private void goToCreateServ() {
        Intent intent = new Intent(FriendsActivity.this, CreateServActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        FriendsActivity.this.startActivity(intent);
    }
}

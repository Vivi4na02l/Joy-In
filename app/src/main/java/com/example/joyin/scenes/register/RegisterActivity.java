package com.example.joyin.scenes.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joyin.R;
import com.example.joyin.dasources.SessionDataSource;
import com.example.joyin.helpers.Callback;
import com.example.joyin.scenes.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class RegisterActivity<Register> extends AppCompatActivity {

    private Button btnRegister;
    private EditText txtUsername;
    private EditText txtPwd;
    private EditText txtConfirmPwd;
    private TextView txtToLogin;

    private String username = "";
    private String pwd = "";
    private String confirmPwd = "";

    FirebaseAuth auth;
    DatabaseReference dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) this.findViewById(R.id.btnRegister);
        txtUsername = (EditText) this.findViewById(R.id.txtUsername);
        txtPwd = (EditText) this.findViewById(R.id.txtPwd);
        txtConfirmPwd = (EditText) this.findViewById(R.id.txtConfirmPwd);


        //SETUP UI
        //this.spinner = (ProgressBar) this.findViewById(R.id.welcomeProgressBar);
        //this.loginButton = (Button) this.findViewById(R.id.welcomeLoginButton);
        //this.errorText =  (TextView) this.findViewById(R.id.welcomeErrorTextView);

        //SETUP EVENT LISTENERS
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {

               username = txtUsername.getText().toString();
               pwd = txtPwd.getText().toString();
               confirmPwd = txtConfirmPwd.getText().toString();

               if (!username.isEmpty() && !pwd.isEmpty() && !confirmPwd.isEmpty()){

                   if(pwd.length() >= 6){
                       registerUser();
                   }else {
                       Toast.makeText(getApplicationContext(), "The password must be at least 6 characters long.", Toast.LENGTH_SHORT).show();
                   }
               } else {
                   Toast.makeText(getApplicationContext(), "Complete all fields.", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    private void registerUser() {
        SessionDataSource.shared.register(username, pwd, new Callback() {
            @Override
            public void onSuccess(Object responseObject) {
                Toast.makeText(getApplicationContext(), "Registered with success!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                getApplicationContext().startActivity(intent);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(getApplicationContext(),
                    "It´s not possible to connect this user.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
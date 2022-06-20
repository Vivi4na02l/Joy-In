package com.example.joyin.scenes.login;

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
import com.example.joyin.scenes.main.MainActivity;
import com.example.joyin.scenes.register.RegisterActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtUsernameLogin, txtPasswordLogin;
    private TextView txtToRegister;

    private String email = "";
    private String password = "";

    FirebaseAuth auth;
    DatabaseReference dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //código que manda o user para a página de registro
        txtToRegister = (TextView) findViewById(R.id.txtToRegister);
        txtToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToRegister();
            }
        });

        //código que recolhe os dados introduzidos no input ao clicar no botão "Login"
        txtUsernameLogin = (EditText) findViewById(R.id.txtUsernameLogin);
        txtPasswordLogin = (EditText) findViewById(R.id.txtPasswordLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = txtUsernameLogin.getText().toString();
                password = txtPasswordLogin.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                    isUser(email, password);
                } else {
                    Toast.makeText(LoginActivity.this, "These must be filled!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void navigateToRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        LoginActivity.this.startActivity(intent);
    }

    public void isUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this , MainActivity.class));
                finish();
            }
        });
    }
//    public void isUser() {
//        SessionDataSource.shared.login(email, password, new Callback() {
//            @Override
//            public void onSuccess(Object responseObject) {
//                Toast.makeText(LoginActivity.this,
//                        "Welcome and Joy'in!", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                LoginActivity.this.startActivity(intent);
//            }
//
//            @Override
//            public void onError(String error) {
//                Toast.makeText(LoginActivity.this,
//                    "It´s not possible to connect this user.", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public void goToHome(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
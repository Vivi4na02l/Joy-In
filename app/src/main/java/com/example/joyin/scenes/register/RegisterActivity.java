package com.example.joyin.scenes.register;

import androidx.annotation.NonNull;
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
import com.example.joyin.scenes.login.LoginActivity;
import com.example.joyin.scenes.main.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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

    private FirebaseAuth auth;
    DatabaseReference dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) this.findViewById(R.id.btnRegister);
        txtUsername = (EditText) this.findViewById(R.id.txtUsername);
        txtPwd = (EditText) this.findViewById(R.id.txtPwd);
        txtConfirmPwd = (EditText) this.findViewById(R.id.txtConfirmPwd);

        auth = FirebaseAuth.getInstance();
        //FirebaseAuth auth = FirebaseAuth.getInstance();

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
                        registerUser(username, pwd);
                    } else {
                        Toast.makeText(getApplicationContext(), "The password must be at least 6 characters long.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Complete all fields.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registerUser(String user, String pwd) {
        auth.createUserWithEmailAndPassword(user, pwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registered successfully!", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(), "Registration failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
//                    .addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(getApplicationContext(), "Registration failed!", Toast.LENGTH_SHORT).show();
//                }
//            });
    }


//        SessionDataSource.shared.register(user, pwd, new Callback() {
//            @Override
//            public void onSuccess(Object responseObject) {
//                Toast.makeText(getApplicationContext(), "Registered with success!", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                getApplicationContext().startActivity(intent);
//            }
//
//            @Override
//            public void onError(String error) {
//                Toast.makeText(getApplicationContext(),
//                    "It´s not possible to connect this user.", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
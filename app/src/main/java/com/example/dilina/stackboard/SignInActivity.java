package com.example.dilina.stackboard;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import java.util.*;
import org.w3c.dom.Text;

@SuppressWarnings("ConstantConditions")
public class SignInActivity extends Activity {

    private EditText emailField;
    private EditText passwordField;
    private View btnLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);
        emailField = (EditText) findViewById(R.id.email);
        passwordField = (EditText) findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

        //Get Firebase auth instance
        //auth = FirebaseAuth.getInstance();

        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailField.getText().toString().matches("")) {
                    Toast.makeText(SignInActivity.this,"Enter email",Toast.LENGTH_LONG).show();
                } else if (passwordField.getText().toString().matches("")) {
                    Toast.makeText(SignInActivity.this,"Enter password",Toast.LENGTH_LONG).show();
                } else {
                    //requesting Firebase server
                    showProcessDialog();
                    authenticateUser(emailField.getText().toString(),passwordField.getText().toString());
                }
            }
        });*/


        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if("dilina".equals(emailField.getText().toString())&& "1234".equals(passwordField.getText().toString())) {
                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else if("lecturer".equals(emailField.getText().toString())&& "1234".equals(passwordField.getText().toString())){
                    Intent intent = new Intent(SignInActivity.this,new_archive.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(SignInActivity.this,"Check Email & Password",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void authenticateUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // When login failed
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignInActivity.this,"Login Error",Toast.LENGTH_LONG).show();
                        } else {
                            //When login successful, redirect user to main activity
                            Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                            startActivity(intent);
                            progressDialog.dismiss();
                            finish();
                        }
                    }
                });
    }

    private void showProcessDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Logging in Firebase server...");
        progressDialog.show();
    }
}
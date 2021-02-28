package com.example.stepintothefuture2065;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class SignIn extends AppCompatActivity {

    EditText etEmail, etPass;
    Button btnSignIn, btnSignUp;

    FirebaseAuth auth;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        sharedPref = getSharedPreferences("userInfo", MODE_PRIVATE);
        String email =sharedPref.getString("email", "");
        if(!email.equals("")){
            Intent intent = new Intent(SignIn.this, NavigationActivity.class);
            startActivity(intent);
        }
        else{
            setContentView(R.layout.activity_sign_in);
        }

        etEmail = findViewById(R.id.etEmail_SignIn);
        etPass = findViewById(R.id.etPassword_SignIn);

        btnSignIn = findViewById(R.id.btnSignUp2);
        btnSignUp = findViewById(R.id.btnSignUp);
        auth = FirebaseAuth.getInstance();



        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPass.getText().toString();

                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(SignIn.this, "Заполните все поля!", Toast.LENGTH_SHORT).show();
                }
                else{
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {

                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString("email", email);
                                editor.apply();

                                Intent intent = new Intent(SignIn.this, NavigationActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(SignIn.this, "Ошибка при входе!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
package com.example.stepintothefuture2065;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
    }

    public void chat_onClick(View view) {
        Intent intent = new Intent(this, ChatList.class);
        startActivity(intent);
    }
}
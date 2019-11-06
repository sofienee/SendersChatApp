package com.example.senderschatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RoomsActivity extends AppCompatActivity {
    private Button classBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        classBtn=findViewById(R.id.dsi32Btn);
        classBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartMainActivity();
            }
        });
    }

    private void StartMainActivity() {
        Intent intent=new Intent(this, MainActivity.class);
        intent.putExtra("class", "DSI32");
        startActivity(intent);
    }
}

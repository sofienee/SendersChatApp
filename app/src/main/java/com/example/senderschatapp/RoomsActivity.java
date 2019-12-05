package com.example.senderschatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RoomsActivity extends AppCompatActivity {
    private Button classBtn;
    private Button classBtn31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        classBtn = findViewById(R.id.dsi32Btn);
        classBtn31 = findViewById(R.id.dsi31Btn);
        classBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartMainActivity();
            }
        });
        classBtn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StartMainActivity31();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:

                startHome();
                return (true);
            case R.id.rooms:

                startRooms();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    private void startRooms() {
        Intent intent = new Intent(this, RoomsActivity.class);
        startActivity(intent);
    }

    private void startHome() {
        Intent intent = new Intent(this, GoogleSignInActivity.class);
        startActivity(intent);
    }

    private void StartMainActivity31() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("class", "DSI31");
        startActivity(intent);
    }

    private void StartMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("class", "DSI32");
        startActivity(intent);
    }
}

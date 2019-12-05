package com.example.senderschatapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]
    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private Button msgBtn;
    private EditText msgEdit;
    private TextView classtext ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classtext=findViewById(R.id.roomsClass);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            classtext.setText(bundle.getString("class"));
            getSupportActionBar().setTitle(bundle.getString("class"));
        }
       msgBtn=findViewById(R.id.SendBtn);
       msgEdit=findViewById(R.id.Msg);


        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]
         final FirebaseUser currentUser = mAuth.getCurrentUser();
        msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Message msg=new Message(currentUser.getDisplayName(),msgEdit.getText().toString(),currentUser.getPhotoUrl().toString());


                // Write a message to the database

                DatabaseReference myRef = database.getReference("messages");
                myRef.child(classtext.getText().toString()).push().setValue(msg);
                msgEdit.setText("");


            }



        });

        final DatabaseReference myRef = database.getReference("messages").child(classtext.getText().toString());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ListView listView=findViewById(R.id.ListMsg);
                ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
                     SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,
                             listItem,
                             R.layout.itemchat,
                             new String[]{"msg", "sender"},
                             new int[]{R.id.msgChat, R.id.userNameItem});
                     listView.setAdapter(adapter);

                     for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                         HashMap map;
                         map = new HashMap<>();
                         map.put("sender", postSnapshot.child("sender").getValue().toString());
                         map.put("msg", postSnapshot.child("msg").getValue().toString());
                         listItem.add(map);
                         adapter.notifyDataSetChanged();
                     }
                 }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

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
        return(super.onOptionsItemSelected(item));
    }

    private void startRooms() {
        Intent intent=new Intent(this, RoomsActivity.class);
        startActivity(intent);
    }

    private void startHome() {
        Intent intent=new Intent(this, GoogleSignInActivity.class);
        startActivity(intent);
    }


}

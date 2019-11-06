package com.example.senderschatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {
 /*  private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser=mAuth.getCurrentUser();

        DatabaseReference myRef = database.getReference("rooms").child(currentUser.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                ListView listView=findViewById(R.id.listRoomes);
                ArrayList arrayList=new ArrayList();
                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
                listView.setAdapter(adapter);

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                        arrayList.add(postSnapshot.child("resiver").getValue());
                        adapter.notifyDataSetChanged();


                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });



        Button roomAdd=findViewById(R.id.roomsBtn);
        roomAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                EditText resiver=findViewById(R.id.roomEmail);
                Rooms rooms=new Rooms(currentUser.getUid(),currentUser.getEmail(),resiver.getText().toString());
                DatabaseReference myRef = database.getReference("rooms");
                myRef.child(currentUser.getUid()).push().setValue(rooms);
                resiver.setText("");
            }
        });


    }*/
}

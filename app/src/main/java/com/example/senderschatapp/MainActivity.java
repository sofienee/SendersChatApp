package com.example.senderschatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import static android.view.View.*;

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
                myRef.child(currentUser.getUid()).child(classtext.getText().toString()).push().setValue(msg);
                msgEdit.setText("");


            }



        });

        DatabaseReference myRef = database.getReference("messages").child(currentUser.getUid()).child(classtext.getText().toString());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ImageView imageView;
                imageView=findViewById(R.id.imgChatRoom);

                ListView listView=findViewById(R.id.ListMsg);
                ArrayList arrayList=new ArrayList();
                ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
                SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,
                        listItem,
                        R.layout.itemchat,
                        new String[]{"img", "msg", "sender"},
                        new int[]{R.id.imgChatRoom, R.id.msgChat, R.id.userNameItem});
                listView.setAdapter(adapter);



                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {


                    HashMap map;
                    map = new HashMap<>();
                    map.put("sender", postSnapshot.child("sender").getValue().toString());
                    map.put("msg",postSnapshot.child("msg").getValue().toString());
                    map.put("img", String.valueOf(R.drawable.ic_person_black_24dp));

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



}

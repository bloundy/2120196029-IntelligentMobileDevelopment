package com.example.userhobbyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetailActivity extends AppCompatActivity {

    private Button btnStore, btnGetall;
    private EditText etname, ethobby, etcity;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        databaseHelper = new DatabaseHelper(this);

        btnStore = findViewById(R.id.btnstore);
        btnGetall = findViewById(R.id.btnget);
        etname = findViewById(R.id.etname);
        ethobby = findViewById(R.id.ethobby);
        etcity = findViewById(R.id.etcity);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addUser(etname.getText().toString(), ethobby.getText().toString(), etcity.getText().toString());
                etname.setText("");
                ethobby.setText("");
                etcity.setText("");
                Toast.makeText(UserDetailActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetailActivity.this, GetAllUsersActivity.class);
                startActivity(intent);
            }
        });
    }
    }

package com.tutorials.myfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.tutorials.myfriend.models.Friend;

public class AddFriend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        ImageButton btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Friend friend = new Friend("New Friend", "friend@gmail.com", "098554663");
                Intent intent = new Intent();
                intent.putExtra("FRIEND", friend);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
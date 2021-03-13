package com.tutorials.myfriend;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;

import com.tutorials.myfriend.adapters.FriendAdapter;
import com.tutorials.myfriend.models.Friend;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int FRIEND_ADDED = 1;
    private List<Friend> friends;
    private FriendAdapter friendAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvFriend = findViewById(R.id.rvFriend);
        friends = new ArrayList<>();
        friends.add(new Friend("Long Vu", "longvu@gmail.com","0978588749"));
        friends.add(new Friend("Hoang Bao", "hoangbao@gmail.com","0645899533"));
        friends.add(new Friend("Gia Han", "giahan@gmail.com","0648955788"));

        friendAdapter = new FriendAdapter(friends);
        rvFriend.setAdapter(friendAdapter);
        rvFriend.setLayoutManager(new LinearLayoutManager(this));

        ImageButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddFriend.class);
                startActivityForResult(intent, FRIEND_ADDED);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == FRIEND_ADDED){
           Friend friend = (Friend) data.getSerializableExtra("FRIEND");
            friends.add(0, friend);
            friendAdapter.notifyItemInserted(0);
        }
    }
}
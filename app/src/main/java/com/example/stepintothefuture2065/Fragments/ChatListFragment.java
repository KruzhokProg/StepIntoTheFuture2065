package com.example.stepintothefuture2065.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stepintothefuture2065.Adapters.ChatListAdapter;
import com.example.stepintothefuture2065.Adapters.IChatListClickListener;
import com.example.stepintothefuture2065.Model.User;
import com.example.stepintothefuture2065.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatListFragment extends Fragment implements IChatListClickListener {

    private RecyclerView rvListChat;
    private ChatListAdapter chatListAdapter;
    private List<User> userList;

    public ChatListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_list, container, false);
        rvListChat = view.findViewById(R.id.rvChatList);
        userList = new ArrayList<>();

        readUsers();


        return view;
    }

    private void readUsers() {
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);

                    if(!user.getId().equals(firebaseUser.getUid())){
                        userList.add(user);
                    }
                }

                chatListAdapter = new ChatListAdapter(userList, getContext() );
                rvListChat.setAdapter(chatListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onChatListClickListener(int position) {

    }
}
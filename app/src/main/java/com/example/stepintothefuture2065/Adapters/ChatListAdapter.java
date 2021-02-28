package com.example.stepintothefuture2065.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.stepintothefuture2065.ChatActivity;
import com.example.stepintothefuture2065.Model.User;
import com.example.stepintothefuture2065.R;

import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListViewHolder> {

    List<User> users;
    Context context;

    public ChatListAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_chat_list, parent, false);
        return new ChatListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, int position) {

        User user = users.get(position);
        holder.tvUsername.setText(user.getUsername());
        if(user.getImageURL().equals("default")){
            holder.imgvUserProfile.setImageResource(R.drawable.user_profile);
        }else {
            Glide.with(context).load(user.getImageURL()).into(holder.imgvUserProfile);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("userId", user.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(users!=null){
            return users.size();
        }
        return 0;
    }
}

package com.example.stepintothefuture2065.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stepintothefuture2065.R;

public class ChatListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tvUsername, tvLastmsg, tvTimeOnlinePassed, tvCountUnreadMsg;
    public ImageView imgvUserProfile;
    IChatListClickListener chatListClickListener;

    public ChatListViewHolder(@NonNull View itemView) {
        super(itemView);

        this.chatListClickListener = chatListClickListener;
        tvUsername = itemView.findViewById(R.id.tvRvItemUsername);
        tvLastmsg = itemView.findViewById(R.id.tvRvItemLastMsg);
        tvTimeOnlinePassed = itemView.findViewById(R.id.tvTimePassed);
        tvCountUnreadMsg = itemView.findViewById(R.id.tvRvItemCountUnreadMsg);
        imgvUserProfile = itemView.findViewById(R.id.imgvRvItem);
    }

    @Override
    public void onClick(View v) {
        chatListClickListener.onChatListClickListener(getAdapterPosition());
    }
}

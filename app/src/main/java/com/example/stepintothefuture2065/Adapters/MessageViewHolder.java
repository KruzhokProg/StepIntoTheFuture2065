package com.example.stepintothefuture2065.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stepintothefuture2065.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    public TextView show_message;
    public TextView time;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);

        show_message = itemView.findViewById(R.id.show_message);
        time = itemView.findViewById(R.id.tv_msg_time);
    }
}

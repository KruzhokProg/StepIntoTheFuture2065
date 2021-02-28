package com.example.stepintothefuture2065.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stepintothefuture2065.R;

public class rvViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ConstraintLayout layoutImage;
    public TextView title, info;

    public rvViewHolder(@NonNull View itemView) {
        super(itemView);

        layoutImage = itemView.findViewById(R.id.layoutImage);
        title = itemView.findViewById(R.id.tvTitleRvITem);
        info = itemView.findViewById(R.id.tvInfoRvItem);
    }

    @Override
    public void onClick(View v) {

    }
}

package com.example.stepintothefuture2065.Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stepintothefuture2065.R;

public class LectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ConstraintLayout lectionImage;
    public TextView lectionTitle, lectionInfo;

    public LectionViewHolder(@NonNull View itemView) {
        super(itemView);

        lectionImage = itemView.findViewById(R.id.lectionImage);
        lectionTitle = itemView.findViewById(R.id.tvTitleLectionRvITem);
        lectionInfo = itemView.findViewById(R.id.tvInfoRvItemLection);
    }

    @Override
    public void onClick(View v) {

    }
}

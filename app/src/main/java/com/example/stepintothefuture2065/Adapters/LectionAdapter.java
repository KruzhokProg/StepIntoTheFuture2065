package com.example.stepintothefuture2065.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stepintothefuture2065.Model.Lection;
import com.example.stepintothefuture2065.Model.User;
import com.example.stepintothefuture2065.R;
import java.util.List;


public class LectionAdapter extends RecyclerView.Adapter<LectionViewHolder> {

    List<Lection> lections;
    Context context;

    public LectionAdapter(Context context, List<Lection> lectionList) {
        this.context = context;
        lections = lectionList;
    }

    @NonNull
    @Override
    public LectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_lection, parent, false);
        return new LectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LectionViewHolder holder, int position) {
        Lection lection = lections.get(position);

        holder.lectionTitle.setText(lections.get(position).getTitle());
        holder.lectionInfo.setText(lections.get(position).getInfo());
        holder.lectionImage.setBackground(ContextCompat.getDrawable(context, lections.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        if(lections!=null){
            return lections.size();
        }
        return 0;
    }
}

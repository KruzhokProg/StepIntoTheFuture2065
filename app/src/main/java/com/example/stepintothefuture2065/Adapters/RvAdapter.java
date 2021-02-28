package com.example.stepintothefuture2065.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stepintothefuture2065.Model.RvModel;
import com.example.stepintothefuture2065.R;
import java.util.List;


public class RvAdapter extends RecyclerView.Adapter<rvViewHolder> {

    List<RvModel> modelList;
    Context context;

    public RvAdapter(Context context, List<RvModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public rvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_account, parent, false);
        return new rvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvViewHolder holder, int position) {
        RvModel lection = modelList.get(position);

        holder.title.setText(modelList.get(position).getTitle());
        holder.info.setText(modelList.get(position).getInfo());
        holder.layoutImage.setBackground(ContextCompat.getDrawable(context, modelList.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        if(modelList!=null){
            return modelList.size();
        }
        return 0;
    }
}

package com.example.stepintothefuture2065.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stepintothefuture2065.Adapters.RvAdapter;
import com.example.stepintothefuture2065.Model.RvModel;
import com.example.stepintothefuture2065.R;
import com.example.stepintothefuture2065.SignIn;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class AccountFragment extends Fragment {

    RecyclerView rvLections, rvArticles, rvPodcasts;
    RvAdapter lectionAdapter, articleAdapter, podcastAdapter;
    List<RvModel> lectionList, articleList, podcastList;
    TextView tvUserName;
    SharedPreferences sharedPref;
    ImageView imgvExit;

    public AccountFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        rvLections = view.findViewById(R.id.rvLections);
        rvArticles = view.findViewById(R.id.rvArticles);
        rvPodcasts = view.findViewById(R.id.rvPodcasts);
        tvUserName = view.findViewById(R.id.tvNameUser);
        imgvExit = view.findViewById(R.id.imgv_exit);

        imgvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref = getContext().getSharedPreferences("userInfo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("email","");
                editor.apply();
                Intent i = new Intent(getContext(), SignIn.class);
                startActivity(i);
            }
        });

        sharedPref = getContext().getSharedPreferences("userInfo", MODE_PRIVATE);
        String email =sharedPref.getString("email", "");
        tvUserName.setText(email);

        lectionList = new ArrayList<>();
        lectionList.add(new RvModel(1, "Первые шаги в 3D моделировании", "8 октября 2020 · 13К просмотров", R.drawable.lection));
        lectionList.add(new RvModel(2, "3D моделирование и визуализация", "1 сенятбря 2020 · 8К просмотров", R.drawable.lection2));
        lectionList.add(new RvModel(1, "Первые шаги в 3D моделировании", "8 октября 2020 · 13К просмотров", R.drawable.lection));
        lectionList.add(new RvModel(2, "3D моделирование и визуализация", "1 сенятбря 2020 · 8К просмотров", R.drawable.lection2));

        articleList = new ArrayList<>();
        articleList.add(new RvModel(1, "Представлены AMD Ryzen 5000", "16 сенятбря 2020 · 10К просмотров", R.drawable.article1));
        articleList.add(new RvModel(1, "5 игр на ПК для тех, кому нравится RDR 2", "2 сенятбря 2020 · 18К просмотров", R.drawable.article1));
        articleList.add(new RvModel(1, "Представлены AMD Ryzen 5000", "16 сенятбря 2020 · 10К просмотров", R.drawable.article1));
        articleList.add(new RvModel(1, "5 игр на ПК для тех, кому нравится RDR 2", "2 сенятбря 2020 · 18К просмотров", R.drawable.article1));

        podcastList = new ArrayList<>();
        podcastList.add(new RvModel(1, "3D-МОДЕЛИРОВАНИЕ В ИГРАХ", "16 сенятбря 2020 · 10К просмотров", R.drawable.podcast1));
        podcastList.add(new RvModel(1, "Где лучше учиться 3D-моделированию?", "12 сенятбря 2020 · 18К просмотров", R.drawable.podcast2));
        podcastList.add(new RvModel(1, "3D-МОДЕЛИРОВАНИЕ В ИГРАХ", "16 сенятбря 2020 · 10К просмотров", R.drawable.podcast1));
        podcastList.add(new RvModel(1, "Где лучше учиться 3D-моделированию?", "12 сенятбря 2020 · 18К просмотров", R.drawable.podcast2));

        lectionAdapter = new RvAdapter(getContext(), lectionList);
        articleAdapter = new RvAdapter(getContext(), articleList);
        podcastAdapter = new RvAdapter(getContext(), podcastList);

        rvLections.setAdapter(lectionAdapter);
        rvArticles.setAdapter(articleAdapter);
        rvPodcasts.setAdapter(podcastAdapter);

        return view;
    }
}
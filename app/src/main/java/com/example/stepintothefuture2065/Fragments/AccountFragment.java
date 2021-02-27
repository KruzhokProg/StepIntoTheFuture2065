package com.example.stepintothefuture2065.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stepintothefuture2065.Adapters.LectionAdapter;
import com.example.stepintothefuture2065.Model.Lection;
import com.example.stepintothefuture2065.R;

import java.util.ArrayList;
import java.util.List;


public class AccountFragment extends Fragment {

    RecyclerView rvLections, rvArticles;
    LectionAdapter adapter;
    List<Lection> lectionList;

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
        lectionList = new ArrayList<>();
        lectionList.add(new Lection(1, "Первые шаги в 3D моделировании", "8 октября 2020 · 13К просмотров", R.drawable.lection));
        lectionList.add(new Lection(2, "3D моделирование и визуализация", "1 сенятбря 2020 · 8К просмотров", R.drawable.lection2));
        adapter = new LectionAdapter(getContext(), lectionList);
        rvLections.setAdapter(adapter);
        rvArticles.setAdapter(adapter);

        return view;
    }
}
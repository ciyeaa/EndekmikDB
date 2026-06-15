package com.difa.endemikdb.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.difa.endemikdb.R;

public class TumbuhanFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        
        EndemikAdapter adapter = new EndemikAdapter();
        recyclerView.setAdapter(adapter);

        EndemikViewModel viewModel = new ViewModelProvider(this).get(EndemikViewModel.class);
        viewModel.getEndemikByCategory("Tumbuhan").observe(getViewLifecycleOwner(), adapter::setData);

        adapter.setOnItemClickListener(endemik -> {
            Intent intent = new Intent(getActivity(), com.difa.endemikdb.ui.detail.DetailActivity.class);
            intent.putExtra("endemik", endemik);
            startActivity(intent);
        });

        return view;
    }
}
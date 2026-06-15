package com.difa.endemikdb.ui.favorit;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.difa.endemikdb.R;
import com.difa.endemikdb.model.Endemik;
import com.difa.endemikdb.model.Favorit;
import com.difa.endemikdb.ui.home.EndemikAdapter;
import com.difa.endemikdb.ui.home.EndemikViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoritActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewFavorit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EndemikAdapter adapter = new EndemikAdapter();
        recyclerView.setAdapter(adapter);

        EndemikViewModel viewModel = new ViewModelProvider(this).get(EndemikViewModel.class);
        viewModel.getAllFavorit().observe(this, favorits -> {
            List<Endemik> endemiks = new ArrayList<>();
            for (Favorit f : favorits) {
                Endemik e = new Endemik();
                e.setId(f.getEndemikId());
                e.setName(f.getName());
                e.setCategory(f.getCategory());
                e.setDescription(f.getDescription());
                e.setImageUrl(f.getImageUrl());
                e.setRegion(f.getRegion());
                e.setLatinName(f.getLatinName());
                e.setFamily(f.getFamily());
                e.setGenus(f.getGenus());
                e.setDistribution(f.getDistribution());
                e.setStatus(f.getStatus());
                endemiks.add(e);
            }
            adapter.setData(endemiks);
        });

        adapter.setOnItemClickListener(endemik -> {
            Intent intent = new Intent(this, com.difa.endemikdb.ui.detail.DetailActivity.class);
            intent.putExtra("endemik", endemik);
            startActivity(intent);
        });
    }
}
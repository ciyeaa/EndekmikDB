package com.difa.endemikdb.ui.search;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.difa.endemikdb.R;
import com.difa.endemikdb.ui.home.EndemikAdapter;
import com.difa.endemikdb.ui.home.EndemikViewModel;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchView searchView = findViewById(R.id.searchView);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewSearch);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EndemikAdapter adapter = new EndemikAdapter();
        recyclerView.setAdapter(adapter);

        EndemikViewModel viewModel = new ViewModelProvider(this).get(EndemikViewModel.class);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.searchEndemik(query).observe(SearchActivity.this, adapter::setData);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.searchEndemik(newText).observe(SearchActivity.this, adapter::setData);
                return true;
            }
        });

        adapter.setOnItemClickListener(endemik -> {
            android.content.Intent intent = new android.content.Intent(this, com.difa.endemikdb.ui.detail.DetailActivity.class);
            intent.putExtra("endemik", endemik);
            startActivity(intent);
        });
    }
}
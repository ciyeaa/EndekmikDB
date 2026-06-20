package com.difa.endemikdb.ui.detail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.difa.endemikdb.R;
import com.difa.endemikdb.model.Endemik;
import com.difa.endemikdb.ui.home.EndemikViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {
    private Endemik endemik;
    private EndemikViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        endemik = (Endemik) getIntent().getSerializableExtra("endemik");
        
        if (endemik == null) {
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        ImageView image = findViewById(R.id.detail_image);
        TextView name = findViewById(R.id.detail_name);
        TextView latin = findViewById(R.id.detail_latin);
        TextView info = findViewById(R.id.detail_info);
        TextView description = findViewById(R.id.detail_description);
        FloatingActionButton fabFavorit = findViewById(R.id.fab_favorit);

        name.setText(endemik.getName());
        latin.setText(endemik.getLatinName());
        
        String detailInfo = "Keluarga: " + endemik.getFamily() + "\n" +
                           "Genus: " + endemik.getGenus() + "\n" +
                           "Asal: " + endemik.getRegion() + "\n" +
                           "Status: " + endemik.getStatus();
        info.setText(detailInfo);
        
        description.setText(endemik.getDescription());
        
        Glide.with(this)
                .load(endemik.getImageUrl())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(image);

        viewModel = new ViewModelProvider(this).get(EndemikViewModel.class);
        
        fabFavorit.setOnClickListener(v -> {
            viewModel.toggleFavorit(endemik, isAdded -> {
                runOnUiThread(() -> {
                    if (isAdded) {
                        Toast.makeText(this, "Ditambahkan ke Favorit", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Dihapus dari Favorit", Toast.LENGTH_SHORT).show();
                    }
                });
            });
        });
    }
}
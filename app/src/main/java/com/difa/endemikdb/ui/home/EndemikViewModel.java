package com.difa.endemikdb.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.difa.endemikdb.data.local.AppDatabase;
import com.difa.endemikdb.data.local.EndemikDao;
import com.difa.endemikdb.model.Endemik;
import com.difa.endemikdb.model.Favorit;

import java.util.List;
import java.util.concurrent.Executors;

public class EndemikViewModel extends AndroidViewModel {
    private final EndemikDao dao;

    public EndemikViewModel(@NonNull Application application) {
        super(application);
        dao = AppDatabase.getInstance(application).endemikDao();
    }

    public LiveData<List<Endemik>> getEndemikByCategory(String category) {
        return dao.getEndemikByCategory(category);
    }

    public LiveData<List<Endemik>> getAllEndemik() {
        return dao.getAllEndemik();
    }

    public LiveData<List<Favorit>> getAllFavorit() {
        return dao.getAllFavorit();
    }

    public void toggleFavorit(Endemik e) {
        Executors.newSingleThreadExecutor().execute(() -> {
            Favorit existing = dao.getFavoritById(e.getId());
            if (existing == null) {
                Favorit f = new Favorit();
                f.setEndemikId(e.getId());
                f.setName(e.getName());
                f.setCategory(e.getCategory());
                f.setDescription(e.getDescription());
                f.setImageUrl(e.getImageUrl());
                f.setRegion(e.getRegion());
                f.setLatinName(e.getLatinName());
                f.setFamily(e.getFamily());
                f.setGenus(e.getGenus());
                f.setDistribution(e.getDistribution());
                f.setStatus(e.getStatus());
                dao.insertFavorit(f);
            } else {
                dao.deleteFavoritById(e.getId());
            }
        });
    }

    public LiveData<List<Endemik>> searchEndemik(String query) {
        return dao.searchEndemik(query);
    }
}
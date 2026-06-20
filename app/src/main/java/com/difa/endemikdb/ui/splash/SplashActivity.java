package com.difa.endemikdb.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.difa.endemikdb.R;
import com.difa.endemikdb.data.local.AppDatabase;
import com.difa.endemikdb.data.remote.RetrofitClient;
import com.difa.endemikdb.model.Endemik;
import com.difa.endemikdb.ui.home.HomeActivity;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AppDatabase db = AppDatabase.getInstance(this);
        Executors.newSingleThreadExecutor().execute(() -> {
            int count = db.endemikDao().getEndemikCount();
            if (count == 0) {
                runOnUiThread(this::fetchDataFromApi);
            } else {
                new Handler(getMainLooper()).postDelayed(this::goToHome, 2000);
            }
        });
    }

    private void fetchDataFromApi() {
        RetrofitClient.getApiService().getEndemikData().enqueue(new Callback<List<Endemik>>() {
            @Override
            public void onResponse(@NonNull Call<List<Endemik>> call, @NonNull Response<List<Endemik>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    saveDataToRoom(response.body());
                } else {
                    Toast.makeText(SplashActivity.this, "Gagal sinkronisasi data", Toast.LENGTH_SHORT).show();
                    goToHome();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Endemik>> call, @NonNull Throwable t) {
                Log.e("SplashActivity", "Error: " + t.getMessage());
                goToHome();
            }
        });
    }

    private void saveDataToRoom(List<Endemik> data) {
        Executors.newSingleThreadExecutor().execute(() -> {
            AppDatabase.getInstance(this).endemikDao().insertAll(data);
            runOnUiThread(this::goToHome);
        });
    }

    private void goToHome() {
        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        finish();
    }
}
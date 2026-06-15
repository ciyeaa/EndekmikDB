package com.difa.endemikdb.data.remote;

import com.difa.endemikdb.model.Endemik;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("data_endemik/endemik.json")
    Call<List<Endemik>> getEndemikData();
}
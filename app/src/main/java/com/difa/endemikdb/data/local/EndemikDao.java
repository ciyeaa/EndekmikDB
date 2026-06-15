package com.difa.endemikdb.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.difa.endemikdb.model.Endemik;
import com.difa.endemikdb.model.Favorit;

import java.util.List;

@Dao
public interface EndemikDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Endemik> endemiks);

    @Query("SELECT * FROM endemik")
    LiveData<List<Endemik>> getAllEndemik();

    @Query("SELECT * FROM endemik WHERE category = :category")
    LiveData<List<Endemik>> getEndemikByCategory(String category);

    @Query("SELECT * FROM endemik WHERE name LIKE '%' || :query || '%'")
    LiveData<List<Endemik>> searchEndemik(String query);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavorit(Favorit favorit);

    @Delete
    void deleteFavorit(Favorit favorit);

    @Query("SELECT * FROM favorit")
    LiveData<List<Favorit>> getAllFavorit();

    @Query("SELECT * FROM favorit WHERE endemikId = :endemikId")
    Favorit getFavoritById(String endemikId);
    
    @Query("DELETE FROM favorit WHERE endemikId = :endemikId")
    void deleteFavoritById(String endemikId);

    @Query("SELECT COUNT(*) FROM endemik")
    int getEndemikCount();
}
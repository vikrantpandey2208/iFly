package com.ifly;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TargetDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(TargetTable target);

    @Query("DELETE FROM target_table")
    void deleteAll();

    @Query("SELECT * FROM target_table ORDER BY target_id ASC")
    LiveData<List<TargetTable>> getAlphabetizedTargets();

    @Query("SELECT * FROM target_table ORDER BY dayRemaining ASC")
    LiveData<List<TargetTable>> getRemainingDayAsc();

    @Query("UPDATE target_table SET totalWork=:newTotal WHERE target_id = :id")
    void updateTotalWork(int newTotal, int id);
}

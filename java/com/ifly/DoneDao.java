package com.ifly;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DoneDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(DoneTable done);

    @Query("DELETE FROM done_table")
    void deleteAll();

    @Query("SELECT * FROM done_table order by done_id desc")
    LiveData<List<DoneTable>> getAllDoneDetailByTargetItAsc();

}

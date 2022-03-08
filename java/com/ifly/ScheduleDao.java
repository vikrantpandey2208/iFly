package com.ifly;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(ScheduleTable entry);

    @Query("DELETE FROM schedule_table")
    void deleteAll();

    @Query("SELECT * FROM schedule_table order by schedule_id asc")
    LiveData<List<ScheduleTable>> getAllScheduleEntry();

    @Query("Update schedule_table set task = :task where slot = :slot")
    void setNewTaskToSlot(String slot, String task);
}

package com.ifly;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "schedule_table")
public class ScheduleTable {

    private String  slot;
    private String task;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "schedule_id")
    private int schId;

    public ScheduleTable(String slot, String task) {
        this.slot = slot;
        this.task = task;
    }

    public String getSlot() {
        return slot;
    }

    public String getTask() {
        return task;
    }

    public int getSchId() {
        return schId;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setSchId(int schId) {
        this.schId = schId;
    }
}

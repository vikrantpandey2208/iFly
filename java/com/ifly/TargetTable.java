package com.ifly;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;


@Entity(tableName = "target_table")
public class TargetTable {

    private String targetName;
    private int dayRemaining;
    private int totalWork, doneWork;
    private String expectedDate;
    private  boolean isDone;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "target_id")
    private int id;

    public TargetTable(String targetName, int dayRemaining, int totalWork, int doneWork, String expectedDate, boolean isDone) {
        this.targetName = targetName;
        this.dayRemaining = dayRemaining;
        this.totalWork = totalWork;
        this.doneWork = doneWork;
        this.expectedDate = expectedDate;
        this.isDone = isDone;
    }

    public String getTargetName() {
        return targetName;
    }

    public int getDayRemaining() {
        return dayRemaining;
    }

    public int getTotalWork() {
        return totalWork;
    }

    public int getDoneWork() {
        return doneWork;
    }

    public String  getExpectedDate() {
        return expectedDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

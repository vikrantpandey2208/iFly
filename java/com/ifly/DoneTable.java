package com.ifly;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "done_table")
public class DoneTable {

    private String  targetName;
    private String doneDetail;
    private String date;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "done_id")
    private int doneId;


    public DoneTable(String targetName, String doneDetail, String date) {
        this.targetName = targetName;
        this.doneDetail = doneDetail;
        this.date = date;
    }


    public String getDoneDetail() {
        return doneDetail;
    }

    public int getDoneId() {
        return doneId;
    }

    public String getDate() {
        return date;
    }

    public void setDoneId(int doneId) {
        this.doneId = doneId;
    }

    public String getTargetName() {
        return targetName;
    }
}

package com.ifly;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ScheduleRepository {
    private ScheduleDao scheduleDao;
    private LiveData<List<ScheduleTable>> allScheduleEntry;

    ScheduleRepository(Application application) {
        mDatabase db = mDatabase.getDatabase(application);
        scheduleDao = db.scheduleDao();

        allScheduleEntry = scheduleDao.getAllScheduleEntry();
    }
    void insert(ScheduleTable entry) {
        mDatabase.databaseWriteExecutor.execute(() -> {
            scheduleDao.insert(entry);
        });
    }

    void setNewTaskToSlot(String slot, String task) {
        mDatabase.databaseWriteExecutor.execute(() -> {
            scheduleDao.setNewTaskToSlot(slot,task);
        });
    }

    public LiveData<List<ScheduleTable>> getAllScheduleEntry() {
        return allScheduleEntry;
    }
}

package com.ifly;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TargetRepository {
    private TargetDao targetDao;
    private LiveData<List<TargetTable>> allTargetLiveData;
    private LiveData<List<TargetTable>> getRemainingDayAsc;

    TargetRepository(Application application) {
        mDatabase db = mDatabase.getDatabase(application);
        targetDao = db.targetDao();

        allTargetLiveData = targetDao.getAlphabetizedTargets();
        getRemainingDayAsc = targetDao.getRemainingDayAsc();
    }

    LiveData<List<TargetTable>> getAllTargetLiveData() {
        return allTargetLiveData;
    }

    LiveData<List<TargetTable>> getRemainingDayAsc() {
        return getRemainingDayAsc;
    }

    void insert(TargetTable target) {
        mDatabase.databaseWriteExecutor.execute(() -> {
            targetDao.insert(target);
        });
    }
    void updateTotalWork(int newTotal, int id) {
        mDatabase.databaseWriteExecutor.execute(() -> {
            targetDao.updateTotalWork(newTotal,id);
        });
    }

}

package com.ifly;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TargetRepository {
    private TargetDao targetDao;
    private LiveData<List<TargetTable>> allTargetLiveData;
    private LiveData<List<TargetTable>> getRemainingDayAsc;
    private LiveData<List<TargetTable>> getNotDoneTargets;

    TargetRepository(Application application) {
        mDatabase db = mDatabase.getDatabase(application);
        targetDao = db.targetDao();

        allTargetLiveData = targetDao.getAlphabetizedTargets();
        getRemainingDayAsc = targetDao.getRemainingDayAsc();
        getNotDoneTargets = targetDao.getNotDoneTargets();
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
    void updateAddToDoneWork(int addDone, int id) {
        mDatabase.databaseWriteExecutor.execute(() -> {
            targetDao.updateAddToDoneWork(addDone,id);
        });
    }

    public LiveData<List<TargetTable>> getGetNotDoneTargets() {
        return getNotDoneTargets;
    }
}

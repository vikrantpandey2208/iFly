package com.ifly;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DoneRepository {
    private DoneDao doneDao;
    private LiveData<List<DoneTable>> allDoneDetails;

    DoneRepository(Application application) {
        mDatabase db = mDatabase.getDatabase(application);
        doneDao = db.doneDao();

        allDoneDetails = doneDao.getAllDoneDetailByTargetItAsc();
    }
    void insert(DoneTable doneTable) {
        mDatabase.databaseWriteExecutor.execute(() -> {
            doneDao.insert(doneTable);
        });
    }

    public LiveData<List<DoneTable>> getAllDoneDetails() {
        return allDoneDetails;
    }
}

package com.ifly;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TargetViewModel extends AndroidViewModel {

    private TargetRepository mRepository;
    private final LiveData<List<TargetTable>> allTargets;
    private final LiveData<List<TargetTable>> remainingDayAsc;
    private final LiveData<List<TargetTable>> getNotDoneTargets;

    public TargetViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TargetRepository(application);
        allTargets = mRepository.getAllTargetLiveData();
        remainingDayAsc = mRepository.getRemainingDayAsc();
        getNotDoneTargets = mRepository.getGetNotDoneTargets();
    }

    LiveData<List<TargetTable>> getAllTargets() {
        return allTargets;
    }

    public void insert(TargetTable target) {
        mRepository.insert(target);
    }

    public LiveData<List<TargetTable>> getRemainingDayAsc() {
        return remainingDayAsc;
    }

    public LiveData<List<TargetTable>> getNotDoneTargets() {
        return getNotDoneTargets;
    }
}

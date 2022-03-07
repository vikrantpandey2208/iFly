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

    public TargetViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TargetRepository(application);
        allTargets = mRepository.getAllTargetLiveData();
        remainingDayAsc = mRepository.getRemainingDayAsc();
    }

    LiveData<List<TargetTable>> getAllTargets() {
        return allTargets;
    }

    public void insert(TargetTable target) {
        mRepository.insert(target);
    }

    public void updateTotalWork(int newTotal, int id) {
        mRepository.updateTotalWork(newTotal, id);
    }

    public LiveData<List<TargetTable>> getRemainingDayAsc() {
        return remainingDayAsc;
    }
}

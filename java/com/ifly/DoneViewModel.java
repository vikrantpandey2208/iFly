package com.ifly;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DoneViewModel extends AndroidViewModel {

    private DoneRepository mRepository;
    private final LiveData<List<DoneTable>> allDoneDetails;

    public DoneViewModel(@NonNull  Application application) {
        super(application);
        mRepository = new DoneRepository(application);
        allDoneDetails = mRepository.getAllDoneDetails();
    }

    public LiveData<List<DoneTable>> getAllDoneDetails() {
        return allDoneDetails;
    }
}

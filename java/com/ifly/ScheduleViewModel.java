package com.ifly;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ScheduleViewModel extends AndroidViewModel {
    private ScheduleRepository mRepository;
    private final LiveData<List<ScheduleTable>> allScheduleEntry;

    public ScheduleViewModel(@NonNull Application application) {
        super(application);

        mRepository = new ScheduleRepository(application);
        allScheduleEntry = mRepository.getAllScheduleEntry();
    }

    public LiveData<List<ScheduleTable>> getAllScheduleEntry() {
        return allScheduleEntry;
    }
}

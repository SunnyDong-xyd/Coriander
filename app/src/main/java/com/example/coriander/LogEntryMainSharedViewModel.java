package com.example.coriander;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LogEntryMainSharedViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private final MutableLiveData<LogEntry> selected = new MutableLiveData<LogEntry>();

    public void select(LogEntry item) {
        selected.setValue(item);
    }

    public LiveData<LogEntry> getSelected() {
        return selected;
    }
}
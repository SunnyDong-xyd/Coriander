package com.example.coriander;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SVMContacts extends ViewModel {
    private MutableLiveData<String> text = new MutableLiveData<>();
    private MutableLiveData<String> number = new MutableLiveData<>();
    private MutableLiveData<String> id = new MutableLiveData<>();

    public void setText(String input, String input2, String input3){
        text.setValue(input);
        number.setValue(input2);
        id.setValue(input3);

    }

    public LiveData<String> getText(){
        return text;
    }
    public LiveData<String> getNum(){
        return number;
    }

    public LiveData<String> getID(){
        return id;
    }
}

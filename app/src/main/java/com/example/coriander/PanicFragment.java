package com.example.coriander;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PanicFragment extends Fragment {
    //TODO: implement navigation using Navigation lib and implement between panic and breathing, dont forget to convert other activities (inc panic) to fragments
    private PanicViewModel mViewModel;

    public static PanicFragment newInstance() {
        return new PanicFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.panic_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PanicViewModel.class);
        // TODO: Use the ViewModel
    }

}
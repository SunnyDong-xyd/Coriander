package com.example.coriander;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LogEntryFragment extends Fragment {

    //TODO: Replace SharedViewModel with Internal Storage
    private LogEntryMainSharedViewModel mViewModel;
    private LogEntry logEntry;
    ImageButton btnMood1;
    ImageButton btnMood2;
    ImageButton btnMood3;
    ImageButton btnMood4;
    ImageButton btnMood5;
    Button btnEnter;
    EditText userLogEdit;
    OnViewCreated createdListener;

    public static LogEntryFragment newInstance() {
        return new LogEntryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.log_entry_fragment, container, false);
        createdListener.onViewSelected(view);
        logEntry = new LogEntry();
        btnMood1 = (ImageButton) view.findViewById(R.id.imageButtonMood1);
        btnMood2 = (ImageButton) view.findViewById(R.id.imageButtonMood2);
        btnMood3 = (ImageButton) view.findViewById(R.id.imageButtonMood3);
        btnMood4 = (ImageButton) view.findViewById(R.id.imageButtonMood4);
        btnMood5 = (ImageButton) view.findViewById(R.id.imageButtonMood5);
        Button btnNo = (Button) view.findViewById(R.id.buttonLogNo);
        Button btnYes = (Button) view.findViewById(R.id.buttonLogYes);
        btnEnter = (Button) view.findViewById(R.id.buttonLogEnter);
        userLogEdit = (EditText) view.findViewById(R.id.editTextLogEntry);
        btnNo.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E1E1E1")));
        btnYes.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E1E1E1")));
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnNo.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#BBBBBB")));
                btnYes.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E1E1E1")));
                logEntry.setPanicAttack(false);
            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnYes.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#BBBBBB")));
                btnNo.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#E1E1E1")));
                logEntry.setPanicAttack(true);
            }
        });
        btnMood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMoodSelected(btnMood1);
                logEntry.setMood(1);
            }
        });
        btnMood2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMoodSelected(btnMood2);
                logEntry.setMood(2);
            }
        });
        btnMood3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMoodSelected(btnMood3);
                logEntry.setMood(3);
            }
        });
        btnMood4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMoodSelected(btnMood4);
                logEntry.setMood(4);
            }
        });
        btnMood5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMoodSelected(btnMood5);
                logEntry.setMood(5);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(LogEntryMainSharedViewModel.class);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logEntry.mood < 0){
                    Toast.makeText(getActivity(), "Please Enter Your Mood", Toast.LENGTH_LONG).show();
                }
                else if (logEntry.panicAttack == null){
                    Toast.makeText(getActivity(), "Please Specify if You've had a Panic Attack", Toast.LENGTH_LONG).show();
                }
                else{
                    logEntry.setUserLog(userLogEdit.getText().toString());
                    mViewModel.select(logEntry);
                    Navigation.findNavController(getView()).navigate(R.id.action_global_mainFragment);
                }
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        createdListener = (OnViewCreated) context;
    }

    void setMoodSelected(ImageButton btn){
        btnMood1.setColorFilter(Color.parseColor("#AAAAAA"));
        btnMood2.setColorFilter(Color.parseColor("#AAAAAA"));
        btnMood3.setColorFilter(Color.parseColor("#AAAAAA"));
        btnMood4.setColorFilter(Color.parseColor("#AAAAAA"));
        btnMood5.setColorFilter(Color.parseColor("#AAAAAA"));
        btn.setColorFilter(Color.parseColor("#000000"));
    }
}
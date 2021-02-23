package com.example.coriander;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private LogEntryMainSharedViewModel model;
    private LogEntry logEntry;
    OnViewCreated createdListener;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        createdListener.onViewSelected(view);

        Button btn = (Button) view.findViewById(R.id.buttonLogMood);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_logEntryFragment);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = new ViewModelProvider(requireActivity()).get(LogEntryMainSharedViewModel.class);
        CalendarView calendar = (CalendarView) view.findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                //Toast.makeText(getActivity(), logEntry.mood + logEntry.panicAttack.toString() + logEntry.userLog, Toast.LENGTH_LONG).show();
                String filename = year + "_" + month + "_" + day + "_log";
                logEntry = BaseActivity.ReadFile(filename);
                if (logEntry == null){
                    Toast.makeText(getActivity(), "No log for this date", Toast.LENGTH_LONG).show();
                }
                else{
                    model.select(logEntry);
                    Navigation.findNavController(getView()).navigate(R.id.action_mainFragment_to_moodLogFragment);
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        createdListener = (OnViewCreated) context;
    }
}
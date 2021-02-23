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
import android.widget.ImageView;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MoodLogFragment extends Fragment {

    private MoodLogViewModel mViewModel;
    private LogEntry logEntry;
    OnViewCreated createdListener;

    public static MoodLogFragment newInstance() {
        return new MoodLogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mood_log_fragment, container, false);
        createdListener.onViewSelected(view);
        Button btn = (Button) view.findViewById(R.id.buttonEditLog);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_moodLogFragment_to_logEntryFragment);
            }
        });
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MoodLogViewModel.class);
        // TODO: Use the ViewModel
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogEntryMainSharedViewModel model = new ViewModelProvider(requireActivity()).get(LogEntryMainSharedViewModel.class);
        model.getSelected().observe(getViewLifecycleOwner(), item -> {
            logEntry = item;
            Calendar c = Calendar.getInstance();
            c.set(logEntry.year, logEntry.month, logEntry.day);
            TextView textViewDate = (TextView) view.findViewById(R.id.textViewDate);
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date = formatter.format(c.getTime());
            textViewDate.setText(date);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageViewMood);
            switch (logEntry.mood){
                case 1:
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_1);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_2);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_3);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_4);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_5);
                    break;
            }
            TextView textViewPanic = (TextView) view.findViewById(R.id.textViewPanicAttackLog);
            textViewPanic.setText(String.valueOf(logEntry.panicAttack));
            TextView textViewLog = (TextView) view.findViewById(R.id.textViewUserLog);
            textViewLog.setText(logEntry.userLog);
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        createdListener = (OnViewCreated) context;
    }

}
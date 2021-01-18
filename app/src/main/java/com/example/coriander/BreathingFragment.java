package com.example.coriander;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class BreathingFragment extends Fragment {

    OnViewCreated createdListener;



    // TODO: Rename and change types and number of parameters
    public static BreathingFragment newInstance(){
        return new BreathingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_breathing, container, false);
        createdListener.onViewSelected(view);

        //bunny button
        ImageButton bunnybtn = (ImageButton) view.findViewById(R.id.bunnyButton);
        bunnybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_breathingFragment_to_bunnyFragment);
            }
        });

        //candle button
        ImageButton candlebtn = (ImageButton) view.findViewById(R.id.candleButton2);
        candlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_breathingFragment_to_candleFragment);
            }
        });

        //flower button
        ImageButton flowerbtn = (ImageButton) view.findViewById(R.id.flowerButton3);
        flowerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_breathingFragment_to_flowerFragment);
            }
        });

        //snake button
        ImageButton snakebtn = (ImageButton) view.findViewById(R.id.snakeButton4);
        snakebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_breathingFragment_to_snakeFragment);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = new ViewModelProvider(this).get(BreathingViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        createdListener = (OnViewCreated) context;
    }

}
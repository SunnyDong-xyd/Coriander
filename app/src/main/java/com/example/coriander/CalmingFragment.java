package com.example.coriander;

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
import android.widget.TextView;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalmingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalmingFragment extends Fragment {
    int prev = -1;
    OnViewCreated createdListener;

    // TODO: Rename and change types and number of parameters
    public static CalmingFragment newInstance(){
        return new CalmingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calming, container, false);
        createdListener.onViewSelected(view);

        TextView factview = (TextView) view.findViewById(R.id.textView29);
        Random myRandom = new Random();
        Button btn = (Button) view.findViewById(R.id.factbutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int check = myRandom.nextInt(5);
                if(check == prev){
                    if(check == 4){
                        check = 1;
                    }else{
                        check = check + 1;
                    }
                }
                if(check == 0){
                    factview.setText("The voice actor for Minnie Mouse married the voice actor for Mickey Mouse.");
                }else if(check == 1){
                    factview.setText("A group of bunnies is called a fluffle.");
                }else if(check == 2){
                    factview.setText("Butterflies can taste with their feet.");
                }else if(check == 3){
                    factview.setText("Baby puffins are called pufflings.");
                }else if(check == 4){
                    factview.setText("There are vending machines in Istanbul that dispense food and water for stray dogs in exchange for recycleable bottles.");
                }
               // factview.setText(String.valueOf(check));
                prev = check;
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
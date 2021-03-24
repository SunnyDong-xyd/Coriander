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
import android.widget.ImageView;
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
        ImageView imview = (ImageView) view.findViewById(R.id.imageView9);
        Random myRandom = new Random();
        Button btn = (Button) view.findViewById(R.id.factbutton);
        imview.setImageResource(R.drawable.comfort1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int check = myRandom.nextInt(8);
                if(check == prev){
                    if(check == 7){
                        check = 1;
                    }else{
                        check = check + 1;
                    }
                }
                if(check == 0){
                    factview.setText("Panic attacks are treatable. This is a medical condition that millions of people experience, you will survive, you are safe");
                    imview.setImageResource(R.drawable.comfort1);
                }else if(check == 1){
                    factview.setText("You are in control. The more you practice calming exercises, the better you will be at managing any future attacks.");
                    imview.setImageResource(R.drawable.comfort2);
                }else if(check == 2){
                    factview.setText("This is your body's response to emotion, you aren't in danger. Our bodies react to fear by increasing adrenaline. The adrenaline will break down after a few minutes and you will regain stability.");
                    imview.setImageResource(R.drawable.comfort3);
                }else if(check == 3){
                    factview.setText("The human response of panic to stress is natural. Panic comes from the flight or fight response. This response is temporary and poses no threat to your body.");
                    imview.setImageResource(R.drawable.comfort4);
                }else if(check == 4){
                    factview.setText("Panic attacks aren't fatal. You will be okay, a panic attack will not physically harm you.");
                    imview.setImageResource(R.drawable.comfort5);
                }else if(check == 5){
                    factview.setText("Focus on what you can control. Trying to stop all symptoms creates anxiety, focus on one symptom at a time.");
                    imview.setImageResource(R.drawable.comfort6);
                }else if(check == 6){
                    factview.setText("This is temporary. Symptoms peak after 3-5 minutes, then quickly subside. If you feel tensions rising, you are getting one step closer to returning to your regular mental state.");
                    imview.setImageResource(R.drawable.comfort7);
                }else if(check == 7){
                    factview.setText("Accept your state. It can help to acknowledge the attack. Accept how your body is reacting, give your body time to go through the symptoms and come to a natural rest.");
                    imview.setImageResource(R.drawable.comfort8);
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
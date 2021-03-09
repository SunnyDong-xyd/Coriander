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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhysicalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhysicalFragment extends Fragment {

    OnViewCreated createdListener;

    // TODO: Rename and change types and number of parameters
    public static PhysicalFragment newInstance(){
        return new PhysicalFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_physical, container, false);
        createdListener.onViewSelected(view);

        //jog button
        Button btn1 = (Button) view.findViewById(R.id.walkbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_physicalFragment_to_jog);
            }
        });

        //jacks button
        Button btn2 = (Button) view.findViewById(R.id.jackbutton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_physicalFragment_to_jjacks);
            }
        });

        //situp button
        Button btn3 = (Button) view.findViewById(R.id.situpbutton);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_physicalFragment_to_situps);
            }
        });

        //crunches button
        Button btn4 = (Button) view.findViewById(R.id.crunchbutton);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_physicalFragment_to_crunches);
            }
        });

        //push ups button
        Button btn5 = (Button) view.findViewById(R.id.pushupbutton);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_physicalFragment_to_pushups);
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
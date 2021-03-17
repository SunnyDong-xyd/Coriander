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
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroundingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroundingFragment extends Fragment {

    OnViewCreated createdListener;

    // TODO: Rename and change types and number of parameters
    public static GroundingFragment newInstance(){
        return new GroundingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grounding, container, false);
        createdListener.onViewSelected(view);

        ImageButton btn1 = (ImageButton) view.findViewById(R.id.imageButton2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_groundingFragment_to_groundingNumber);
            }
        });

        ImageButton btn2 = (ImageButton) view.findViewById(R.id.imageButton);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_groundingFragment_to_groundingObject);
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
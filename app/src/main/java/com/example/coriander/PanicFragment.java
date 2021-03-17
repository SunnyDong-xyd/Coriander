package com.example.coriander;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PanicFragment extends Fragment {

    private PanicViewModel mViewModel;



    OnViewCreated createdListener;

    public static PanicFragment newInstance() {
        return new PanicFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.panic_fragment, container, false);
        createdListener.onViewSelected(view);

        //breathing button
        Button btn = (Button) view.findViewById(R.id.buttonbreathing);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_panicFragment_to_breathingFragment);
            }
        });

        //contact button
        Button contactbtn = (Button) view.findViewById(R.id.buttoncall);
        contactbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_panicFragment_to_contactFragment);
            }
        });

        //grounding exercises button
        Button groundbtn = (Button) view.findViewById(R.id.buttongrounding);
        groundbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_panicFragment_to_groundingFragment2);
            }
        });

        //physical exercises button
        Button physicalbtn = (Button) view.findViewById(R.id.buttonphysical);
        physicalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_panicFragment_to_physicalFragment2);
            }
        });

        //calming facts button
        Button calmingbtn = (Button) view.findViewById(R.id.buttoncalming);
        calmingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_panicFragment_to_calmingFragment2);
            }
        });




        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PanicViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        createdListener = (OnViewCreated) context;
    }


}
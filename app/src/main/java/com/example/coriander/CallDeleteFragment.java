package com.example.coriander;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CallDeleteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallDeleteFragment extends Fragment {
    DatabaseHelper myDB;
    private static final String TAG = "ContactFragment";
    public LiveData<String> cDname;
    public String cDnumber;
    private SVMContacts viewModel;
    private TextView tv1,tv2;
    public String cID;

    /*/
    private FragmentBListener listener;
    public interface FragmentBListener {
        void onInputSent(String input);
    }/*/

    OnViewCreated createdListener;
    // TODO: Rename and change types and number of parameters
    public static CallDeleteFragment newInstance(){
        return new CallDeleteFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_call_delete, container, false);
        createdListener.onViewSelected(view);

        tv1 = (TextView) view.findViewById(R.id.textView33);
        tv2 = (TextView) view.findViewById(R.id.textView34);
        //Intent receivedIntent = getIntent();
        /*/String CDname = getArguments().getString("name");
        tv1.setText(CDname);/*/


        /*/
        Bundle bundl = getArguments();
        if (bundl != null) {
            cDname = bundl.getString("name");

            cDnumber = bundl.getString("number");
        }

        tv1.setText(cDname);/*/


       // tv1.setText((CharSequence) cDname);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = new ViewModelProvider(this).get(BreathingViewModel.class);
        // TODO: Use the ViewModel

    }

    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(SVMContacts.class);
        viewModel = ViewModelProviders.of(getActivity()).get(SVMContacts.class);
        viewModel.getText().observe(getViewLifecycleOwner(), text -> {

                tv1.setText(text);

        });
        viewModel.getNum().observe(getViewLifecycleOwner(), number -> {
            cDnumber = number;
            tv2.setText(number);

        });
        viewModel.getID().observe(getViewLifecycleOwner(), id -> {
            cID = id;

        });
        Button btnview = (Button) view.findViewById(R.id.btnmakecall);
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+cDnumber));
                startActivity(intent);
            }
        });
        Button btndel = (Button) view.findViewById(R.id.button4);
        myDB = new DatabaseHelper(getActivity());
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDB.deleteData(cID);
                Navigation.findNavController(view).navigate(R.id.action_callDeleteFragment_to_contactFragment);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        /*/if(context instanceof CallDeleteFragment.FragmentBListener){
            listener = (CallDeleteFragment.FragmentBListener)context;
        }else{
            throw new RuntimeException(context.toString() + "must implement interface");
        }/*/
        createdListener = (OnViewCreated) context;
    }
    /*/
    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }/*/



}
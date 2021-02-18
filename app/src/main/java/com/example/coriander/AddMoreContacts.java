package com.example.coriander;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class AddMoreContacts extends Fragment {


    Button btnadd;
    EditText editText, editText2;
    DatabaseHelper myDB;
    ArrayList<User> userList;
    ListView listView;
    User user;

    OnViewCreated createdListener;
    // TODO: Rename and change types and number of parameters
    public static AddMoreContacts newInstance(){
        return new AddMoreContacts();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_more_contacts, container, false);
        createdListener.onViewSelected(view);

        editText = (EditText) view.findViewById(R.id.editText4);
        editText2 = (EditText) view.findViewById(R.id.editText3);
        btnadd = (Button) view.findViewById(R.id.btnAdd2);
        myDB = new DatabaseHelper(getActivity());
        userList = new ArrayList<>();
        Cursor data = myDB.getListContents();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                String number = editText2.getText().toString();
                if(editText.length() != 0  && editText2.length() != 0){
                    AddData(newEntry,number);
                    editText.setText("");
                    editText2.setText("");

                }else{
                    Toast.makeText(getActivity(), "Fields were entered incorrectly", Toast.LENGTH_LONG).show();
                }
                Navigation.findNavController(view).navigate(R.id.action_addMoreContacts_to_contactFragment);
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

    public void AddData(String newEntry, String number){
            boolean insertData = myDB.addData(newEntry,number);

            if(insertData == true){
                Toast.makeText(getActivity(), "Contact successfully added", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getActivity(), "Error, contact not added", Toast.LENGTH_LONG).show();
            }
        }

}
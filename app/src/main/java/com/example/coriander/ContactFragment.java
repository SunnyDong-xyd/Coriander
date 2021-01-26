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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    OnViewCreated createdListener;
    DatabaseHelper myDB;
    Button btnadd,btnview;
    EditText editText;

    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(){
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        createdListener.onViewSelected(view);




        editText = (EditText) view.findViewById(R.id.editText);
        btnadd = (Button) view.findViewById(R.id.btnAdd);
        btnview = (Button) view.findViewById(R.id.btnView);
        myDB = new DatabaseHelper(getActivity());
        ListView listView = (ListView) view.findViewById(R.id.listview1);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        data.moveToFirst();
        if(data.getCount() == 0){
            Toast.makeText(getActivity(), "Contacts list is empty", Toast.LENGTH_LONG).show();
        }else{
            do{
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);


            }while(data.moveToNext());
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getActivity(),theList.get(i),Toast.LENGTH_LONG).show();
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"));
                startActivity(intent);
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length() != 0){
                    AddData(newEntry);
                    editText.setText("");

                }else{
                    Toast.makeText(getActivity(), "Please enter a name into the name field", Toast.LENGTH_LONG).show();
                }
                Navigation.findNavController(view).navigate(R.id.action_contactFragment_self);
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

    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);

        if(insertData == true){
            Toast.makeText(getActivity(), "Contact successfully added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getActivity(), "Error, contact not added", Toast.LENGTH_LONG).show();
        }
    }

}
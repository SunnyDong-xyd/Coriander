package com.example.coriander;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.lifecycle.LiveData;
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

    private SVMContacts viewModel;

    OnViewCreated createdListener;
    DatabaseHelper myDB;
    Button btnadd;
    EditText editText, editText2;
    ArrayList<User> userList;
    ListView listView;
    User user;
    /*/private FragmentAListener listener;
    public interface FragmentAListener {
        void onInputSent(String input);
    }/*/

    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(){
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        createdListener.onViewSelected(view);





        btnadd = (Button) view.findViewById(R.id.buttonaddmore);

        myDB = new DatabaseHelper(getActivity());
        userList = new ArrayList<>();
        Cursor data = myDB.getListContents();


        //listView = (ListView) view.findViewById(R.id.listview1);



        //ArrayList<String> theList = new ArrayList<>();
        data.moveToFirst();
        if(data.getCount() == 0){
            Toast.makeText(getActivity(), "Contacts list is empty", Toast.LENGTH_LONG).show();
        }else{
            do{
                user = new User(data.getString(1),data.getString(2),data.getString(0));
                userList.add(user);
                ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(getActivity(),R.layout.fragment_add_contact,userList);
                listView = (ListView) view.findViewById(R.id.listview1);
                listView.setAdapter(adapter);

               // ListAdapter listAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,theList);
                //listView.setAdapter(listAdapter);


            }while(data.moveToNext());
        }






        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_contactFragment_to_addMoreContacts);
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
        /*/if(context instanceof FragmentAListener){
            listener = (FragmentAListener)context;
        }else{
            throw new RuntimeException(context.toString() + "must implement interface");
        }/*/
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

    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(SVMContacts.class);

        if (myDB.CheckDB() == true) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    //Toast.makeText(getActivity(),userList.get(i).getName(),Toast.LENGTH_LONG).show();
                    String name = userList.get(i).getName();
                    String number = userList.get(i).getNumber();
                    String id = userList.get(i).getID();


                /*/
                Intent editScreenIntent = new Intent(getActivity().getBaseContext(),BaseActivity.class);
                editScreenIntent.putExtra("name",name);
                editScreenIntent.putExtra("number",number);/*/
                    //listener.onInputSent(name);

                /*/
                Bundle args = new Bundle();
                args.putString("name",name);
                args.putString("number",number);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CallDeleteFragment newFrag = new CallDeleteFragment();
                newFrag.setArguments(args);

                fragmentTransaction.replace(R.id.fragment,newFrag);
                fragmentTransaction.commit();
                newFrag.setArguments(args);
/*/

                    viewModel.setText(name, number,id);

                    Navigation.findNavController(view).navigate(R.id.action_contactFragment_to_callDeleteFragment);
                }
            });
        }
    }
}
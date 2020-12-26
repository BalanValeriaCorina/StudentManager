package com.example.studentmanager.authentication.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.studentmanager.R;


public class RoleChoserFragment extends Fragment {

    private Button professorbtn;
    private  Button studentbtn;

    private SharedPreferences sharedpref;
    public static  final String SHARED_PREF_FILE_NAME="loginSharedPref";
    public static final String EMAIL="email";
    public static final String PASSWORD="password";
    public static final String REMEMBER="remember";
    public RoleChoserFragment() {
        // Required empty public constructor
    }


    public static RoleChoserFragment newInstance() {
        return new RoleChoserFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_role_choser, container, false);
        professorbtn=view.findViewById(R.id.profesor_button);
        studentbtn=view.findViewById(R.id.student_button);

        sharedpref=getActivity().getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        String email=sharedpref.getString(EMAIL,"");
        String password=sharedpref.getString(PASSWORD,"");
        if(!email.equals("") && !password.equals(""))
        {
            Toast.makeText(getContext(),"Automatic login",Toast.LENGTH_LONG).show();

        }

        professorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("role","professor");
                Navigation.findNavController(view).navigate(R.id.registrationLoginFragment,bundle);

            }
        });

        studentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("role","student");
                Navigation.findNavController(view).navigate(R.id.registrationLoginFragment,bundle);
            }
        });
        return view;
    }





}
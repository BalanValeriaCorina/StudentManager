package com.example.studentmanager.authentication.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.studentmanager.ProfesorProfileActivity;
import com.example.studentmanager.R;
import com.example.studentmanager.StudentProfileActivity;
import com.example.studentmanager.database.models.Profesor;


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
        String role=sharedpref.getString("role","");
        if(!email.equals("") && !password.equals("") && !role.equals(""))
        {
           if(role.equals("student"))
           {
               Intent studintent=new Intent(getContext(),StudentProfileActivity.class);
               Bundle bundlenou=new Bundle();
               bundlenou.putString("email",email);
               studintent.putExtras(bundlenou);
               startActivity(studintent);
               getActivity().finish();
           }
           else
           {
               Intent profintent=new Intent(getContext(), ProfesorProfileActivity.class);
               Bundle bundlenou=new Bundle();
               bundlenou.putString("email",email);
               profintent.putExtras(bundlenou);
               startActivity(profintent);
               getActivity().finish();
           }

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
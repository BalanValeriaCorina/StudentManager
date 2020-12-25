package com.example.studentmanager.authentication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.studentmanager.R;


public class RegistrationLoginFragment extends Fragment {

    private static final String ROLE = "role";
    private String role;
    public RegistrationLoginFragment() {
    }


    public static RegistrationLoginFragment newInstance(String role) {
        RegistrationLoginFragment fragment = new RegistrationLoginFragment();
        Bundle args = new Bundle();
        args.putString(ROLE, role);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(getArguments()!=null)
            this.role=getArguments().getString(ROLE);
        return inflater.inflate(R.layout.fragment_registration_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(),this.role,Toast.LENGTH_LONG).show();
    }







}
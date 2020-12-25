package com.example.studentmanager.authentication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentmanager.R;


public class LoginFragment extends Fragment {

    private static final String ROLE = "role";
    private String role;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance(String role) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ROLE, role);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null)
            this.role=getArguments().getString(ROLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_login, container, false);
    }
}
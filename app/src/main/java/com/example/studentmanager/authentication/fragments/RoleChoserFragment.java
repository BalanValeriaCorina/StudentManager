package com.example.studentmanager.authentication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentmanager.R;


public class RoleChoserFragment extends Fragment {



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
        return inflater.inflate(R.layout.fragment_role_choser, container, false);
    }
}
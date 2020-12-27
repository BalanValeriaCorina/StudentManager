package com.example.studentmanager.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentmanager.R;


public class StudentProfileFragment extends Fragment {



    public StudentProfileFragment() {
        // Required empty public constructor
    }


    public static StudentProfileFragment newInstance() {
        StudentProfileFragment fragment = new StudentProfileFragment();

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
        return inflater.inflate(R.layout.fragment_student_profile, container, false);
    }
}
package com.example.studentmanager.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.studentmanager.MainActivity;
import com.example.studentmanager.R;
import com.example.studentmanager.async.AsyncTaskRunner;
import com.example.studentmanager.async.Callback;
import com.example.studentmanager.database.models.Profesor;
import com.example.studentmanager.database.models.Subject;
import com.example.studentmanager.database.repositories.ProfesorRepository;
import com.example.studentmanager.database.repositories.SubjectRepository;
import com.example.studentmanager.profile.adapters.SpinnerAdapter;
import java.util.List;
import java.util.concurrent.Callable;


public class ProfesorProfileFragment extends Fragment {

    public static  final String SHARED_PREF_FILE_NAME="loginSharedPref";
    private Button logoutteacher;
    private SharedPreferences sharedPreferences;
    private TextView teachername;
    private TextView emailteacher;
    private TextView diplomateacher;
    private Spinner spinnerteacher;
    private SpinnerAdapter spinnerAdapter;
    private Profesor profesor;
    private AsyncTaskRunner asyncTaskRunner=new AsyncTaskRunner();

    public ProfesorProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logoutteacher=view.findViewById(R.id.btnlogoutteacher);
        sharedPreferences=getActivity().getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE);
        teachername=view.findViewById(R.id.tvnumeteacher);
        emailteacher=view.findViewById(R.id.tvemailteacher);
        diplomateacher=view.findViewById(R.id.tvdiploma);
        spinnerteacher=view.findViewById(R.id.spinnerteacher1);



        logoutteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               sharedPreferences.edit().clear().apply();
                Intent intent=new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        getProfesorFromDatabase();
        populateSpinner();

    }

    private void getProfesorFromDatabase()
    {
        String email;
        Intent intent=getActivity().getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null)
        {
            email=bundle.getString("email");
        }
        else
        {
            email="";
        }

        if(email!="")
        {
            AsyncTaskRunner asyncTaskRunner=new AsyncTaskRunner();
            ProfesorRepository profesorRepository=new ProfesorRepository(getContext());
            Callable<Profesor> callable=new Callable<Profesor>() {
                @Override
                public Profesor call() throws Exception {
                    return profesorRepository.getProfesor(email);
                }

            };
            Callback<Profesor> callback=new Callback<Profesor>() {
                @Override
                public void runResultOnUIThread(Profesor result) {
                    teachername.setText(result.getName());
                    emailteacher.setText(result.getEmail());
                    diplomateacher.setText(result.getDiploma().getDiplomaName());
                    profesor=result;

                }
            };
            asyncTaskRunner.executeAsync(callable,callback);
        }
    }

    public static ProfesorProfileFragment newInstance() {
        ProfesorProfileFragment fragment = new ProfesorProfileFragment();
        return fragment;
    }


    public void populateSpinner()
    {
        SubjectRepository subjectRepository=new SubjectRepository(getContext());

        Callable<List<Subject>> callable=new Callable<List<Subject>>() {
            @Override
            public List<Subject> call() throws Exception {
                return subjectRepository.getProfesorSubjects(profesor.getIdProfesor());
            }
        };
        Callback<List<Subject>> callback=new Callback<List<Subject>>() {
            @Override
            public void runResultOnUIThread(List<Subject> result) {
                spinnerAdapter=new SpinnerAdapter(getContext(),R.layout.custom_spinner_subjects,result);
                spinnerteacher.setAdapter(spinnerAdapter);

            }
        };
        asyncTaskRunner.executeAsync(callable,callback);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profesor_profile, container, false);
    }
}
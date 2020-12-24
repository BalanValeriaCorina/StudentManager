package com.example.studentmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.studentmanager.async.AsyncTaskRunner;
import com.example.studentmanager.async.Callback;
import com.example.studentmanager.database.models.Profesor;
import com.example.studentmanager.database.repositories.ProfesorRepository;

import java.util.List;
import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    ProfesorRepository profesorRepository;
    private final AsyncTaskRunner taskRunner=new AsyncTaskRunner();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profesorRepository=new ProfesorRepository(this);


    }


    public void  insert() {
        Callable<List<Profesor>> callable=new Callable<List<Profesor>>() {
            @Override
            public List<Profesor> call() throws Exception {
                return profesorRepository.getAll();
            }
        };
        Callback<List<Profesor>> callback=new Callback<List<Profesor>>() {
            @Override
            public void runResultOnUIThread(List<Profesor> result) {
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();

            }
        };
        taskRunner.executeAsync(callable,callback);

    }
}
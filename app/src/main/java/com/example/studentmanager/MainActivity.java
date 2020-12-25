package com.example.studentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.studentmanager.async.AsyncTaskRunner;
import com.example.studentmanager.async.Callback;
import com.example.studentmanager.authentication.fragments.RoleChoserFragment;
import com.example.studentmanager.database.models.Profesor;
import com.example.studentmanager.database.repositories.ProfesorRepository;

import java.util.List;
import java.util.concurrent.Callable;

public class MainActivity extends FragmentActivity {

    ProfesorRepository profesorRepository;
    private final AsyncTaskRunner taskRunner=new AsyncTaskRunner();
    Fragment fragmentRoleChoser= RoleChoserFragment.newInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        profesorRepository=new ProfesorRepository(this);
//        Profesor profesor = new Profesor("prof@prof.com", "Prof Test", 1234);
//        insert(profesor);

        //getSupportFragmentManager().beginTransaction().replace(R.id.placeholder_fragment,fragmentRoleChoser).commit();

    }


    public void  insert(Profesor p) {
        Callable<Long> callable=new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return profesorRepository.insert(p);
            }
        };
        Callback<Long> callback=new Callback<Long>() {
            @Override
            public void runResultOnUIThread(Long result) {
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();

            }
        };
        taskRunner.executeAsync(callable,callback);

    }
}
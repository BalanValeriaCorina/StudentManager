package com.example.studentmanager.profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.studentmanager.R;
import com.example.studentmanager.async.AsyncTaskRunner;
import com.example.studentmanager.async.Callback;
import com.example.studentmanager.database.models.StudentSubjectCrossRef;
import com.example.studentmanager.database.models.Subject;
import com.example.studentmanager.database.repositories.StudentSubjectCrossrefRepository;
import com.example.studentmanager.database.repositories.SubjectRepository;
import com.example.studentmanager.profile.adapters.StudentSubjectAdapter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;


public class ProfesorSubjectFragment extends Fragment {

    private Subject currentSubject;

    private StudentSubjectCrossrefRepository studentSubjectCrossrefRepository;
    private SubjectRepository subjectRepository;
    private final AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner();

    private CalendarView examCalendarView;
    private RecyclerView studentsRecyclerView;

    public ProfesorSubjectFragment() {
        // Required empty public constructor
    }

    public static ProfesorSubjectFragment newInstance() {
        return new ProfesorSubjectFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        currentSubject = getArguments().getParcelable("subject");

        studentSubjectCrossrefRepository = new StudentSubjectCrossrefRepository(getContext());
        subjectRepository = new SubjectRepository(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profesor_subject, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        examCalendarView = view.findViewById(R.id.profesor_subject_date_picker);
        studentsRecyclerView = view.findViewById(R.id.profesor_subject_recycler);

        // Add data to recyclerView
        populateRecyclerView();

        // Set the right Exam Date in the calendar view
        examCalendarView.setDate(currentSubject.getSubjectDateExam().getTime());

        examCalendarView.setOnDateChangeListener((CalendarView v, int year, int month, int dayOfMonth) -> {
            // Change the exam date for this subject
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, dayOfMonth);
            Date date = calendar.getTime();
            currentSubject.setSubjectDateExam(date);
            changeExamDateForSubject(currentSubject);
        });
    }

    private void populateRecyclerView() {
        Callable<List<StudentSubjectCrossRef>> callable = () -> studentSubjectCrossrefRepository.getStudentsRefInSubject(currentSubject.getIdSubject());
        Callback<List<StudentSubjectCrossRef>> callback = (List<StudentSubjectCrossRef> crossRefList) -> {
            StudentSubjectAdapter studentSubjectAdapter = new StudentSubjectAdapter(getContext(), crossRefList);
            studentsRecyclerView.setAdapter(studentSubjectAdapter);
            studentsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        };
        asyncTaskRunner.executeAsync(callable, callback);
    }

    private void changeExamDateForSubject(Subject subject) {
        Callable<Integer> callable = () -> subjectRepository.update(subject);
        Callback<Integer> callback = (Integer nr) -> {
            System.out.println("Exam Date changed");
            Toast.makeText(getContext(), "Exam Date Saved", Toast.LENGTH_SHORT).show();
        };
        asyncTaskRunner.executeAsync(callable, callback);
    }
}
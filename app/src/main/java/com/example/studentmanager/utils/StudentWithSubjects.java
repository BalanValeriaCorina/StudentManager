package com.example.studentmanager.utils;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.studentmanager.models.Student;
import com.example.studentmanager.models.StudentSubjectCrossRef;
import com.example.studentmanager.models.Subject;

import java.util.List;

public class StudentWithSubjects {
    @Embedded
    public Student student;
    @Relation(
            parentColumn = "idStudent",
            entityColumn = "idSubject",
            associateBy = @Junction(StudentSubjectCrossRef.class)
    )
    public List<Subject> subjects;
}

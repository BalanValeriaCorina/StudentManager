package com.example.studentmanager.database.utils;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.studentmanager.database.models.Student;
import com.example.studentmanager.database.models.StudentSubjectCrossRef;
import com.example.studentmanager.database.models.Subject;

import java.util.List;

public class SubjectWithStudents {

    @Embedded
    public Subject subject;
    @Relation(
            parentColumn = "IdSubject",
            entityColumn = "IdStud",
            associateBy = @Junction(StudentSubjectCrossRef.class)
    )
    public List<Student> students;
}

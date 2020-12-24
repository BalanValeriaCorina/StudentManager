package com.example.studentmanager.utils;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.studentmanager.models.Profesor;
import com.example.studentmanager.models.Subject;

import java.util.List;

public class ProfesorWithSubjects {

    @Embedded
    public Profesor profesor;

    @Relation(
            parentColumn = "idProfesor",
            entityColumn = "idProfesorSubject")
    public List<Subject> subjects;

}

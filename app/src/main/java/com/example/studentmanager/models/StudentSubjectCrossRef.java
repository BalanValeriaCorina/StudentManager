package com.example.studentmanager.models;

import androidx.room.Entity;

@Entity(primaryKeys = {"idStud", "idSubject"}, tableName = "studentSubjectCross")
public class StudentSubjectCrossRef {
    private int idStud;
    private int idSubject;
    private double grade;


    public StudentSubjectCrossRef(int IdStud, int IdSubject, double grade) {
        idStud = IdStud;
        idSubject = IdSubject;
        this.grade = grade;
    }

    public int getIdStud() {
        return idStud;
    }

    public void setIdStud(int idStud) {
        idStud = idStud;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

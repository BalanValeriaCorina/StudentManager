package com.example.studentmanager.database.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "subjects")
public class Subject {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idSubject")
    private  int idSubject;
    @ColumnInfo(name = "subjectName")
    private String subjectName;
    @ColumnInfo(name = "subjectDateExam")
    private Date subjectDateExam;
    @ColumnInfo(name = "idProfesorSubject")
    private int idProfesorSubject;

    public Subject(int idSubject, String subjectName, Date subjectDateExam, int idProfesorSubject) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
        this.subjectDateExam = subjectDateExam;
        this.idProfesorSubject = idProfesorSubject;
    }


    public Date getSubjectDateExam() {
        return subjectDateExam;
    }

    public void setSubjectDateExam(Date subjectDateExam) {
        this.subjectDateExam = subjectDateExam;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", subjectName='" + subjectName + '\'' +
                ", subjectDateExam=" + subjectDateExam +
                ", idProfesorSubject=" + idProfesorSubject +
                '}';
    }
}

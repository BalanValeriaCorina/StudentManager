package com.example.studentmanager.database.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "subjects",indices = {@Index(value = {"subjectName"},unique = true)})
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
    @ColumnInfo(name = "numberOfTests")
    private int numberOfTests;


    @Ignore
    public Subject(String subjectName, Date subjectDateExam, int numberOfTests) {
        this.subjectName = subjectName;
        this.subjectDateExam = subjectDateExam;
        this.numberOfTests = numberOfTests;
    }

    public Subject(int idSubject, String subjectName, Date subjectDateExam, int idProfesorSubject, int numberOfTests) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
        this.subjectDateExam = subjectDateExam;
        this.idProfesorSubject = idProfesorSubject;
        this.numberOfTests = numberOfTests;
    }

    @Ignore
    public Subject(String subjectName, Date subjectDateExam, int idProfesorSubject, int numberOfTests) {
        this.subjectName = subjectName;
        this.subjectDateExam = subjectDateExam;
        this.idProfesorSubject = idProfesorSubject;
        this.numberOfTests = numberOfTests;
    }

    public int getNumberOfTests() {
        return numberOfTests;
    }

    public void setNumberOfTests(int numberOfTests) {
        this.numberOfTests = numberOfTests;
    }

    public int getIdProfesorSubject() {
        return idProfesorSubject;
    }

    public void setIdProfesorSubject(int idProfesorSubject) {
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
                ", numberOfTests=" + numberOfTests +
                '}';
    }
}

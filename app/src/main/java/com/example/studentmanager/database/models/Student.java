package com.example.studentmanager.database.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

;

@Entity(tableName = "students",indices={@Index(value = {"numarMatricol"},unique = true)})
public class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idStud")
    private int idStud;//e relevant dor pt bd , nu facem constructor cu el
    @ColumnInfo(name = "numeStudent")
    private String numeStudent;
    @ColumnInfo(name = "dataInmatriculare")
    private Date dataInmatriculare;
    @ColumnInfo(name = "frminvatamant")
    private String frminvat;
    @ColumnInfo(name = "group")
    private int group;
    @ColumnInfo(name = "numarMatricol")
    private int numarMatricol;
    @ColumnInfo(name = "emailStudent")
    private String emailStudent;


    public Student(int idStud, String numeStudent, Date dataInmatriculare, String frminvat, int group, int numarMatricol, String emailStudent) {
        this.idStud = idStud;
        this.numeStudent = numeStudent;
        this.dataInmatriculare = dataInmatriculare;
        this.frminvat = frminvat;
        this.group = group;
        this.numarMatricol = numarMatricol;
        this.emailStudent = emailStudent;
    }

    public String getNumeStudent() {
        return numeStudent;
    }

    public void setNumeStudent(String numeStudent) {
        this.numeStudent = numeStudent;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public void setNumarMatricol(int numarMatricol) {
        this.numarMatricol = numarMatricol;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getNume() {
        return numeStudent;
    }

    public void setNume(String nume) {
        numeStudent = nume;
    }

    public Date getDataInmatriculare() {
        return dataInmatriculare;
    }

    public void setDataInmatriculare(Date dataInmatriculare) {
        this.dataInmatriculare = dataInmatriculare;
    }

    public String getFrminvat() {
        return frminvat;
    }

    public void setFrminvat(String frminvat) {
        this.frminvat = frminvat;
    }

    public int getIdStud() {
        return idStud;
    }

    public void setIdStud(int idStud) {
        idStud = idStud;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStud=" + idStud +
                ", numeStudent='" + numeStudent + '\'' +
                ", dataInmatriculare=" + dataInmatriculare +
                ", frminvat='" + frminvat + '\'' +
                ", group=" + group +
                ", numarMatricol=" + numarMatricol +
                ", emailStudent='" + emailStudent + '\'' +
                '}';
    }
}

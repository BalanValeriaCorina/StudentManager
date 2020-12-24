package com.example.studentmanager.database.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "profesors",indices={@Index(value = {"accessCode","emailProfesor"},unique = true)})
public class Profesor {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idProfesor")
    private int idProfesor;
    @ColumnInfo(name = "emailProfesor")
    private String emailProfesor;
    @ColumnInfo(name = "nameProfesor")
    private String nameProfesor;
    @ColumnInfo(name = "accessCode")
    private int accessCode;

    public Profesor(int idProfesor, String emailProfesor, String nameProfesor, int accessCode) {
        this.idProfesor = idProfesor;
        this.emailProfesor = emailProfesor;
        this.nameProfesor = nameProfesor;
        this.accessCode = accessCode;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getEmailProfesor() {
        return emailProfesor;
    }

    public void setEmailProfesor(String emailProfesor) {
        this.emailProfesor = emailProfesor;
    }

    public String getNameProfesor() {
        return nameProfesor;
    }

    public void setNameProfesor(String nameProfesor) {
        this.nameProfesor = nameProfesor;
    }

    public int getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(int accessCode) {
        this.accessCode = accessCode;
    }

    public String getName() {
        return nameProfesor;
    }

    public String getEmail() {
        return emailProfesor;
    }


    public void setName(String name) {
        this.nameProfesor = name;
    }

    public void setEmail(String email) {
        this.emailProfesor = email;
    }


    @Override
    public String toString() {
        return "Profesor{" +
                "idProfesor=" + idProfesor +
                ", emailProfesor='" + emailProfesor + '\'' +
                ", nameProfesor='" + nameProfesor + '\'' +
                ", accessCode=" + accessCode +
                '}';
    }
}

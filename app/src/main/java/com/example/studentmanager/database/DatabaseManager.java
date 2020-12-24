package com.example.studentmanager.database;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.studentmanager.database.daos.ProfesorDao;
import com.example.studentmanager.database.daos.StudentDao;
import com.example.studentmanager.database.daos.StudentSubjectCrossrefDao;
import com.example.studentmanager.database.daos.SubjectDao;
import com.example.studentmanager.database.models.Profesor;
import com.example.studentmanager.database.models.Student;
import com.example.studentmanager.database.models.StudentSubjectCrossRef;
import com.example.studentmanager.database.models.Subject;


@Database(entities={Student.class, Subject.class, StudentSubjectCrossRef.class, Profesor.class},exportSchema = false,version = 1)
public abstract class DatabaseManager extends RoomDatabase {

    public static final String DAM_DB="dam_db";
    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context)
    {
        if (databaseManager == null) {
            synchronized (DatabaseManager.class) {
                if (databaseManager == null) {
                    databaseManager = Room.databaseBuilder(context, DatabaseManager.class, DAM_DB).fallbackToDestructiveMigration().build();
                    //fallbackToDestructiveMigration() daca nu se face migrarea la nivel de coloana, va sterge inregistrarile
                }
            }
        }
        return databaseManager;
    }

public abstract SubjectDao getSubjectDao();
public abstract StudentDao getStudentDao();
public abstract StudentSubjectCrossrefDao getStudentSubjectCrossrefDao();
public  abstract ProfesorDao getProfesorDao();
}

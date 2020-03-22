package com.noooobas.simpledbapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class, Departments.class},version =1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase mINSTANCE;

    public abstract EmployeeDAO employeeDAO();
    public abstract DepartmentsDAO departmentsDAO();

    public static AppDatabase getAppDatabase(Context context) {
        if (mINSTANCE == null) {
            mINSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Database")
                            .allowMainThreadQueries()
                            .build();
        }
        return mINSTANCE;
    }

    public static void destroyInstance() {
        mINSTANCE = null;
    }
}

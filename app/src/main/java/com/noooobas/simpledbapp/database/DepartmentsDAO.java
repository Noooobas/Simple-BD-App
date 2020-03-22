package com.noooobas.simpledbapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DepartmentsDAO {
    @Query("SELECT depart_name FROM departments")
    String[] getDepartmentsList();

    @Insert
    void insert (Departments departments);

    //TODO:Temporary
    @Query("DELETE FROM departments")
    void nukeTable();
}

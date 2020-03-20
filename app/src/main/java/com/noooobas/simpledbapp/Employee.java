package com.noooobas.simpledbapp;


import java.util.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String firstName;

    public String lastName;

    public String fatherName;

    public boolean isActive;

   // public Date hireDate;

    //public Date resigDate;

    @ColumnInfo(name = "department_id")
    public int departmentid;


}


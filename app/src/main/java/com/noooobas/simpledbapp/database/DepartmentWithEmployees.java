package com.noooobas.simpledbapp.database;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

public class DepartmentWithEmployees {

    @Embedded
    public Departments departments;

    @Relation(parentColumn = "id", entityColumn = "department_id")
    public List<Employee> employees;
}

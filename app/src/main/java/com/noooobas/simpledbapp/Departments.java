package com.noooobas.simpledbapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Departments {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String depart_name;
}

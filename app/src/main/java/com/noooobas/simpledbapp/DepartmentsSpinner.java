package com.noooobas.simpledbapp;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class DepartmentsSpinner {

    private static final String TAG = "DepartmentsSpinner";
    static SpinnerAdapter depSpinnerAdapter;
    static int selectedDepartmentID;
    AdapterView.OnItemSelectedListener oisl = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d(TAG, "onItemSelected: "+i);
            selectedDepartmentID = i;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    void getDepartmentsAdapter(SpinnerAdapter spinnerAdapter){
        depSpinnerAdapter = spinnerAdapter;
    }


    public void setDepartmentsAdapter(Spinner spinner) {
        spinner.setAdapter(depSpinnerAdapter);
        spinner.setOnItemSelectedListener(oisl);
    }


    public int getSpinnerPosition() {
        return selectedDepartmentID;
    }

    public void setLastPosition(Spinner spinner){
        Log.d(TAG, "setLastPosition: " + selectedDepartmentID);
        spinner.setSelection(selectedDepartmentID);
    }
}

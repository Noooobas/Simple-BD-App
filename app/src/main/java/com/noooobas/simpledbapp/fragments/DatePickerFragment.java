package com.noooobas.simpledbapp.fragments;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.widget.DatePicker;
import com.noooobas.simpledbapp.R;
import java.util.Calendar;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    int whichFieldRequest;
    public int selectedYear;
    public int selectedMonth;
    public int selectedDay;
    public String stringDate;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        whichFieldRequest = DatePickerFragmentArgs
                .fromBundle(getArguments()).getFieldRequestCode();
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        Bundle bundle = new Bundle();
        bundle.putInt("year",year);
        bundle.putInt("month",month+1);
        bundle.putInt("day",day);
        selectedYear = year;
        selectedMonth = month+1;
        selectedDay = day;
        stringDate = (selectedDay + "/" + selectedMonth + "/" + selectedYear);
        switch (whichFieldRequest){
            case 0:
                //AddEmployeeFragment.passHireDate();
                break;
            case 1:
                break;
            case 2:
                break;
            case -1:
                Log.d(TAG, "onDateSet: arg wasn't passed");
                break;
        }
        try {
            this.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        /*if(searchIsCaller)
        NavHostFragment.findNavController(this)
                .navigate(R.id.action_datePickerFragment_to_searchFragment,bundle);
        else NavHostFragment.findNavController(this)
                .navigate(R.id.action_datePickerFragment_to_addEmployee,bundle);*/

    }


}
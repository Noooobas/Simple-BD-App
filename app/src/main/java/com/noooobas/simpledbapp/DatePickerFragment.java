package com.noooobas.simpledbapp;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    boolean searchIsCaller;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        searchIsCaller = DatePickerFragmentArgs
                .fromBundle(getArguments()).getIsSearchCalled();
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

        if(searchIsCaller)
        NavHostFragment.findNavController(this)
                .navigate(R.id.action_datePickerFragment_to_searchFragment,bundle);
        else NavHostFragment.findNavController(this)
                .navigate(R.id.action_datePickerFragment_to_addEmployee,bundle);

    }

}
package com.noooobas.simpledbapp.fragments;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.noooobas.simpledbapp.DepartmentsSpinner;
import com.noooobas.simpledbapp.R;

import java.util.Objects;



public class SearchFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    private static final String TAG = "Search fragment";
    Spinner searchDepartmentsSpinner,searchSelectorSpinner;
    TextView field_name,field_lastname,field_fathername, field_start_date, field_end_date;
    static int last_selected_option;
    DepartmentsSpinner depSpinner;
    boolean isStartDate;
    static Bundle save;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_search, container, false);

            //Spinners
            searchDepartmentsSpinner = v.findViewById(R.id.search_departments_spinner);
            searchSelectorSpinner = v.findViewById(R.id.search_selector_spinner);

            //Fields
            field_name = v.findViewById(R.id.field_name);
            field_lastname = v.findViewById(R.id.field_lastname);
            field_fathername = v.findViewById(R.id.field_fathername);
            field_start_date = v.findViewById(R.id.field_start_date);
            field_end_date = v.findViewById(R.id.field_end_date);

            ArrayAdapter selectorSpinnerAdapter = ArrayAdapter
                    .createFromResource(Objects.requireNonNull(getActivity()), R.array.search_selector, R.layout.support_simple_spinner_dropdown_item);

            searchSelectorSpinner.setAdapter(selectorSpinnerAdapter);
            searchSelectorSpinner.setOnItemSelectedListener(this);
            depSpinner = new DepartmentsSpinner();
            depSpinner.setDepartmentsAdapter(searchDepartmentsSpinner);

        return v;

    }

    @Override
     public void onResume() {
        super.onResume();
        //searchSelectorSpinner.setSelection(last_selected_option);
        Log.d(TAG, "onResume: "+last_selected_option);
        //depSpinner.setLastPosition(searchDepartmentsSpinner);
        if (getArguments() != null) {
            //TODO fill dates with values
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {
        last_selected_option = i;
        switch(i){
            case 0:
                FIOOptionSelected();
                break;
            case 1:
                departmentOptionSelected();
                break;
            case 2:
               dateOptionSelected();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    void FIOOptionSelected(){
        getActivity().findViewById(R.id.FIO_layout).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.dates_layout).setVisibility(View.GONE);
        searchDepartmentsSpinner.setVisibility(View.GONE);
    }

    void departmentOptionSelected(){
        getActivity().findViewById(R.id.FIO_layout).setVisibility(View.GONE);
        getActivity().findViewById(R.id.dates_layout).setVisibility(View.GONE);
        searchDepartmentsSpinner.setVisibility(View.VISIBLE);
    }

    void dateOptionSelected(){
        getActivity().findViewById(R.id.FIO_layout).setVisibility(View.GONE);
        getActivity().findViewById(R.id.dates_layout).setVisibility(View.VISIBLE);
        searchDepartmentsSpinner.setVisibility(View.GONE);
    }


}

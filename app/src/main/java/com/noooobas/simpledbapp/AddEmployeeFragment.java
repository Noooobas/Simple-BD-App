package com.noooobas.simpledbapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;




public class AddEmployeeFragment extends Fragment implements View.OnClickListener {

    TextView field_hire_date, field_name, field_lastname, field_fathername;
    Spinner add_employee_spinner;
    Button  add_confirm_btn;
    SpinnerAdapter depAd;

    int day,month, year;



    public AddEmployeeFragment() {
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
        View v = inflater.inflate(R.layout.fragment_add_employee, container, false);

        //Fields
        field_hire_date = v.findViewById(R.id.field_hire_date);
        field_fathername = v.findViewById(R.id.field_fathername);
        field_lastname = v.findViewById(R.id.field_lastname);
        field_name = v.findViewById(R.id.field_name);

        //Spinners
        add_employee_spinner = v.findViewById(R.id.add_employee_spinner);
        MainActivity.setSpinnerAdapter(add_employee_spinner);

        //Buttons
        add_confirm_btn = v.findViewById(R.id.add_confirm_btn);
        add_confirm_btn.setOnClickListener(this);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getArguments() != null) {
            year = getArguments().getInt("year");
            month = getArguments().getInt("month");
            day = getArguments().getInt("day");
            String date = (day + "." + month+ "." + year);
            field_hire_date.setText(date);
        }



    }

    @Override
    public void onClick(View view) {
        switch (getId()){
            case R.id.add_confirm_btn:
                Employee employee = new Employee();
                employee.firstName = field_name.getText().toString();
                employee.lastName = field_lastname.getText().toString();
                employee.fatherName = field_fathername.getText().toString();

                //employee.departmentid = ;
                break;
        }
    }

}

package com.noooobas.simpledbapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static SpinnerAdapter spinnerAdapter;
    private int selectedDepartmentID;
    NavController navController;
    NavGraphDirections.ActionGlobalDatePickerFragment callDatePicker = DatePickerFragmentDirections
            .actionGlobalDatePickerFragment(true);
    AppDatabase db;
    String[] depList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        //Spinner add_employee_spinner = findViewById(R.id.add_employee_spinner);
        //Spinner search_employee_spinner = findViewById(R.id.search_employee_spinner);
        db = AppDatabase.getAppDatabase(this);
        //TODO:Temporary
        db.departmentsDAO().nukeTable();
        //
        fillDepartments();
        depList = db.departmentsDAO().getDepartmentsList();
        spinnerAdapter = new ArrayAdapter<String>
                (this, R.layout.support_simple_spinner_dropdown_item,depList);




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You shouldn't have done that", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Navigation except for datePicker
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_employee_btn:
                navController.navigate(R.id.action_MainFragment_to_addEmployee);
                break;
            case R.id.search_btn:
                navController.navigate(R.id.action_MainFragment_to_searchFragment);
                break;
            case R.id.field_hire_date:
                callDatePicker.setIsSearchCalled(false);
                navController.navigate(callDatePicker);
                break;
            case R.id.field_end_date:
            case R.id.field_start_date:
                callDatePicker.setIsSearchCalled(true);
                navController.navigate(callDatePicker);
                break;
            case  R.id.cancel_btn:
                navController.popBackStack();
                break;

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selectedDepartmentID = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static void setSpinnerAdapter(Spinner spinner){
        spinner.setAdapter(spinnerAdapter);

    }

    void fillDepartments(){
        Departments dep1 = new Departments();
        dep1.depart_name = "Отдел №1";
        db.departmentsDAO().insert(dep1);

        Departments dep2 = new Departments();
        dep2.depart_name = "Отдел №2";
        db.departmentsDAO().insert(dep2);

        Departments dep3 = new Departments();
        dep3.depart_name = "Отдел №3";
        db.departmentsDAO().insert(dep3);
    }

    public int getDepartSpinnerPosition (){
        return selectedDepartmentID;
    }
}

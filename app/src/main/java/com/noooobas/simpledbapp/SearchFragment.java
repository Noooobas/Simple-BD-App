package com.noooobas.simpledbapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Spinner searchDepartmentsSpinner,searchSelectorSpinner;
    TextView tv_name,tv_lastname;
    Layout lt_fathername,lt_lastname, lt_name;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_search, container, false);

        //Spinners
        searchDepartmentsSpinner = v.findViewById(R.id.search_departments_spinner);
        searchSelectorSpinner = v.findViewById(R.id.search_selector_spinner);

        //Textviews
        tv_name = v.findViewById(R.id.tv_name);
        tv_lastname = v.findViewById(R.id.tv_lastname);

        //Layouts


        ArrayAdapter selectorSpinnerAdapter = ArrayAdapter
                .createFromResource(Objects.requireNonNull(getContext()), R.array.search_selector,R.layout.support_simple_spinner_dropdown_item);

        searchSelectorSpinner.setAdapter(selectorSpinnerAdapter);
        searchSelectorSpinner.setOnItemSelectedListener(this);
        MainActivity.setSpinnerAdapter(searchDepartmentsSpinner);

        return v;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {

        switch(i){
            case 0:
                if (searchDepartmentsSpinner.getVisibility() == View.VISIBLE) {
                    getActivity().findViewById(R.id.name_layout).setVisibility(View.VISIBLE);
                    getActivity().findViewById(R.id.last_name_layout).setVisibility(View.VISIBLE);
                    getActivity().findViewById(R.id.fathername_layout).setVisibility(View.VISIBLE);
                    searchDepartmentsSpinner.setVisibility(View.GONE);
                }
                else {
                    getActivity().findViewById(R.id.fathername_layout).setVisibility(View.VISIBLE);
                }
                if (tv_name.getText().equals(getString(R.string.start_date))) {
                    tv_name.setText(R.string.employee_name);
                    tv_lastname.setText(R.string.employee_fathername);
                }
                break;
            case 1:
                getActivity().findViewById(R.id.name_layout).setVisibility(View.GONE);
                getActivity().findViewById(R.id.last_name_layout).setVisibility(View.GONE);
                getActivity().findViewById(R.id.fathername_layout).setVisibility(View.GONE);
                searchDepartmentsSpinner.setVisibility(View.VISIBLE);
                break;
            case 2:
                if (searchDepartmentsSpinner.getVisibility() == View.VISIBLE){
                    getActivity().findViewById(R.id.name_layout).setVisibility(View.VISIBLE);
                    getActivity().findViewById(R.id.last_name_layout).setVisibility(View.VISIBLE);
                    searchDepartmentsSpinner.setVisibility(View.GONE);
                }
                else {
                    getActivity().findViewById(R.id.fathername_layout).setVisibility(View.GONE);
                }
                if (tv_name.getText().equals(getString(R.string.employee_name))) {
                    tv_name.setText(R.string.start_date);
                    tv_lastname.setText(R.string.end_date);
                }

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}

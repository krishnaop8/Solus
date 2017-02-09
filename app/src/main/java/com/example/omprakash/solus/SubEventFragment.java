package com.example.omprakash.solus;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SubEventFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Toolbar toolbar;

    // TODO: Rename and change types of parameters
    private String eventTtle;
    private int colorId;


    public SubEventFragment() {
        // Required empty public constructor
    }

    public static SubEventFragment newInstance(String eventTitle,int colorId) {
        SubEventFragment fragment = new SubEventFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, eventTitle);
        args.putInt(ARG_PARAM2, colorId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            eventTtle = getArguments().getString(ARG_PARAM1);
            colorId = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub_event, container, false);
        return view;
    }

}

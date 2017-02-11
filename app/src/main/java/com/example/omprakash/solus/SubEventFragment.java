package com.example.omprakash.solus;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.omprakash.solus.Events.Events;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.R.id.list;

public class SubEventFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Toolbar toolbar;
    private String subEventURL = "https://api.myjson.com/bins/wy465";

    // TODO: Rename and change types of parameters
    private String eventTitle;
    private int colorId;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private ArrayList<SubEvents> SubEventsList;
    private SubEventAdapter subEventAdapter;
    private TextView EmptyTextView;
    private ArrayList<SubEvents> AL;

    public SubEventFragment() {
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
            eventTitle = getArguments().getString(ARG_PARAM1);
            colorId = getArguments().getInt(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_event, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(SubEventFragment.this.getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        SubEventsList = new ArrayList<SubEvents>();

        getList();

        subEventAdapter = new SubEventAdapter(SubEventsList,SubEventFragment.this.getContext(),SubEventFragment.this,eventTitle);

        mRecyclerView.setAdapter(subEventAdapter);
        return view;
    }

    private void getList() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(subEventURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int count = 0;
                while(count<response.length()){
                    SubEvents se = new SubEvents(SubEventFragment.this.getContext());
                    try {
                        JSONObject j = response.getJSONObject(count);
                        if(j.get("Event").equals(eventTitle)) {
                            se.setmEvent(j.getString("Event"));
                            se.setmAbout(j.getString("About"));
                            se.setmSchedule(j.getString("Schedule"));
                            se.setmContact(j.getString("Contact"));
                            se.setmVenue(j.getString("Venue"));
                            SubEventsList.add(se);
                            subEventAdapter.notifyDataSetChanged();
                        }
                        count = count + 1;
                    } catch (JSONException e) {
                        Toast.makeText(SubEventFragment.this.getContext(),"Error ... ",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleton.getInstance(SubEventFragment.this.getContext()).addToRequestQueue(jsonArrayRequest);
    }


}

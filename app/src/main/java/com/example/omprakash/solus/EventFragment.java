package com.example.omprakash.solus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.omprakash.solus.Events.Events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private EventsAdapter eventsAdapter;
    private ArrayList<Events> EventList;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(EventFragment.this.getActivity());
        String[] eventsList = getResources().getStringArray(R.array.event_list);
        List<String> mEventsList = new ArrayList<String>(Arrays.asList(eventsList));
        EventList = new ArrayList<Events>();
        for(int i=0;i<mEventsList.size();i++)
        {
            String s = mEventsList.get(i);
            Events e = new Events(s);
            EventList.add(e);
        }
        eventsAdapter = new EventsAdapter(EventList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(eventsAdapter);
        return view;
    }

}

package com.example.omprakash.solus;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.omprakash.solus.Events.Events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EventFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private EventsAdapter eventsAdapter;
    private ArrayList<Events> EventList;
    public LinearLayout linearLayout;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        linearLayout = (LinearLayout)view.findViewById(R.id.eventLayout);
        gridLayoutManager = new GridLayoutManager(EventFragment.this.getActivity(),2);
        //mLinearLayoutManager = new LinearLayoutManager(EventFragment.this.getActivity());
        String[] eventsList = getResources().getStringArray(R.array.event_list);
        List<String> mEventsList = new ArrayList<String>(Arrays.asList(eventsList));
        int[] eventColorList = getResources().getIntArray(R.array.events_color_array);
        List<Integer> mColorList = new ArrayList<Integer>();
        for (int index = 0; index < eventColorList.length; index++)
        {
            mColorList.add(eventColorList[index]);
        }
        EventList = new ArrayList<Events>();

        populate(R.drawable.design_and_media,mEventsList.get(0),mColorList.get(0));
        populate(R.drawable.online,mEventsList.get(1),mColorList.get(1));
        populate(R.drawable.adventure,mEventsList.get(2),mColorList.get(2));
        populate(R.drawable.fine_arts,mEventsList.get(3),mColorList.get(3));
        populate(R.drawable.thespian,mEventsList.get(4),mColorList.get(4));
        populate(R.drawable.variety_shows,mEventsList.get(5),mColorList.get(5));
        populate(R.drawable.quiz,mEventsList.get(6),mColorList.get(5));
        populate(R.drawable.sport,mEventsList.get(7),mColorList.get(6));
        populate(R.drawable.gamindrome,mEventsList.get(8),mColorList.get(7));
        populate(R.drawable.word_games,mEventsList.get(9),mColorList.get(8));
        populate(R.drawable.dance,mEventsList.get(10),mColorList.get(9));
        populate(R.drawable.dance,mEventsList.get(11),mColorList.get(10));
        populate(R.drawable.tamil,mEventsList.get(12),mColorList.get(11));
        populate(R.drawable.music,mEventsList.get(13),mColorList.get(12));
        populate(R.drawable.fun,mEventsList.get(14),mColorList.get(13));


        eventsAdapter = new EventsAdapter(EventList,EventFragment.this.getContext(),EventFragment.this);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(eventsAdapter);
       // mRecyclerView.setHasFixedSize(true);
        return view;
    }


    private void populate(int imageId,String s,int colorId) {
        Events e = new Events(imageId,s,colorId);
        EventList.add(e);

    }

}

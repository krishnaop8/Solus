package com.example.omprakash.solus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.omprakash.solus.Events.Events;

import java.util.ArrayList;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventHolder> {
    public Context context;
    EventHolder eventHolder;
    int lastPosition = -1;
    private ArrayList<Events> EventList;

    public EventsAdapter(ArrayList<Events> events,Context context){
        this.context=context;
        EventList = events;
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row,parent,false);
        eventHolder = new EventHolder(inflatedView);
        return eventHolder;
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        Events events = EventList.get(position);
        holder.eventTitle.setText(events.getTitle());

        if(position >lastPosition) {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.up_from_bottom);
            eventHolder.itemView.startAnimation(animation);
            lastPosition = position;
        }


    }

    @Override
    public int getItemCount() {
        return EventList.size();
    }

    public static class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView eventTitle;
        public EventHolder(View itemView) {
            super(itemView);
            eventTitle = (TextView)itemView.findViewById(R.id.event_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}

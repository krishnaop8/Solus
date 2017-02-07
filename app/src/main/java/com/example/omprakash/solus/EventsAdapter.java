package com.example.omprakash.solus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.omprakash.solus.Events.Events;

import java.util.ArrayList;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventHolder> {
    private ArrayList<Events> EventList;

    public EventsAdapter(ArrayList<Events> events){
        EventList = events;
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row,parent,false);
        return new EventHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        Events events = EventList.get(position);
        holder.bindEvent(events);

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
        public void bindEvent(Events events){
            eventTitle.setText(events.getTitle());
        }

        @Override
        public void onClick(View v) {

        }
    }
}

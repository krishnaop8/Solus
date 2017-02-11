package com.example.omprakash.solus;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.omprakash.solus.Events.Events;

import java.util.ArrayList;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventHolder> {
    public Context context;
    EventHolder eventHolder;
    public ArrayList<Events> EventList;
    public EventFragment eventFragment;
    private int lastPosition = -1;

    public EventsAdapter(ArrayList<Events> events, Context context, EventFragment e){
        this.eventFragment=e;
        this.context=context;
        EventList = events;
    }


    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_row,parent,false);
        eventHolder = new EventHolder(inflatedView,context,EventList,eventFragment);
        return eventHolder;
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        Events events = EventList.get(position);
        holder.eventTitle.setText(events.getTitle());
        holder.imageView.setImageResource(events.getImageId());
        holder.linearLayout.setBackgroundColor(events.getColorId());
    }


    @Override
    public int getItemCount() {

        return EventList.size();
    }


    public static class EventHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView eventTitle;
        public ImageView imageView;
        public LinearLayout linearLayout;
        ArrayList<Events> mEventList = new ArrayList<Events>();
        Context ctx;
        EventFragment EF;
        public EventHolder(View itemView, Context ctx, ArrayList<Events> e, EventFragment EF) {
            super(itemView);
            this.EF=EF;
            this.mEventList = e;
            this.ctx = ctx;
            eventTitle = (TextView)itemView.findViewById(R.id.event_title);
            imageView = (ImageView)itemView.findViewById(R.id.eventImage);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.bannerLayout);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Events events = this.mEventList.get(position);
            SubEventFragment subEventFragment = SubEventFragment.newInstance(events.getTitle(),events.getColorId());
            FragmentManager fm = EF.getActivity().getSupportFragmentManager();
            fm.beginTransaction().addToBackStack(null).add(EF.getId(),subEventFragment).commit();

          //  Toast.makeText(ctx,events.getTitle(),Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.omprakash.solus;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omprakash.solus.Events.Events;

import java.util.ArrayList;

public class SubEventAdapter extends RecyclerView.Adapter<SubEventAdapter.SubEventHolder> {
    public Context context;
    private SubEventHolder subEventHolder;
    public ArrayList<SubEvents> subEventList;
    SubEventFragment subEventFragment;
    private String eventTitle;

    public SubEventAdapter(ArrayList<SubEvents> SubEventList, Context context, SubEventFragment se,String eventTitle){
        this.subEventList = SubEventList;
        this.context=context;
        this.subEventFragment=se;
        this.eventTitle = eventTitle;
    }

    @Override
    public SubEventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_event_row,parent,false);
        subEventHolder = new SubEventHolder(inflatedView,context,subEventList,subEventFragment);
        return subEventHolder;
    }



    @Override
    public void onBindViewHolder(SubEventHolder holder, int position) {

        SubEvents subEvents = subEventList.get(position);

            holder.About.setText(subEvents.getmAbout());
            holder.Schedule.setText(subEvents.getmSchedule());
            holder.Contact.setText(subEvents.getmContact());
            holder.Venue.setText(subEvents.getmVenue());
    }

    @Override
    public int getItemCount() {
        return subEventList.size();
    }

    public class SubEventHolder extends RecyclerView.ViewHolder {

        private TextView About;
        private TextView Schedule;
        private TextView Contact;
        private TextView Venue;
        private CardView cardView;
        ArrayList<SubEvents> mSubEventList = new ArrayList<SubEvents>();
        Context ctx;
        SubEventFragment SEF;

        public SubEventHolder(View itemView, Context context, ArrayList<SubEvents> subEventList, SubEventFragment subEventFragment) {
            super(itemView);
            this.ctx=context;
            this.mSubEventList=subEventList;
            this.SEF=subEventFragment;
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            About = (TextView)itemView.findViewById(R.id.about);
            Schedule = (TextView)itemView.findViewById(R.id.Schedule);
            Contact = (TextView)itemView.findViewById(R.id.contact);
            Venue = (TextView)itemView.findViewById(R.id.venue);
        }
    }
}

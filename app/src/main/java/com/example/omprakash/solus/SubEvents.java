package com.example.omprakash.solus;

import android.content.Context;

public class SubEvents {
    private Context context;
    private String mAbout;
    private String mSchedule;
    private String mVenue;
    private String mContact;
    private String mEvent;

    public String getmEventTitle() {
        return mEventTitle;
    }

    public void setmEventTitle(String mEventTitle) {
        this.mEventTitle = mEventTitle;
    }

    private String mEventTitle;

    public String getmEvent() {
        return mEvent;
    }

    public void setmEvent(String mEvent) {
        this.mEvent = mEvent;
    }

    public SubEvents(Context context){
        this.context=context;
    }

    public String getmAbout() {
        return mAbout;
    }

    public void setmAbout(String mAbout) {
        this.mAbout = mAbout;
    }

    public String getmSchedule() {
        return mSchedule;
    }

    public void setmSchedule(String mSchedule) {
        this.mSchedule = mSchedule;
    }

    public String getmVenue() {
        return mVenue;
    }

    public void setmVenue(String mVenue) {
        this.mVenue = mVenue;
    }

    public String getmContact() {
        return mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }
}

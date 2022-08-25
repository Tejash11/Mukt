package com.example.mukt.event_section.model_class;

public class event_info {
    String event_name;
    String event_date;
    String event_day;
    String event_documentation;
    String event_time;
    String venue_address;
    String venue_name;
    String event_url1;
    String latitude;
    String longitude;
    String organizer_name;
    String event_type;

    public event_info()
    {

    }

    public event_info(String event_type, String organizer_name, String event_name, String event_date, String event_day, String event_documentation, String event_time, String venue_address, String venue_name, String event_url1, String latitude, String longitude) {
        this.event_name = event_name;
        this.event_type = event_type;
        this.event_date = event_date;
        this.event_day = event_day;
        this.event_documentation = event_documentation;
        this.event_time = event_time;
        this.venue_address = venue_address;
        this.venue_name = venue_name;
        this.event_url1 = event_url1;
        this.latitude = latitude;
        this.longitude = longitude;
        this.organizer_name = organizer_name;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getOrganizer_name() {
        return organizer_name;
    }

    public void setOrganizer_name(String organizer_name) {
        this.organizer_name = organizer_name;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_day() {
        return event_day;
    }

    public void setEvent_day(String event_day) {
        this.event_day = event_day;
    }

    public String getEvent_documentation() {
        return event_documentation;
    }

    public void setEvent_documentation(String event_documentation) {
        this.event_documentation = event_documentation;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getVenue_address() {
        return venue_address;
    }

    public void setVenue_address(String venue_address) {
        this.venue_address = venue_address;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getEvent_url1() {
        return event_url1;
    }

    public void setEvent_url1(String event_url1) {
        this.event_url1 = event_url1;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

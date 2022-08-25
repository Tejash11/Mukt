package com.example.mukt.profile_section.model_class;

public class credit_trans_info {

    String event_name;
    String type;
    int net;

    public credit_trans_info()
    {

    }

    public credit_trans_info(String event_name, String type, int net) {
        this.event_name = event_name;
        this.type = type;
        this.net = net;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }
}

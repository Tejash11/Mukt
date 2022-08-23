package com.example.mukt.profile_section;

import com.example.mukt.profile_section.model_class.credit_trans_info;
import com.example.mukt.profile_section.model_class.interest_type;

public class profile_info {
    String name, mail;
    int event_participated, credit_amount;
    credit_trans_info credit_info;
    interest_type interest;

    public profile_info()
    {

    }

    public profile_info(String name, String mail, int event_participated, int credit_amount, credit_trans_info credit_info, interest_type interest) {
        this.name = name;
        this.mail = mail;
        this.event_participated = event_participated;
        this.credit_amount = credit_amount;
        this.credit_info = credit_info;
        this.interest = interest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getEvent_participated() {
        return event_participated;
    }

    public void setEvent_participated(int event_participated) {
        this.event_participated = event_participated;
    }

    public int getCredit_amount() {
        return credit_amount;
    }

    public void setCredit_amount(int credit_amount) {
        this.credit_amount = credit_amount;
    }

    public credit_trans_info getCredit_info() {
        return credit_info;
    }

    public void setCredit_info(credit_trans_info credit_info) {
        this.credit_info = credit_info;
    }

    public interest_type getInterest() {
        return interest;
    }

    public void setInterest(interest_type interest) {
        this.interest = interest;
    }
}

package com.example.myapplication;

public class information {
    private String title;
    private String subject;
    private String location;
    private String fee;
    private String contact;
    private String others;

    public information(String title, String subject, String location, String fee, String contact, String others) {
        this.title = title;
        this.subject = subject;
        this.location = location;
        this.fee = fee;
        this.contact = contact;
        this.others = others;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}

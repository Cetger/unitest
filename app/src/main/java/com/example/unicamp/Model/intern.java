package com.example.unicamp.Model;

public class intern {

    private String title;
    private String kurum;
    private String Date;
    private String location;

    public intern(String title, String kurum, String date, String location) {
        this.title = title;
        this.kurum = kurum;
        this.Date = date;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKurum() {
        return kurum;
    }

    public void setKurum(String kurum) {
        this.kurum = kurum;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

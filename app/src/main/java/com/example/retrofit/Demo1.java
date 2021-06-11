package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Demo1 {

   // @SerializedName("monhoc")    //công dụng serialize dùng để chuyển đổi key
    private String monhoc;
    private String noihoc;
    private String website;
    private String fanpage;
    private String logo;

    /**
     * No args constructor for use in serialization
     *
     */
    public Demo1() {
    }

    /**
     *
     * @param monhoc
     * @param website
     * @param noihoc
     * @param fanpage
     * @param logo
     */
    public Demo1(String monhoc, String noihoc, String website, String fanpage, String logo) {
        super();
        this.monhoc = monhoc;
        this.noihoc = noihoc;
        this.website = website;
        this.fanpage = fanpage;
        this.logo = logo;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public String getNoihoc() {
        return noihoc;
    }

    public void setNoihoc(String noihoc) {
        this.noihoc = noihoc;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFanpage() {
        return fanpage;
    }

    public void setFanpage(String fanpage) {
        this.fanpage = fanpage;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Demo1{" +
                "monhoc='" + monhoc + '\'' +
                ", noihoc='" + noihoc + '\'' +
                ", website='" + website + '\'' +
                ", fanpage='" + fanpage + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}

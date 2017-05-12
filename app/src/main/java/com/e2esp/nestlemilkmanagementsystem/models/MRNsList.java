package com.e2esp.nestlemilkmanagementsystem.models;

/**
 * Created by Asad on 5/12/2017.
 */

public class MRNsList {
    private String mrnNum;
    private String supplier;
    private double vol;
    private double fat;
    private double lr;
    private String status;

    public MRNsList(String mrnNum, String supplier, double vol, double fat, double lr, String status) {
        this.mrnNum = mrnNum;
        this.supplier = supplier;
        this.vol = vol;
        this.fat = fat;
        this.lr = lr;
        this.status = status;
    }

    public String getMrnNum() {
        return mrnNum;
    }

    public String getSupplier() {
        return supplier;
    }

    public double getVol() {
        return vol;
    }

    public double getFat() {
        return fat;
    }

    public double getLr() {
        return lr;
    }

    public String getStatus() {
        return status;
    }
}

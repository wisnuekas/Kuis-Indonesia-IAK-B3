package com.example.android.iak_b3pip;

import android.app.Application;

import java.io.Serializable;

/**
 * Created by wisnuekas on 5/17/17.
 */

public class Data implements Serializable {

    private int skor;
    private String nama;

    public Data(String nama) {

        this.nama = nama;
        this.skor = 0;
    }

    public Data() {

    }

    public void incrementSkor() {
        this.skor++;
    }

    public void decrementSkor() {
        this.skor--;
    }

    public int getSkor() {
        return skor;
    }

    public String getNama() {
        return nama;
    }

}

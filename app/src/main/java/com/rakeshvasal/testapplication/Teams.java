package com.rakeshvasal.testapplication;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Teams implements Serializable {
    @SerializedName("5")
    Team teamhome;
    @SerializedName("4")
    Team teamaway;
}

package com.test.bin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WR {

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("data")
    @Expose
    public List<Data> data;

    public class Data{

        @SerializedName("city")
        @Expose
        public String city;
    }

}

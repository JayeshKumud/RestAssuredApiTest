package com.test.bin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WR {

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("data")
    @Expose
    public Data data;

    public class Data{

        @SerializedName("city")
        @Expose
        public String city;
    }

}

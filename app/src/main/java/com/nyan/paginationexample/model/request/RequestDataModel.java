
package com.nyan.paginationexample.model.request;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RequestDataModel {

    @SerializedName("driverId")
    private String mDriverId;
    @SerializedName("limit")
    private int mLimit;
    @SerializedName("offset")
    private int mOffset;

    public String getDriverId() {
        return mDriverId;
    }

    public void setDriverId(String driverId) {
        mDriverId = driverId;
    }

    public int getLimit() {
        return mLimit;
    }

    public void setLimit(int limit) {
        mLimit = limit;
    }

    public int getOffset() {
        return mOffset;
    }

    public void setOffset(int offset) {
        mOffset = offset;
    }

}


package com.nyan.paginationexample.model.response;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Dropoff {

    @SerializedName("detail_type")
    private String mDetailType;
    @SerializedName("full_address")
    private String mFullAddress;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private String mPhone;

    public String getDetailType() {
        return mDetailType;
    }

    public void setDetailType(String detailType) {
        mDetailType = detailType;
    }

    public String getFullAddress() {
        return mFullAddress;
    }

    public void setFullAddress(String fullAddress) {
        mFullAddress = fullAddress;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

}

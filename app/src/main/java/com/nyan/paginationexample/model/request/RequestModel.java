
package com.nyan.paginationexample.model.request;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RequestModel {

    @SerializedName("apiKey")
    private String mApiKey;
    @SerializedName("data")
    private RequestDataModel mData;

    public String getApiKey() {
        return mApiKey;
    }

    public void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }

    public RequestDataModel getData() {
        return mData;
    }

    public void setData(RequestDataModel data) {
        mData = data;
    }

}

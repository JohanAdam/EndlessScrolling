
package com.nyan.paginationexample.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ResponseModel {

    @SerializedName("msg")
    private String mMsg;
    @SerializedName("response_code")
    private int mResponseCode;
    @SerializedName("return")
    private ResponseReturnModel mReturn;
    @SerializedName("status")
    private Boolean mStatus;

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public int getResponseCode() {
        return mResponseCode;
    }

    public void setResponseCode(int responseCode) {
        mResponseCode = responseCode;
    }

    public ResponseReturnModel getReturn() {
        return mReturn;
    }

    public void setReturn(ResponseReturnModel mreturn) {
        mReturn = mreturn;
    }

    public Boolean getStatus() {
        return mStatus;
    }

    public void setStatus(Boolean status) {
        mStatus = status;
    }

}

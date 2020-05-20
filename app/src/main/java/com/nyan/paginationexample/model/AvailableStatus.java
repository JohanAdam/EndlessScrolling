
package com.nyan.paginationexample.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AvailableStatus {

    @SerializedName("id")
    private String mId;
    @SerializedName("need_remarks")
    private String mNeedRemarks;
    @SerializedName("need_signature")
    private String mNeedSignature;
    @SerializedName("need_validate_sub_packpage")
    private String mNeedValidateSubPackpage;
    @SerializedName("tlo_status")
    private String mTloStatus;
    @SerializedName("tlo_status_description")
    private String mTloStatusDescription;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getNeedRemarks() {
        return mNeedRemarks;
    }

    public void setNeedRemarks(String needRemarks) {
        mNeedRemarks = needRemarks;
    }

    public String getNeedSignature() {
        return mNeedSignature;
    }

    public void setNeedSignature(String needSignature) {
        mNeedSignature = needSignature;
    }

    public String getNeedValidateSubPackpage() {
        return mNeedValidateSubPackpage;
    }

    public void setNeedValidateSubPackpage(String needValidateSubPackpage) {
        mNeedValidateSubPackpage = needValidateSubPackpage;
    }

    public String getTloStatus() {
        return mTloStatus;
    }

    public void setTloStatus(String tloStatus) {
        mTloStatus = tloStatus;
    }

    public String getTloStatusDescription() {
        return mTloStatusDescription;
    }

    public void setTloStatusDescription(String tloStatusDescription) {
        mTloStatusDescription = tloStatusDescription;
    }

}

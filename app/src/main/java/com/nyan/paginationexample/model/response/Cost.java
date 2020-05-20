
package com.nyan.paginationexample.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

@SuppressWarnings("unused")
public class Cost {

    @SerializedName("actual_dim_weight")
    private String mActualDimWeight;
    @SerializedName("actual_height")
    private String mActualHeight;
    @SerializedName("actual_length")
    private String mActualLength;
    @SerializedName("actual_volume")
    private String mActualVolume;
    @SerializedName("actual_weight")
    private String mActualWeight;
    @SerializedName("actual_width")
    private String mActualWidth;
    @SerializedName("available_remarks")
    private List<Object> mAvailableRemarks;
    @SerializedName("available_statuses")
    private List<AvailableStatus> mAvailableStatuses;
    @SerializedName("cost_status")
    private String mCostStatus;
    @SerializedName("dimension_unit")
    private String mDimensionUnit;
    @SerializedName("dropoff")
    private Dropoff mDropoff;
    @SerializedName("id")
    private String mId;
    @SerializedName("items")
    private List<Object> mItems;
    @SerializedName("package_id")
    private String mPackageId;
    @SerializedName("package_retail_price")
    private String mPackageRetailPrice;
    @SerializedName("package_retail_price_currency")
    private String mPackageRetailPriceCurrency;
    @SerializedName("package_tracking_number")
    private String mPackageTrackingNumber;
    @SerializedName("payment_method")
    private String mPaymentMethod;
    @SerializedName("payment_status")
    private String mPaymentStatus;
    @SerializedName("pickup")
    private Pickup mPickup;
    @SerializedName("tlo_status")
    private String mTloStatus;
    @SerializedName("tlo_status_description")
    private String mTloStatusDescription;
    @SerializedName("total_sub_package")
    private String mTotalSubPackage;
    @SerializedName("volume_unit")
    private String mVolumeUnit;
    @SerializedName("weight_unit")
    private String mWeightUnit;

    public String getActualDimWeight() {
        return mActualDimWeight;
    }

    public void setActualDimWeight(String actualDimWeight) {
        mActualDimWeight = actualDimWeight;
    }

    public String getActualHeight() {
        return mActualHeight;
    }

    public void setActualHeight(String actualHeight) {
        mActualHeight = actualHeight;
    }

    public String getActualLength() {
        return mActualLength;
    }

    public void setActualLength(String actualLength) {
        mActualLength = actualLength;
    }

    public String getActualVolume() {
        return mActualVolume;
    }

    public void setActualVolume(String actualVolume) {
        mActualVolume = actualVolume;
    }

    public String getActualWeight() {
        return mActualWeight;
    }

    public void setActualWeight(String actualWeight) {
        mActualWeight = actualWeight;
    }

    public String getActualWidth() {
        return mActualWidth;
    }

    public void setActualWidth(String actualWidth) {
        mActualWidth = actualWidth;
    }

    public List<Object> getAvailableRemarks() {
        return mAvailableRemarks;
    }

    public void setAvailableRemarks(List<Object> availableRemarks) {
        mAvailableRemarks = availableRemarks;
    }

    public List<AvailableStatus> getAvailableStatuses() {
        return mAvailableStatuses;
    }

    public void setAvailableStatuses(List<AvailableStatus> availableStatuses) {
        mAvailableStatuses = availableStatuses;
    }

    public String getCostStatus() {
        return mCostStatus;
    }

    public void setCostStatus(String costStatus) {
        mCostStatus = costStatus;
    }

    public String getDimensionUnit() {
        return mDimensionUnit;
    }

    public void setDimensionUnit(String dimensionUnit) {
        mDimensionUnit = dimensionUnit;
    }

    public Dropoff getDropoff() {
        return mDropoff;
    }

    public void setDropoff(Dropoff dropoff) {
        mDropoff = dropoff;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public List<Object> getItems() {
        return mItems;
    }

    public void setItems(List<Object> items) {
        mItems = items;
    }

    public String getPackageId() {
        return mPackageId;
    }

    public void setPackageId(String packageId) {
        mPackageId = packageId;
    }

    public String getPackageRetailPrice() {
        return mPackageRetailPrice;
    }

    public void setPackageRetailPrice(String packageRetailPrice) {
        mPackageRetailPrice = packageRetailPrice;
    }

    public String getPackageRetailPriceCurrency() {
        return mPackageRetailPriceCurrency;
    }

    public void setPackageRetailPriceCurrency(String packageRetailPriceCurrency) {
        mPackageRetailPriceCurrency = packageRetailPriceCurrency;
    }

    public String getPackageTrackingNumber() {
        return mPackageTrackingNumber;
    }

    public void setPackageTrackingNumber(String packageTrackingNumber) {
        mPackageTrackingNumber = packageTrackingNumber;
    }

    public String getPaymentMethod() {
        return mPaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        mPaymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return mPaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        mPaymentStatus = paymentStatus;
    }

    public Pickup getPickup() {
        return mPickup;
    }

    public void setPickup(Pickup pickup) {
        mPickup = pickup;
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

    public String getTotalSubPackage() {
        return mTotalSubPackage;
    }

    public void setTotalSubPackage(String totalSubPackage) {
        mTotalSubPackage = totalSubPackage;
    }

    public String getVolumeUnit() {
        return mVolumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        mVolumeUnit = volumeUnit;
    }

    public String getWeightUnit() {
        return mWeightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        mWeightUnit = weightUnit;
    }

}

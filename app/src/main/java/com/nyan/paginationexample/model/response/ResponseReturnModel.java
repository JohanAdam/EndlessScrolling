
package com.nyan.paginationexample.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

@SuppressWarnings("unused")
public class ResponseReturnModel {

    @SerializedName("costs")
    private List<Cost> mCosts;
    @SerializedName("total_cost")
    private int mTotalCost;

    public List<Cost> getCosts() {
        return mCosts;
    }

    public void setCosts(List<Cost> costs) {
        mCosts = costs;
    }

    public int getTotalCost() {
        return mTotalCost;
    }

    public void setTotalCost(int totalCost) {
        mTotalCost = totalCost;
    }

}

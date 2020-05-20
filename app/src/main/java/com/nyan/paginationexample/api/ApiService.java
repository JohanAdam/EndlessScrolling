package com.nyan.paginationexample.api;

import com.nyan.paginationexample.model.response.ResponseModel;
import com.nyan.paginationexample.model.request.RequestModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

  @POST("partner/cost/lastMile")
  Call<ResponseModel> getLastMile(
      @Body RequestModel body);

}

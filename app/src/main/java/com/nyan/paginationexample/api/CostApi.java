package com.nyan.paginationexample.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CostApi {

  private static Retrofit retrofit = null;

  // builds OkHttpClient with logging Interceptor
  private static OkHttpClient buildClient() {
    return new OkHttpClient
        .Builder()
        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build();
  }
  public static Retrofit getClient() {
    if (retrofit == null) {
      retrofit = new Retrofit.Builder()
          .client(buildClient())
          .addConverterFactory(GsonConverterFactory.create())
//          .baseUrl("https://terminalapi.thelorry.com")
          .baseUrl("http://terminalapitest.thelorry.com/")
          .build();
    }
    return retrofit;
  }

//  public static Retrofit getClient() {
//    if (retrofit == null) {
//      retrofit = new Retrofit.Builder()
//          .addConverterFactory(GsonConverterFactory.create())
//          .baseUrl("http://terminalapitest.thelorry.com/")
//          .build();
//    }
//    return retrofit;
//  }
}

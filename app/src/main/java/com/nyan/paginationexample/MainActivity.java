package com.nyan.paginationexample;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nyan.paginationexample.adapter.PaginationAdapter;
import com.nyan.paginationexample.adapter.PaginationScrollListener;
import com.nyan.paginationexample.api.ApiService;
import com.nyan.paginationexample.api.CostApi;
import com.nyan.paginationexample.model.Cost;
import com.nyan.paginationexample.model.ResponseModel;
import com.nyan.paginationexample.model.request.RequestDataModel;
import com.nyan.paginationexample.model.request.RequestModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  // Index from which pagination should start (0 is 1st page in our case)
  private static final int OFFSET_START = 0;

  // Indicates if footer ProgressBar is shown (i.e. next page is loading)
  private boolean isLoading = false;

  // If current page is the last page (Pagination will stop after this page load)
  private boolean isLastPage = false;

  // total no. of pages to load. Initial load is page 0, after which 2 more pages will load.
  private int TOTAL_ITEM_COST;

  // indicates the current page which Pagination is fetching.
  private int currentOffset = OFFSET_START;

  private PaginationAdapter adapter;
  private ApiService apiService;
  private ProgressBar progressBar;
  private RecyclerView rv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    rv = findViewById(R.id.rv);
    progressBar = findViewById(R.id.progressBar);

//    final List<GGModel> startingList = GGModel.createList(10 , 0);
//
//    final ListAdapter adapter = new ListAdapter(startingList);
//    rv.setAdapter(adapter);
//    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//    rv.setLayoutManager(linearLayoutManager);
//    EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
//      @Override
//      public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
//        Log.e("e", "onLoadMore page " + page + "tIc " + totalItemsCount);
//
//        List<GGModel> moarList = GGModel.createList(10, page);
//        final int curSize = adapter.getItemCount();
//        startingList.addAll(moarList);
//
//        view.post(new Runnable() {
//          @Override
//          public void run() {
//            adapter.notifyItemRangeInserted(curSize, startingList.size() - 1);
//          }
//        });
//      }
//    };
//    rv.addOnScrollListener(scrollListener);

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
    rv.setLayoutManager(linearLayoutManager);
    rv.setItemAnimator(new DefaultItemAnimator());

    adapter = new PaginationAdapter(this);
    rv.setAdapter(adapter);

    rv.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
      @Override
      protected void loadMoreItems() {
        Log.e("e", "loadMoreItems");
        isLoading = true;

        //Increment page index to load the next one.
//        currentOffset = adapter.getItemCount();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
          @Override
          public void run() {
            //Do something after 100ms
            loadNextPage();
          }
        }, 10000);
      }

      @Override
      public int getTotalPageCount() {
        return TOTAL_ITEM_COST;
      }

      @Override
      public boolean isLastPage() {
        return isLastPage;
      }

      @Override
      public boolean isLoading() {
        return isLoading;
      }
    });

    apiService = CostApi.getClient().create(ApiService.class);
    loadFirstPage();
  }

  /**
   * Performs a Retrofit call to the last mile cost API.
   */
  private Call<ResponseModel> callLastMileApi() {
    RequestModel body = new RequestModel();
    body.setApiKey("LazdYpjnJTXxtsp");

    RequestDataModel bodyData = new RequestDataModel();
    bodyData.setDriverId("88");
    bodyData.setLimit(50);
    bodyData.setOffset(currentOffset);

    body.setData(bodyData);

    return apiService.getLastMile(body);
  }

  /**
   * Extracts List<Cost> from response
   */
  private List<Cost> fetchResults(Response<ResponseModel> response) { //3
    ResponseModel responseModel = response.body();
    return responseModel.getReturn().getCosts();
  }

  private void loadFirstPage() {
    Log.e("e", "loadFirstPage");
    callLastMileApi().enqueue(new Callback<ResponseModel>() {
      @Override
      public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
        Log.e("e", "onResponse loaded " + response.body().getReturn().getCosts().size());

        TOTAL_ITEM_COST = response.body().getReturn().getTotalCost();

        List<Cost> costList = fetchResults(response);
        progressBar.setVisibility(View.GONE);
        adapter.addAll(costList);

        //Increment page index to load the next one.
        currentOffset = currentOffset + adapter.getItemCount();
        Log.e("e","currentOffset " + currentOffset);

        if (adapter.getItemCount() >= TOTAL_ITEM_COST) {
          isLastPage = true;
        } else {
          adapter.addLoadingFooter();
        }

      }

      @Override
      public void onFailure(Call<ResponseModel> call, Throwable t) {
        Log.e("e", "onFailure");
        t.printStackTrace();
        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
      }
    });
  }

  private void loadNextPage() {
    Log.e("e", "loadNextPage");
    callLastMileApi().enqueue(new Callback<ResponseModel>() {
      @Override
      public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
        Log.e("e", "onResponse");
        adapter.removeLoadingFooter();
        isLoading = false;

        List<Cost> newList = fetchResults(response);
        adapter.addAll(newList);

        //Increment page index to load the next one.
        currentOffset = currentOffset + newList.size();
        Log.e("e", "currentOffset " + currentOffset + " total " + TOTAL_ITEM_COST);

        if (currentOffset >= TOTAL_ITEM_COST) {
          isLastPage = true;
        } else {
          adapter.addLoadingFooter();
        }
      }

      @Override
      public void onFailure(Call<ResponseModel> call, Throwable t) {
        Log.e("e", "onFailure");
        t.printStackTrace();
        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
      }
    });
  }

}
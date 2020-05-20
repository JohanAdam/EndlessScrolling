package com.nyan.paginationexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.nyan.paginationexample.R;
import com.nyan.paginationexample.model.response.Cost;
import java.util.ArrayList;
import java.util.List;

public class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private static final int ITEM = 0;
  private static final int LOADING = 1;

  private List<Cost> mList;
  private Context context;

  private boolean isLoadingAdded = false;

  public PaginationAdapter(Context context) {
    this.context = context;
    mList = new ArrayList<>();
  }

  public List<Cost> getCosts() {
    return mList;
  }

  public void setCosts(List<Cost> costs) {
    this.mList = costs;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder viewHolder = null;
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());

    switch (viewType) {
      case ITEM:
        viewHolder = getViewHolder(parent, inflater);
        break;
      case LOADING:
        View v2 = inflater.inflate(R.layout.list_item_progress, parent, false);
        viewHolder = new LoadingVH(v2);
        break;
    }
    return viewHolder;
  }

  @NonNull
  private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
    RecyclerView.ViewHolder viewHolder;
    View v1 = inflater.inflate(R.layout.item_gg, parent, false);
    viewHolder = new CostVH(v1);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    Cost cost = mList.get(position);

    switch (getItemViewType(position)) {
      case ITEM:
        CostVH viewHolder = (CostVH) holder;
        viewHolder.tvTitle.setText(cost.getPackageTrackingNumber());
        viewHolder.tvPosition.setText(String.valueOf(position + 1));
        break;
      case LOADING:
//                Do nothing
        break;
    }

  }

  @Override
  public int getItemCount() {
    return mList == null ? 0 : mList.size();
  }

  @Override
  public int getItemViewType(int position) {
    return (position == mList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
  }

    /*
   Helpers
   _________________________________________________________________________________________________
    */

  public void add(Cost cost) {
    mList.add(cost);
    notifyItemInserted(mList.size() - 1);
  }

  public void addAll(List<Cost> mcList) {
    for (Cost cost : mcList) {
      add(cost);
    }
  }

  public void remove(Cost cost) {
    int position = mList.indexOf(cost);
    if (position > -1) {
      mList.remove(position);
      notifyItemRemoved(position);
    }
  }

  public void clear() {
    isLoadingAdded = false;
    while (getItemCount() > 0) {
      remove(getItem(0));
    }
  }

  public boolean isEmpty() {
    return getItemCount() == 0;
  }


  public void addLoadingFooter() {
    isLoadingAdded = true;
    add(new Cost());
  }

  public void removeLoadingFooter() {
    isLoadingAdded = false;

    int position = mList.size() - 1;
    Cost item = getItem(position);

    if (item != null) {
      mList.remove(position);
      notifyItemRemoved(position);
    }
  }

  public Cost getItem(int position) {
    return mList.get(position);
  }


   /*
   View Holders
   _________________________________________________________________________________________________
    */

  /**
   * Main list's content ViewHolder
   */
  protected class CostVH extends RecyclerView.ViewHolder {
    private TextView tvTitle, tvPosition;

    CostVH(View itemView) {
      super(itemView);
      tvTitle = itemView.findViewById(R.id.tv_title);
      tvPosition = itemView.findViewById(R.id.tv_position);
    }
  }


  protected class LoadingVH extends RecyclerView.ViewHolder {
    LoadingVH(View itemView) {
      super(itemView);
    }
  }


}
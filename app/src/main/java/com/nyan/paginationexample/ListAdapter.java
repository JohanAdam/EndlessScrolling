package com.nyan.paginationexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

  private List<GGModel> mList;

  public ListAdapter(List<GGModel> list) {
    this.mList = list;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);

    View contactView = inflater.inflate(R.layout.item_gg, parent, false);

    ViewHolder viewHolder = new ViewHolder(contactView);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    GGModel item = mList.get(position);
    holder.tvTitle.setText(item.getTitle());
  }

  @Override
  public int getItemCount() {
    return mList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      tvTitle = itemView.findViewById(R.id.tv_title);
    }
  }
}

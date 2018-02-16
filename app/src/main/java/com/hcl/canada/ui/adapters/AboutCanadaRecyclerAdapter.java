package com.hcl.canada.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hcl.canada.ui.models.AboutItem;
import com.hcl.canada.ui.viewholders.AboutCanadaRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class AboutCanadaRecyclerAdapter extends RecyclerView.Adapter<AboutCanadaRecyclerViewHolder> {

    private List<AboutItem> aboutItems = new ArrayList<>();

    @Override
    public AboutCanadaRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return AboutCanadaRecyclerViewHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(AboutCanadaRecyclerViewHolder holder, int position) {
        holder.updateView(aboutItems.get(position));
    }

    @Override
    public int getItemCount() {
        return aboutItems.size();
    }

    public void setContent(List<AboutItem> items) {
        aboutItems.clear();
        aboutItems.addAll(items);
        notifyDataSetChanged();
    }
}

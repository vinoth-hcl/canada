package com.hcl.canada.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hcl.canada.ui.viewholders.AboutCanadaRecyclerViewHolder;

public class AboutCanadaRecyclerAdapter extends RecyclerView.Adapter<AboutCanadaRecyclerViewHolder> {

    @Override
    public AboutCanadaRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return AboutCanadaRecyclerViewHolder.newInstance(parent);
    }

    @Override
    public void onBindViewHolder(AboutCanadaRecyclerViewHolder holder, int position) {
        holder.updateView();
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

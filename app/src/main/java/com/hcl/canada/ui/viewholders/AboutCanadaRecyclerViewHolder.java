package com.hcl.canada.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hcl.canada.R;

import butterknife.ButterKnife;

public class AboutCanadaRecyclerViewHolder extends RecyclerView.ViewHolder {

    public AboutCanadaRecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static AboutCanadaRecyclerViewHolder newInstance(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.about_view_item, parent, false);

        AboutCanadaRecyclerViewHolder aboutCanadaRecyclerViewHolder = new AboutCanadaRecyclerViewHolder(view);
        return aboutCanadaRecyclerViewHolder;
    }

    public void updateView() {
        //TODO: Will be implemented once network calls done.
    }
}

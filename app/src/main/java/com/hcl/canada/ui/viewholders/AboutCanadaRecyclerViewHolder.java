package com.hcl.canada.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hcl.canada.R;
import com.hcl.canada.ui.models.AboutItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutCanadaRecyclerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.about_item_title)
    TextView titleView;

    @BindView(R.id.about_item_description)
    TextView descriptionView;

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

    public void updateView(AboutItem aboutItem) {
        titleView.setText(aboutItem.getTitle());
        descriptionView.setText(aboutItem.getDescription());
    }
}

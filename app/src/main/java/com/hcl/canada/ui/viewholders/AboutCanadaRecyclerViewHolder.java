package com.hcl.canada.ui.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hcl.canada.R;
import com.hcl.canada.ui.models.AboutItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutCanadaRecyclerViewHolder extends RecyclerView.ViewHolder {

    private Context context;

    @BindView(R.id.about_item_title)
    TextView titleView;

    @BindView(R.id.about_item_description)
    TextView descriptionView;

    @BindView(R.id.about_item_image)
    ImageView aboutImageView;

    public AboutCanadaRecyclerViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

    public static AboutCanadaRecyclerViewHolder newInstance(ViewGroup parent, Context context) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.about_view_item, parent, false);

        AboutCanadaRecyclerViewHolder aboutCanadaRecyclerViewHolder = new AboutCanadaRecyclerViewHolder(view, context);
        return aboutCanadaRecyclerViewHolder;
    }

    public void updateView(AboutItem aboutItem) {
        titleView.setText(aboutItem.getTitle());
        descriptionView.setText(aboutItem.getDescription());

        /* Default image placeholder if error occurs */
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_cityscape);
        requestOptions.error(R.drawable.ic_cityscape);

        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(aboutItem.getImageUrl())
                .into(aboutImageView);
    }
}

package com.hcl.canada.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hcl.canada.R;
import com.hcl.canada.ui.adapters.AboutCanadaRecyclerAdapter;
import com.hcl.canada.ui.contracts.AboutCanadaContract;
import com.hcl.canada.ui.presenters.AboutCanadaPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutCanadaListActivity extends AppCompatActivity implements AboutCanadaContract.View {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.about_recycler_view)
    RecyclerView recyclerView;

    private AboutCanadaRecyclerAdapter aboutCanadaRecyclerAdapter;
    private AboutCanadaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_canada);
        ButterKnife.bind(this);

        presenter = new AboutCanadaPresenter();

        aboutCanadaRecyclerAdapter = new AboutCanadaRecyclerAdapter();
        recyclerView.setAdapter(aboutCanadaRecyclerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO: Will be added once network call implementation done.
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onViewActive(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onViewInactive();
    }
}

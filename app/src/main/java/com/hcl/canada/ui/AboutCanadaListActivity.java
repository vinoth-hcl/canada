package com.hcl.canada.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.hcl.canada.R;
import com.hcl.canada.ui.adapters.AboutCanadaRecyclerAdapter;
import com.hcl.canada.ui.contracts.AboutCanadaContract;
import com.hcl.canada.ui.models.AboutItem;
import com.hcl.canada.ui.presenters.AboutCanadaPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutCanadaListActivity extends AppCompatActivity implements AboutCanadaContract.View {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.about_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.about_list_toolbar)
    Toolbar toolbar;

    private AboutCanadaRecyclerAdapter aboutCanadaRecyclerAdapter;
    private AboutCanadaContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_canada);
        ButterKnife.bind(this);

        presenter = new AboutCanadaPresenter(this);

        aboutCanadaRecyclerAdapter = new AboutCanadaRecyclerAdapter();
        recyclerView.setAdapter(aboutCanadaRecyclerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getContents();
            }
        });

        getContents();
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

    @Override
    public void updateToolbarTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void updateListView(List<AboutItem> items) {
        aboutCanadaRecyclerAdapter.setContent(items);
    }

    @Override
    public void setProgressBar(boolean isVisible) {
        swipeRefreshLayout.setRefreshing(false);
    }

    private void getContents() {
        presenter.getContent();
    }

}

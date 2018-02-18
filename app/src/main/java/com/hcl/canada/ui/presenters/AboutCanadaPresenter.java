package com.hcl.canada.ui.presenters;

import android.util.Log;

import com.hcl.canada.ui.AboutCanadaListActivity;
import com.hcl.canada.ui.api.APIClient;
import com.hcl.canada.ui.api.APIService;
import com.hcl.canada.ui.contracts.AboutCanadaContract;
import com.hcl.canada.ui.models.AboutResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutCanadaPresenter extends BasePresenter<AboutCanadaContract.View> implements AboutCanadaContract.Presenter {

    private static final String TAG = AboutCanadaListActivity.class.getName();

    public AboutCanadaPresenter(AboutCanadaContract.View view) {
        this.view = view;
    }

    @Override
    public void getContent(boolean isRefresh) {
        if (!isRefresh)
            view.showProgressBar();

        APIService apiService = APIClient.getClient().create(APIService.class);
        Call<AboutResponse> apiCall = apiService.getAboutContent();
        apiCall.enqueue(new Callback<AboutResponse>() {
            @Override
            public void onResponse(Call<AboutResponse> call, Response<AboutResponse> response) {
                view.updateToolbarTitle(response.body().getTitle());
                view.updateListView(response.body().getAboutItems());

                view.setSwipeTopProgressBar(false);

                view.hideProgressBar();

                view.hideNoContentInfo();
            }

            @Override
            public void onFailure(Call<AboutResponse> call, Throwable t) {
                view.hideProgressBar();
                view.showNoContentInfo();

                view.setSwipeTopProgressBar(false);
                Log.e(TAG, t.toString());
            }
        });
    }
}

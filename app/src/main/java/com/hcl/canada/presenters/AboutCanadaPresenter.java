package com.hcl.canada.presenters;

import android.util.Log;

import com.hcl.canada.api.APIClient;
import com.hcl.canada.api.APIService;
import com.hcl.canada.contracts.AboutCanadaContract;
import com.hcl.canada.models.AboutResponse;
import com.hcl.canada.ui.AboutCanadaListActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutCanadaPresenter extends BasePresenter<AboutCanadaContract.View> implements AboutCanadaContract.Presenter {

    private static final String TAG = AboutCanadaListActivity.class.getName();
    private AboutCanadaContract.View view;

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
                if (response.isSuccessful() && response.body() != null && (response.body().getAboutItems().size() > 0)) {
                    updateViewOnSuccess(response);
                } else {
                    updateViewOnFailure();
                }
            }

            @Override
            public void onFailure(Call<AboutResponse> call, Throwable t) {
                updateViewOnFailure();
                Log.e(TAG, t.toString());
            }
        });
    }

    private void updateViewOnFailure() {
        view.hideProgressBar();
        view.showNoContentInfo();
        view.setSwipeTopProgressBar(false);
    }

    private void updateViewOnSuccess(Response<AboutResponse> response) {
        view.updateToolbarTitle(response.body().getTitle());
        view.updateListView(response.body().getAboutItems());

        view.setSwipeTopProgressBar(false);
        view.hideProgressBar();
        view.hideNoContentInfo();
    }
}

package com.hcl.canada.ui.contracts;

import com.hcl.canada.ui.models.AboutItem;
import com.hcl.canada.ui.presenters.ViewStatePresenter;

import java.util.List;

public class AboutCanadaContract {

    public interface Presenter extends ViewStatePresenter<View> {
        void getContent();
    }

    public interface View {
        void updateToolbarTitle(String title);

        void updateListView(List<AboutItem> items);

        void setProgressBar(boolean isVisible);

        void showNoContentInfo();

        void hideNoContentInfo();
    }

}

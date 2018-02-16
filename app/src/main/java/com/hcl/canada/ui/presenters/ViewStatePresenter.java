package com.hcl.canada.ui.presenters;

import android.support.annotation.NonNull;

public interface ViewStatePresenter<VIEW_TYPE> {

    void onViewActive(@NonNull VIEW_TYPE view);

    void onViewInactive();
}

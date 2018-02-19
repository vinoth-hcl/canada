package com.hcl.canada.presenters;

import android.support.annotation.NonNull;

public interface ViewStatePresenter<VIEW_TYPE> {

    void onViewActive(@NonNull VIEW_TYPE view);

    void onViewInactive();
}

package com.hcl.canada.presenters;

import android.support.annotation.NonNull;

/**
 * Base class to be extended by any MVP Presenter in the application.
 *
 * @param <VIEW_TYPE> a generic type to indicate a type of View
 */
public class BasePresenter<VIEW_TYPE> implements ViewStatePresenter<VIEW_TYPE> {

    protected VIEW_TYPE view;

    @Override
    public void onViewActive(@NonNull VIEW_TYPE view) {
        this.view = view;
    }

    @Override
    public void onViewInactive() {
        view = null;
    }
}

package com.flags.alex.flags.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.flags.alex.flags.FlagsApplication;
import com.flags.alex.flags.presenters.BasePresenter;
import com.flags.alex.flags.ui.views.ActivityView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;

import javax.inject.Inject;

/**
 * Created by Alex on 18/02/2017.
 */

public abstract class BaseActivity extends RxFragmentActivity implements ActivityView {

    @Inject
    protected ImageLoader imageLoader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectAppComponent();
        createPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearDestroySubscriptions();
        unbindPresenter();
        imageLoader.destroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        clearPauseSubscriptions();
    }

    protected void injectAppComponent() {
        ((FlagsApplication) getApplication()).getAppComponent().inject(this);
    }

    protected abstract BasePresenter createPresenter();

    protected abstract void clearPauseSubscriptions();

    protected abstract void clearDestroySubscriptions();

    protected abstract void unbindPresenter();

    protected abstract void navigateToScreen(String screen, Bundle bundle);

    public void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            return;
        }
    }
}

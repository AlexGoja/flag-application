package com.flags.alex.flags.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.flags.alex.flags.FlagsApplication;
import com.flags.alex.flags.api.FlagsApi;
import com.flags.alex.flags.presenters.BasePresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Alex on 18/02/2017.
 */

public abstract class BaseFragment extends Fragment {
    @Inject
    FlagsApi mFlagApi;

    protected CompositeSubscription uiPauseSubscriptions = new CompositeSubscription();
    protected CompositeSubscription uiDestroySubscription = new CompositeSubscription();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();
        injectAppComponent();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }

    private void injectAppComponent() {
        ((FlagsApplication) getActivity().getApplication()).getAppComponent().inject(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        clearPauseSubscriptions();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        clearDestroySubscriptions();
    }

    public abstract void clearPauseSubscriptions();

    public abstract void clearDestroySubscriptions();

    public abstract void unbindPresenter();

    public abstract BasePresenter createPresenter();

}

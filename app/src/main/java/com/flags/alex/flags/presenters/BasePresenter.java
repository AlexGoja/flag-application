package com.flags.alex.flags.presenters;

import android.util.Log;

import com.flags.alex.flags.api.FlagsApi;
import com.flags.alex.flags.components.FlagComponent;
import com.nostra13.universalimageloader.core.ImageLoader;

import javax.inject.Inject;

import lombok.Getter;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Alex on 16/02/2017.
 */

public abstract class BasePresenter {

    @Inject
    FlagsApi mFlagsApi;

    @Getter
    @Inject
    ImageLoader imageLoader;

    private static final String TAG = "BasePresenter";

    protected CompositeSubscription mPauseSubscriptions = new CompositeSubscription();
    protected CompositeSubscription mDestroySubscriptions = new CompositeSubscription();

    public void addPauseSubscription(Subscription subscription) {
        mPauseSubscriptions.add(subscription);
        Log.i(TAG, "Add pause subscription");
    }

    public void addDestroySubscription(Subscription subscription) {
        mDestroySubscriptions.add(subscription);
        Log.i(TAG, "Add destroy subscription");
    }

    public void clearPauseSubscriptions() {
        mPauseSubscriptions.clear();
        Log.i(TAG, "clearPauseSubscriptions");
    }

    public void clearDestroySubscriptions() {
        mDestroySubscriptions.clear();
        Log.i(TAG, "clearDestroySubscriptions");
    }

    public void injectComponent(FlagComponent component) {
        component.inject(this);
    }

    public abstract void unbindView();

}

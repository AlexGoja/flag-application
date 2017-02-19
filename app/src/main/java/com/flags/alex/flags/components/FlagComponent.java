package com.flags.alex.flags.components;

import com.flags.alex.flags.FlagsApplication;
import com.flags.alex.flags.modules.AppModule;
import com.flags.alex.flags.modules.FlagsApiModule;
import com.flags.alex.flags.modules.NetworkModule;
import com.flags.alex.flags.presenters.BasePresenter;
import com.flags.alex.flags.ui.activity.BaseActivity;
import com.flags.alex.flags.ui.fragment.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alex on 18/02/2017.
 */

@Singleton
@Component(modules = {FlagsApiModule.class, AppModule.class, NetworkModule.class})
public interface FlagComponent {
    void inject(FlagsApplication application);

    void inject(BaseActivity activity);

    void inject(BasePresenter basePresenter);

    void inject(BaseFragment baseFragment);
}

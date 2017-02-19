package com.flags.alex.flags;

import android.app.Application;

import com.flags.alex.flags.components.DaggerFlagComponent;
import com.flags.alex.flags.components.FlagComponent;
import com.flags.alex.flags.modules.AppModule;

/**
 * Created by Alex on 16/02/2017.
 */

public class FlagsApplication extends Application {

    private FlagComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        injectComponent();
    }

    private void injectComponent() {
        appComponent = DaggerFlagComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public FlagComponent getAppComponent() {
        return appComponent;
    }
}

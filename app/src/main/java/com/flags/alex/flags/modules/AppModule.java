package com.flags.alex.flags.modules;

import android.content.Context;

import com.flags.alex.flags.FlagsApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex on 18/02/2017.
 */

@Module
public class AppModule {

    final FlagsApplication application;

    public AppModule(FlagsApplication application) {
        this.application = application;
    }

    @Provides
    Context providesContext() {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    FlagsApplication providesApplication() {
        return application;
    }

}

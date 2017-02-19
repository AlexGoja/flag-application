package com.flags.alex.flags.modules;

import com.flags.alex.flags.api.FlagsApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Alex on 18/02/2017.
 */

@Module
public class FlagsApiModule {

    @Singleton
    @Provides
    FlagsApi provideRetorfit(Retrofit retrofit) {
        FlagsApi api = retrofit.create(FlagsApi.class);
        return api;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }
}

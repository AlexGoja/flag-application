package com.flags.alex.flags.presenters;

import android.util.Log;

import com.flags.alex.flags.entities.Country;
import com.flags.alex.flags.ui.views.ICountriesView;

import java.util.List;

import lombok.Getter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Alex on 18/02/2017.
 */

public class FlagFragmentListPresenter extends BasePresenter {

    private ICountriesView view;

    @Getter
    private List<Country> countryList;

    public FlagFragmentListPresenter(ICountriesView view) {
        this.view = view;
    }

    public void getAllCountries() {
        addDestroySubscription(mFlagsApi.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Country>>() {
                    @Override
                    public void call(List<Country> countries) {
                        countryList = countries;
                        view.showCountries(countries);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e("error", "call: " + throwable.getMessage() );
                    }
                }));
    }

    @Override
    public void unbindView() {
        view = null;
    }
}

package com.flags.alex.flags.api;

import com.flags.alex.flags.entities.Country;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Alex on 18/02/2017.
 */

public interface FlagsApi {
    @GET("rest/v1/all")
    Observable<List<Country>> getCountries();
}

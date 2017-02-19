package com.flags.alex.flags.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;

/**
 * Created by Alex on 18/02/2017.
 */

public class Country extends BaseObject {
    @Getter
    @SerializedName("name")
    @Expose
    private String name;

    @Getter
    @SerializedName("topLevelDomain")
    @Expose
    private List<String> topLevelDomain = null;

    @Getter
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;

    @Getter
    @SerializedName("alpha3Code")
    @Expose
    private String alpha3Code;

    @Getter
    @SerializedName("callingCodes")
    @Expose
    private List<String> callingCodes = null;

    @Getter
    @SerializedName("capital")
    @Expose
    private String capital;

    @Getter
    @SerializedName("altSpellings")
    @Expose
    private List<String> altSpellings = null;

    @Getter
    @SerializedName("relevance")
    @Expose
    private String relevance;

    @Getter
    @SerializedName("subregion")
    @Expose
    private String subregion;

    @Getter
    @SerializedName("translations")
    @Expose
    private Translations translations;

    @Getter
    @SerializedName("population")
    @Expose
    private String population;

    @Getter
    @SerializedName("latlng")
    @Expose
    private List<Double> latlng = null;

    @Getter
    @SerializedName("demonym")
    @Expose
    private String demonym;

    @Getter
    @SerializedName("area")
    @Expose
    private String area;

    @Getter
    @SerializedName("gini")
    @Expose
    private String gini;

    @Getter
    @SerializedName("timezones")
    @Expose
    private List<String> timezones = null;

    @Getter
    @SerializedName("borders")
    @Expose
    private List<String> borders = null;

    @Getter
    @SerializedName("nativeName")
    @Expose
    private String nativeName;

    @Getter
    @SerializedName("numericCode")
    @Expose
    private String numericCode;

    @Getter
    @SerializedName("currencies")
    @Expose
    private List<String> currencies = null;

    @Getter
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
}



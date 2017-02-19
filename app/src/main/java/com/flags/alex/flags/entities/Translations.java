package com.flags.alex.flags.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;

/**
 * Created by Alex on 18/02/2017.
 */

public class Translations extends BaseObject {
    @Getter
    @SerializedName("de")
    @Expose
    private String de;

    @Getter
    @SerializedName("es")
    @Expose
    private String es;

    @Getter
    @SerializedName("fr")
    @Expose
    private String fr;

    @Getter
    @SerializedName("ja")
    @Expose
    private String ja;

    @Getter
    @SerializedName("it")
    @Expose
    private String it;
}

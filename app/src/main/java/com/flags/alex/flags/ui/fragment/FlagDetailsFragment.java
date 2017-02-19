package com.flags.alex.flags.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flags.alex.flags.FlagsApplication;
import com.flags.alex.flags.R;
import com.flags.alex.flags.entities.Country;
import com.flags.alex.flags.presenters.BasePresenter;
import com.flags.alex.flags.presenters.FlagDetailsFragmentPresenter;
import com.flags.alex.flags.utils.BundleKeys;

import butterknife.BindView;

/**
 * Created by Alex on 18/02/2017.
 */

public class FlagDetailsFragment extends BaseFragment {

    @BindView(R.id.capital)
    TextView capital;

    @BindView(R.id.population)
    TextView population;

    Country country = null;

    private FlagDetailsFragmentPresenter mPresenter;

    public FlagDetailsFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        country = (Country) getArguments().getSerializable(BundleKeys.FLAG_DETAILS);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flag_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupView();
    }

    @Override
    public void clearPauseSubscriptions() {

    }

    @Override
    public void clearDestroySubscriptions() {

    }

    @Override
    public void unbindPresenter() {
        mPresenter = null;
    }

    @Override
    public BasePresenter createPresenter() {
        mPresenter = new FlagDetailsFragmentPresenter();
        mPresenter.injectComponent(((FlagsApplication) getActivity().getApplication()).getAppComponent());
        return mPresenter;
    }

    public void setupView() {
        capital.setText(getResources().getString(R.string.capital, country.getCapital()));
        population.setText(getResources().getString(R.string.population, country.getPopulation()));
    }
}

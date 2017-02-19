package com.flags.alex.flags.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flags.alex.flags.FlagsApplication;
import com.flags.alex.flags.R;
import com.flags.alex.flags.presenters.BasePresenter;
import com.flags.alex.flags.presenters.FlagFragmentListPresenter;
import com.flags.alex.flags.ui.adapters.FlagListAdapter;
import com.flags.alex.flags.ui.views.ICountriesView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Alex on 18/02/2017.
 */

public class FlagListFragment extends BaseFragment implements ICountriesView {

    @BindView(R.id.country_list)
    RecyclerView mRecyclerList;

    FlagFragmentListPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getAllCountries();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flag_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerList.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mRecyclerList.setAdapter(new FlagListAdapter(mPresenter, getActivity()));
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void clearPauseSubscriptions() {
        mPresenter.clearPauseSubscriptions();
    }

    @Override
    public void clearDestroySubscriptions() {
        mPresenter.clearDestroySubscriptions();
    }

    @Override
    public void unbindPresenter() {
        mPresenter = null;
    }

    @Override
    public BasePresenter createPresenter() {
        mPresenter = new FlagFragmentListPresenter(this);
        mPresenter.injectComponent(((FlagsApplication) getActivity().getApplication()).getAppComponent());
        return mPresenter;
    }

    @Override
    public void showCountries(List countries) {
        FlagListAdapter adapter = (FlagListAdapter) mRecyclerList.getAdapter();
        adapter.setElements(countries);
        adapter.notifyDataSetChanged();
    }
}

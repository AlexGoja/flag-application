package com.flags.alex.flags.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.flags.alex.flags.FlagsApplication;
import com.flags.alex.flags.R;
import com.flags.alex.flags.presenters.BasePresenter;
import com.flags.alex.flags.presenters.FlagActivityPresenter;
import com.flags.alex.flags.ui.fragment.BaseFragment;
import com.flags.alex.flags.ui.fragment.FlagDetailsFragment;
import com.flags.alex.flags.ui.fragment.FlagListFragment;
import com.flags.alex.flags.utils.Screens;

public class FlagActivity extends BaseActivity {

    FlagActivityPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);
        addFragment(savedInstanceState);
        navigateToScreen(Screens.FLAG_LIST, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected BasePresenter createPresenter() {
        mPresenter = new FlagActivityPresenter();
        mPresenter.injectComponent(((FlagsApplication) getApplication()).getAppComponent());
        return mPresenter;
    }

    @Override
    protected void clearPauseSubscriptions() {
        mPresenter.clearPauseSubscriptions();
    }

    @Override
    protected void clearDestroySubscriptions() {
        mPresenter.clearDestroySubscriptions();
    }

    @Override
    protected void unbindPresenter() {
        mPresenter = null;
    }

    @Override
    public void navigateToScreen(String screen, Bundle bundle) {
        BaseFragment fragment = null;
        switch (screen) {
            case Screens.FLAG_LIST:
                fragment = new FlagListFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, fragment, screen)
                        .commit();
                break;
            case Screens.FLAG_DETAIL:
                fragment = new FlagDetailsFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment, screen)
                        .addToBackStack(null).commit();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);
        if (currentFragment != null)
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new FlagListFragment(), Screens.FLAG_LIST).commit();
    }
}

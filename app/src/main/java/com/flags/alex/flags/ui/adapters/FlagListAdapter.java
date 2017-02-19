package com.flags.alex.flags.ui.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flags.alex.flags.R;
import com.flags.alex.flags.entities.Country;
import com.flags.alex.flags.presenters.BasePresenter;
import com.flags.alex.flags.ui.activity.FlagActivity;
import com.flags.alex.flags.utils.BundleKeys;
import com.flags.alex.flags.utils.Screens;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alex on 18/02/2017.
 */

public class FlagListAdapter<E> extends RecyclerView.Adapter<FlagListAdapter.ViewHolder> {

    private List<E> elements;

    private BasePresenter presenter;

    private Context context;
    private int darkGrey;
    private int lightGrey;
    private int white;

    public FlagListAdapter(BasePresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.flag_image)
        ImageView mFlagImage;
        @BindView(R.id.country_txt)
        TextView mCountryTxv;
        @BindView(R.id.flag_view)
        LinearLayout mFlagLayout;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public FlagListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        darkGrey = ContextCompat.getColor(context, R.color.dark_grey);
        lightGrey = ContextCompat.getColor(context, R.color.light_grey);
        white = ContextCompat.getColor(context, R.color.white);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_flag_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FlagListAdapter.ViewHolder holder, int position) {
        final Country country = (Country) elements.get(position);
        holder.mCountryTxv.setText(country.getName());
        holder.mCountryTxv.setTextColor(white);
        setImage(holder.mFlagImage, country.getAlpha2Code());
        holder.mFlagLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(BundleKeys.FLAG_DETAILS, country);
                ((FlagActivity) context).navigateToScreen(Screens.FLAG_DETAIL, bundle);
            }
        });
        if (position % 2 == 0) {
            holder.mFlagLayout.setBackgroundColor(darkGrey);
        } else {
            holder.mFlagLayout.setBackgroundColor(lightGrey);
        }
    }

    @Override
    public int getItemCount() {
        return elements == null ? 0: elements.size();
    }

    public void setElements(List<E> elements) {
        this.elements = elements;
    }

    public void setImage(ImageView mFlagImage, String country){
        presenter.getImageLoader().displayImage("http://www.geonames.org/flags/x/" + country.toLowerCase() +".gif", mFlagImage);
    }

}

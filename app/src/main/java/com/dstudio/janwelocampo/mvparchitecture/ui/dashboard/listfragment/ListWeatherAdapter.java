package com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.listfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dstudio.janwelocampo.mvparchitecture.R;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.City;

import java.lang.reflect.Array;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Janwel Ocampo on 20/01/2018.
 */

public class ListWeatherAdapter extends ArrayAdapter<City> {
    private List<City> cityList;

    public ListWeatherAdapter(@NonNull Context context, int resource, @NonNull List<City> cityList) {
        super(context, resource, cityList);
        this.cityList = cityList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup viewGroup) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            LayoutInflater layoutInflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_weather, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.textLocation.setText(cityList.get(position).getName());
        holder.textWeather.setText(cityList.get(position).getWeather().get(0).getDescription());
        holder.textTemp.setText(String.valueOf(cityList.get(position).getMain().getTemp()));

        return view;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    static class ViewHolder {
        @BindView(R.id.text_location)
        TextView textLocation;

        @BindView(R.id.text_weather)
        TextView textWeather;

        @BindView(R.id.text_temp)
        TextView textTemp;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}



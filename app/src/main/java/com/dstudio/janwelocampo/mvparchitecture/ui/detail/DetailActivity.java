package com.dstudio.janwelocampo.mvparchitecture.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dstudio.janwelocampo.mvparchitecture.MvpApp;
import com.dstudio.janwelocampo.mvparchitecture.R;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.City;
import com.dstudio.janwelocampo.mvparchitecture.utils.AppConstants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailActivityView {
    private static String CITY_ID = "cityId";

    @Inject
    DetailActivityPresenter detailActivityPresenter;

    @BindView(R.id.text_city)
    TextView textCity;

    @BindView(R.id.image_weather)
    ImageView imageWeather;

    @BindView(R.id.text_weather_desc)
    TextView textWeatherDesc;

    @BindView(R.id.text_wind)
    TextView textWind;

    @BindView(R.id.text_humidity)
    TextView textHumidity;

    @BindView(R.id.text_max_temp)
    TextView textMaxTemp;

    @BindView(R.id.text_min_temp)
    TextView textMinTemp;

    @BindView(R.id.text_sunrise)
    TextView textSunrise;

    @BindView(R.id.text_sunset)
    TextView textSunset;

    private int cityId;

    public static void startAsIntent(Context context, int cityId) {
        Bundle extras = new Bundle();

        extras.putInt(CITY_ID, cityId);

        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtras(extras);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ((MvpApp) getApplication()).getAppComponent(this).inject(this);
        ButterKnife.bind(this);

        detailActivityPresenter.onAttachView(this);

        Bundle bundle = getIntent().getExtras();
        cityId = bundle.getInt(CITY_ID);
        detailActivityPresenter.getWeatherDataDetails(cityId);
    }

    @Override
    public void weatherDataDetails(City city) {
        if(city != null){

            textCity.setText(city.getName());
            Glide.with(this).load(AppConstants.IMAGE_URL + city.getWeather().get(0).getIcon() + ".png").into(imageWeather);
            textWeatherDesc.setText(city.getWeather().get(0).getDescription());
            textWind.setText(String.valueOf(city.getWind().getDeg()));
            textHumidity.setText(String.valueOf(city.getMain().getHumidity()));
            textMaxTemp.setText(String.valueOf(city.getMain().getTempMax()));
            textMinTemp.setText(String.valueOf(city.getMain().getTempMin()));
            textSunrise.setText(getDate(city.getSys().getSunrise()));
            textSunset.setText(getDate(city.getSys().getSunset()));
        }
    }

    private String getDate(long timeStamp){

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm a");
            Date netDate = (new Date(timeStamp * 1000L));
            sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return sdf.format(netDate);
        }
        catch(Exception ex){
            return "xx";
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void noInternetConnection() {

    }


}

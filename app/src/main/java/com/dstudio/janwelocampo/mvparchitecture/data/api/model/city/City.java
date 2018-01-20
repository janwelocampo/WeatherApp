
package com.dstudio.janwelocampo.mvparchitecture.data.api.model.city;

import com.dstudio.janwelocampo.mvparchitecture.data.database.CustomDao;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = City.TABLE_NAME_CITY)
public class City {
    public static final String TABLE_NAME_CITY = "city";

    public static final String FIELD_NAME_COORD   = "coord";
    public static final String FIELD_NAME_SYS   = "sys";
    public static final String FIELD_NAME_WEATHER   = "weather";
    public static final String FIELD_NAME_MAIN = "main";
    public static final String FIELD_NAME_VISIBILITY = "visibility";
    public static final String FIELD_NAME_WIND = "wind";
    public static final String FIELD_NAME_CLOUDS = "clouds";
    public static final String FIELD_NAME_DT = "dt";
    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_NAME = "name";

    @DatabaseField(columnName = FIELD_NAME_ID, id = true)
    @SerializedName(FIELD_NAME_ID)
    @Expose
    private Integer id;

    @DatabaseField(columnName = FIELD_NAME_NAME)
    @SerializedName(FIELD_NAME_NAME)
    @Expose
    private String name;

    @SerializedName(FIELD_NAME_COORD)
    @Expose
    private Coord coord;

    @SerializedName(FIELD_NAME_SYS)
    @Expose
    private Sys sys;

    @SerializedName(FIELD_NAME_WEATHER)
    @Expose
    private List<Weather> weather = null;

    @SerializedName(FIELD_NAME_MAIN)
    @Expose
    private Main main;

    @DatabaseField(columnName = FIELD_NAME_VISIBILITY)
    @SerializedName(FIELD_NAME_VISIBILITY)
    @Expose
    private int visibility;

    @SerializedName(FIELD_NAME_WIND)
    @Expose
    private Wind wind;

    @SerializedName(FIELD_NAME_CLOUDS)
    @Expose
    private Clouds clouds;

    @DatabaseField(columnName = FIELD_NAME_DT)
    @SerializedName(FIELD_NAME_DT)
    @Expose
    private int dt;


    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

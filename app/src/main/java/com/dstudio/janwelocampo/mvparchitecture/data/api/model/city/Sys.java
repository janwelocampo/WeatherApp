
package com.dstudio.janwelocampo.mvparchitecture.data.api.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Sys.TABLE_NAME_SYS)
public class Sys {

    public static final String TABLE_NAME_SYS = "sys";

    public static final String FIELD_NAME_TYPE   = "type";
    public static final String FIELD_NAME_ID   = "id";
    public static final String FIELD_NAME_MESSAGE  = "message";
    public static final String FIELD_NAME_COUNTRY = "country";
    public static final String FIELD_NAME_SUNRISE= "sunrise";
    public static final String FIELD_NAME_SUNSET = "sunset";
    public static final String FIELD_NAME_CITY_ID = "cityId";

    @DatabaseField(columnName = FIELD_NAME_CITY_ID)
    private int cityId;

    @DatabaseField(columnName = FIELD_NAME_TYPE)
    @SerializedName(FIELD_NAME_TYPE)
    @Expose
    private int type;

    @DatabaseField(columnName = FIELD_NAME_ID, id = true)
    @SerializedName(FIELD_NAME_ID)
    @Expose
    private int id;

    @DatabaseField(columnName = FIELD_NAME_MESSAGE)
    @SerializedName(FIELD_NAME_MESSAGE)
    @Expose
    private float message;

    @DatabaseField(columnName = FIELD_NAME_COUNTRY)
    @SerializedName(FIELD_NAME_COUNTRY)
    @Expose
    private String country;

    @DatabaseField(columnName = FIELD_NAME_SUNRISE)
    @SerializedName(FIELD_NAME_SUNRISE)
    @Expose
    private int sunrise;

    @DatabaseField(columnName = FIELD_NAME_SUNSET)
    @SerializedName(FIELD_NAME_SUNSET)
    @Expose
    private int sunset;

    public Sys(){

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

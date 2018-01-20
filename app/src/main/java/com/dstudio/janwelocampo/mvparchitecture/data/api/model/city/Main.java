
package com.dstudio.janwelocampo.mvparchitecture.data.api.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Main.TABLE_NAME_MAIN)
public class Main {

    public static final String TABLE_NAME_MAIN = "main";

    public static final String FIELD_NAME_TEMP   = "temp";
    public static final String FIELD_NAME_PRESSURE   = "pressure";
    public static final String FIELD_NAME_HUMIDITY = "humidity";
    public static final String FIELD_NAME_TEMP_MIN = "temp_min";
    public static final String FIELD_NAME_TEMP_MAX= "temp_max";
    public static final String FIELD_NAME_CITY_ID = "cityId";
    public static final String FIELD_NAME_ID   = "id";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_CITY_ID)
    private int cityId;

    @DatabaseField(columnName = FIELD_NAME_TEMP)
    @SerializedName(FIELD_NAME_TEMP)
    @Expose
    private float temp;

    @DatabaseField(columnName = FIELD_NAME_PRESSURE)
    @SerializedName(FIELD_NAME_PRESSURE)
    @Expose
    private int pressure;

    @DatabaseField(columnName = FIELD_NAME_HUMIDITY)
    @SerializedName(FIELD_NAME_HUMIDITY)
    @Expose
    private int humidity;

    @DatabaseField(columnName = FIELD_NAME_TEMP_MIN)
    @SerializedName(FIELD_NAME_TEMP_MIN)
    @Expose
    private float tempMin;

    @DatabaseField(columnName = FIELD_NAME_TEMP_MAX)
    @SerializedName(FIELD_NAME_TEMP_MAX)
    @Expose
    private float tempMax;

    Main(){

    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(Float tempMax) {
        this.tempMax = tempMax;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

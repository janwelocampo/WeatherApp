
package com.dstudio.janwelocampo.mvparchitecture.data.api.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = Wind.TABLE_NAME_WIND)
public class Wind {

    public static final String TABLE_NAME_WIND = "wind";

    public static final String FIELD_NAME_SPEED  = "speed";
    public static final String FIELD_NAME_ID   = "id";
    public static final String FIELD_NAME_DEG = "deg";
    public static final String FIELD_NAME_CITY_ID = "cityId";


    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_CITY_ID)
    private int cityId;

    @DatabaseField(columnName = FIELD_NAME_SPEED)
    @SerializedName(FIELD_NAME_SPEED)
    @Expose
    private float speed;

    @DatabaseField(columnName = FIELD_NAME_DEG)
    @SerializedName(FIELD_NAME_DEG)
    @Expose
    private float deg;

    Wind(){

    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
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

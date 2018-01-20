
package com.dstudio.janwelocampo.mvparchitecture.data.api.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Coord.TABLE_NAME_COORD)
public class Coord {
    public static final String TABLE_NAME_COORD = "coord";

    public static final String FIELD_NAME_ID   = "id";
    public static final String FIELD_NAME_LAT   = "lat";
    public static final String FIELD_NAME_LON = "lon";
    public static final String FIELD_NAME_CITY_ID = "cityId";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = FIELD_NAME_LON)
    @SerializedName(FIELD_NAME_LON)
    @Expose
    private float lon;

    @DatabaseField(columnName = FIELD_NAME_LAT)
    @SerializedName(FIELD_NAME_LAT)
    @Expose
    private float lat;

    @DatabaseField(columnName = FIELD_NAME_CITY_ID)
    private int cityId;

    public Coord(){
    }

    public int getId() {
        return mId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }


}


package com.dstudio.janwelocampo.mvparchitecture.data.api.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Clouds.TABLE_NAME_CLOUDS)
public class Clouds {
    public static final String TABLE_NAME_CLOUDS = "clouds";

    public static final String FIELD_NAME_ALL = "all";
    public static final String FIELD_NAME_CITY_ID = "cityId";
    public static final String FIELD_NAME_ID   = "id";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_CITY_ID)
    private int cityId;

    @DatabaseField(columnName = FIELD_NAME_ALL)
    @SerializedName(FIELD_NAME_ALL)
    @Expose
    private int all;

    Clouds(){

    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
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

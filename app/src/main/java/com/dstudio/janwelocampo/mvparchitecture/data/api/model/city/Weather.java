
package com.dstudio.janwelocampo.mvparchitecture.data.api.model.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Weather.TABLE_NAME_WEATHER)
public class Weather {

    public static final String TABLE_NAME_WEATHER = "weather";

    public static final String FIELD_NAME_ID   = "id";
    public static final String FIELD_NAME_MAIN = "main";
    public static final String FIELD_NAME_DESCRIPTION = "description";
    public static final String FIELD_NAME_ICON= "icon";
    public static final String FIELD_NAME_CITY_ID = "cityId";


    @DatabaseField(columnName = FIELD_NAME_CITY_ID)
    private int cityId;

    @DatabaseField(columnName = FIELD_NAME_ID , id = true)
    @SerializedName(FIELD_NAME_ID)
    @Expose
    private int id;

    @DatabaseField(columnName = FIELD_NAME_MAIN)
    @SerializedName(FIELD_NAME_MAIN)
    @Expose
    private String main;

    @DatabaseField(columnName = FIELD_NAME_DESCRIPTION)
    @SerializedName(FIELD_NAME_DESCRIPTION)
    @Expose
    private String description;

    @DatabaseField(columnName = FIELD_NAME_ICON)
    @SerializedName(FIELD_NAME_ICON)
    @Expose
    private String icon;

    Weather(){}

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

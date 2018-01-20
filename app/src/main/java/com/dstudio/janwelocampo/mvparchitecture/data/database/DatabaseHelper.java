package com.dstudio.janwelocampo.mvparchitecture.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.City;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Clouds;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Coord;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Main;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Sys;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Weather;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Wind;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Janwel Ocampo on 18/01/2018.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    public static final String DATABASE_NAME    = "ormlite.db";
    private static final int    DATABASE_VERSION = 17;

    private Dao<City, Integer> mCityDao = null;
    private Dao<Coord, Integer> mCoordDao = null;
    private Dao<Sys, Integer> mSysDao = null;
    private Dao<Main, Integer> mMainDao = null;
    private Dao<Weather, Integer> mWeatherDao = null;
    private Dao<Wind, Integer> mWindDao = null;
    private Dao<Clouds, Integer> mCloudsDao = null;

    private RuntimeExceptionDao<City, ?> m;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, City.class);
            TableUtils.createTable(connectionSource, Coord.class);
            TableUtils.createTable(connectionSource, Sys.class);
            TableUtils.createTable(connectionSource, Main.class);
            TableUtils.createTable(connectionSource, Weather.class);
            TableUtils.createTable(connectionSource, Wind.class);
            TableUtils.createTable(connectionSource, Clouds.class);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, City.class, true);
            TableUtils.dropTable(connectionSource, Coord.class, true);
            TableUtils.dropTable(connectionSource, Sys.class, true);
            TableUtils.dropTable(connectionSource, Main.class, true);
            TableUtils.dropTable(connectionSource, Weather.class, true);
            TableUtils.dropTable(connectionSource, Wind.class, true);
            TableUtils.dropTable(connectionSource, Clouds.class, true);

            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<City, Integer> getCityDao() throws SQLException {
        if (mCityDao == null) {
            mCityDao = getDao(City.class);
        }
        m = getRuntimeExceptionDao(City.class);
        return mCityDao;
    }

    public Dao<Coord, Integer> getCoordDao() throws SQLException {
        if (mCoordDao == null) {
            mCoordDao = getDao(Coord.class);
        }
        return mCoordDao;
    }

    public Dao<Sys, Integer> getSysDao() throws SQLException {
        if (mSysDao == null) {
            mSysDao = getDao(Sys.class);
        }
        return mSysDao;
    }

    public Dao<Main, Integer> getMainDao() throws SQLException {
        if (mMainDao == null) {
            mMainDao = getDao(Main.class);
        }
        return mMainDao;
    }

    public Dao<Weather, Integer> getWeatherDao() throws SQLException {
        if (mWeatherDao == null) {
            mWeatherDao = getDao(Weather.class);
        }
        return mWeatherDao;
    }

    public Dao<Wind, Integer> getWindDao() throws SQLException {
        if (mWindDao == null) {
            mWindDao = getDao(Wind.class);
        }
        return mWindDao;
    }

    public Dao<Clouds, Integer> getCloudsDao() throws SQLException {
        if (mCloudsDao == null) {
            mCloudsDao = getDao(Clouds.class);
        }
        return mCloudsDao;
    }



    @Override
    public void close() {
        mCoordDao = null;
        mCityDao = null;
        mSysDao = null;
        mMainDao = null;
        mWeatherDao = null;
        mWindDao = null;
        mCloudsDao = null;
        super.close();
    }

    private static DatabaseHelper sDatabaseHelper;


    public static DatabaseHelper getInstance() {
        return sDatabaseHelper;
    }
}
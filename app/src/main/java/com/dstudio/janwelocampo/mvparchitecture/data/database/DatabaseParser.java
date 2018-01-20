package com.dstudio.janwelocampo.mvparchitecture.data.database;

import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.City;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.CityList;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Clouds;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Coord;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Main;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Sys;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Weather;
import com.dstudio.janwelocampo.mvparchitecture.data.api.model.city.Wind;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Janwel Ocampo on 19/01/2018.
 */

public  class DatabaseParser {

    public static void saveWeatherData(DatabaseHelper databaseHelper, CityList cityList) throws SQLException {
        Dao<City, Integer> cityDao = null;
        Dao<Coord, Integer> coordDao = null;
        Dao<Weather, Integer> weatherDao = null;
        Dao<Sys, Integer> sysDao = null;
        Dao<Main, Integer> mainDao = null;
        Dao<Wind, Integer> windDao = null;
        Dao<Clouds, Integer> cloudsDao = null;

            cityDao = databaseHelper.getCityDao();
            coordDao = databaseHelper.getCoordDao();
            weatherDao = databaseHelper.getWeatherDao();
            sysDao = databaseHelper.getSysDao();
            mainDao  = databaseHelper.getMainDao();
            windDao = databaseHelper.getWindDao();
            cloudsDao  = databaseHelper.getCloudsDao();

            for (int i = 0; i < cityList.getCityList().size(); i++){
                City city = cityList.getCityList().get(i);

                City cityDb = cityDao.queryForId(city.getId());
                if (cityDb == null) {
                    //saving ID of City to coord for joining tables later
                    Coord coord = city.getCoord();
                    coord.setCityId(city.getId());
                    //saving ID of City to sys for joining tables later
                    Sys sys = city.getSys();
                    sys.setCityId(city.getId());
                    //saving ID of City to main for joining tables later
                    Main main = city.getMain();
                    main.setCityId(city.getId());
                    //saving ID of City to wind for joining tables later
                    Wind wind = city.getWind();
                    wind.setCityId(city.getId());
                    //saving ID of City to wind for joining tables later
                    Clouds clouds = city.getClouds();
                    clouds.setCityId(city.getId());

                    //saving ID of City to weather for joining tables later
                    List<Weather> weatherList = city.getWeather();
                    for(int ii = 0; ii < weatherList.size(); ii++){
                        Weather weather = weatherList.get(ii);
                        weather.setCityId(city.getId());
                        weatherDao.create(weather);
                    }

                    windDao.create(wind);
                    cloudsDao.create(clouds);
                    mainDao.create(main);
                    sysDao.create(sys);
                    cityDao.create(city);
                    coordDao.create(coord);
                }
                else{
                    cityDb = city;
                    cityDao.update(cityDb);

                    //Coord
                    List<Coord> coordList= coordDao.query(coordDao.queryBuilder().where()
                            .eq(Coord.FIELD_NAME_CITY_ID, cityDb.getId())
                            .prepare());
                    if (coordList.size() > 0){
                        coordDao.delete(coordList);

                        Coord coord = city.getCoord();
                        coord.setCityId(city.getId());

                        coordDao.create(coord);
                    }

                    //Weather
                    List<Weather> weatherList= weatherDao.query(weatherDao.queryBuilder().where()
                            .eq(Weather.FIELD_NAME_CITY_ID, cityDb.getId())
                            .prepare());
                    if (weatherList.size() > 0){
                        weatherDao.delete(weatherList);

                        for(int ii = 0; ii < city.getWeather().size(); ii++){
                            Weather weather = city.getWeather().get(ii);
                            weather.setCityId(city.getId());
                            weatherDao.create(weather);
                        }
                    }

                    //Sys
                    List<Sys> sysList= sysDao.query(sysDao.queryBuilder().where()
                            .eq(Sys.FIELD_NAME_CITY_ID, cityDb.getId())
                            .prepare());
                    if (sysList.size() > 0){
                        sysDao.delete(sysList);

                        Sys sys = city.getSys();
                        sys.setCityId(city.getId());

                        sysDao.create(sys);
                    }

                    //Main
                    List<Main> mainList= mainDao.query(mainDao.queryBuilder().where()
                            .eq(Main.FIELD_NAME_CITY_ID, cityDb.getId())
                            .prepare());
                    if (mainList.size() > 0){
                        mainDao.delete(mainList);

                        Main main = city.getMain();
                        main.setCityId(city.getId());

                        mainDao.create(main);
                    }

                    //Wind
                    List<Wind> windList= windDao.query(windDao.queryBuilder().where()
                            .eq(Wind.FIELD_NAME_CITY_ID, cityDb.getId())
                            .prepare());
                    if (windList.size() > 0){
                        windDao.delete(windList);

                        Wind wind = city.getWind();
                        wind.setCityId(city.getId());

                        windDao.create(wind);
                    }

                    //Clouds
                    List<Clouds> cloudsList= cloudsDao.query(cloudsDao.queryBuilder().where()
                            .eq(Clouds.FIELD_NAME_CITY_ID, cityDb.getId())
                            .prepare());
                    if (cloudsList.size() > 0){
                        cloudsDao.delete(cloudsList);

                        Clouds clouds = city.getClouds();
                        clouds.setCityId(city.getId());

                        cloudsDao.create(clouds);
                    }




                }
            }

           // databaseHelper.close();
    }


    public static List<City> populateWeatherOffline(DatabaseHelper databaseHelper) throws SQLException {

        List<City> cityList = null;

        Dao<City, Integer> cityDao = null;
        Dao<Coord, Integer> coordDao = null;
        Dao<Weather, Integer> weatherDao = null;
        Dao<Sys, Integer> sysDao = null;
        Dao<Main, Integer> mainDao = null;
        Dao<Wind, Integer> windDao = null;
        Dao<Clouds, Integer> cloudsDao = null;

        cityDao = databaseHelper.getCityDao();
        coordDao = databaseHelper.getCoordDao();
        weatherDao = databaseHelper.getWeatherDao();
        sysDao = databaseHelper.getSysDao();
        mainDao  = databaseHelper.getMainDao();
        windDao = databaseHelper.getWindDao();
        cloudsDao  = databaseHelper.getCloudsDao();


        cityList = cityDao.queryForAll();

            //retrieving nested values from different tables
            for(int i = 0; i <cityList.size(); i++ ){
                //Coord
                List<Coord> coordList= coordDao.query(coordDao.queryBuilder().where()
                        .eq(Coord.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                        .prepare());
                if (coordList.size() > 0)
                    cityList.get(i).setCoord(coordList.get(0));
                //Clouds
                List<Clouds> cloudsList= cloudsDao.query(cloudsDao.queryBuilder().where()
                        .eq(Clouds.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                        .prepare());
                if (cloudsList.size() > 0)
                    cityList.get(i).setClouds(cloudsList.get(0));
                //Weather
                List<Weather> weatherList= weatherDao.query(weatherDao.queryBuilder().where()
                        .eq(Weather.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                        .prepare());
                if (weatherList.size() > 0)
                    cityList.get(i).setWeather(weatherList);
                //Sys
                List<Sys> sysList= sysDao.query(sysDao.queryBuilder().where()
                        .eq(Sys.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                        .prepare());
                if (sysList.size() > 0)
                    cityList.get(i).setSys(sysList.get(0));
                //Main
                List<Main> mainList= mainDao.query(mainDao.queryBuilder().where()
                        .eq(Main.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                        .prepare());
                if (mainList.size() > 0)
                    cityList.get(i).setMain(mainList.get(0));
                //Wind
                List<Wind> windList= windDao.query(windDao.queryBuilder().where()
                        .eq(Wind.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                        .prepare());
                if (windList.size() > 0)
                    cityList.get(i).setWind(windList.get(0));
            }

            //databaseHelper.close();

        return cityList;
    }

    public static City getCity(int cityId, DatabaseHelper databaseHelper) throws SQLException {
        Dao<City, Integer> cityDao = null;
        Dao<Coord, Integer> coordDao = null;
        Dao<Weather, Integer> weatherDao = null;
        Dao<Sys, Integer> sysDao = null;
        Dao<Main, Integer> mainDao = null;
        Dao<Wind, Integer> windDao = null;
        Dao<Clouds, Integer> cloudsDao = null;

        cityDao = databaseHelper.getCityDao();
        coordDao = databaseHelper.getCoordDao();
        weatherDao = databaseHelper.getWeatherDao();
        sysDao = databaseHelper.getSysDao();
        mainDao  = databaseHelper.getMainDao();
        windDao = databaseHelper.getWindDao();
        cloudsDao  = databaseHelper.getCloudsDao();

        List<City> cityList =cityDao.query(cityDao.queryBuilder().where()
                .eq(City.FIELD_NAME_ID, cityId)
                .prepare());

        //retrieving nested values from different tables
        for(int i = 0; i <cityList.size(); i++ ){
            //Coord
            List<Coord> coordList= coordDao.query(coordDao.queryBuilder().where()
                    .eq(Coord.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                    .prepare());
            if (coordList.size() > 0)
                cityList.get(i).setCoord(coordList.get(0));
            //Clouds
            List<Clouds> cloudsList= cloudsDao.query(cloudsDao.queryBuilder().where()
                    .eq(Clouds.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                    .prepare());
            if (cloudsList.size() > 0)
                cityList.get(i).setClouds(cloudsList.get(0));
            //Weather
            List<Weather> weatherList= weatherDao.query(weatherDao.queryBuilder().where()
                    .eq(Weather.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                    .prepare());
            if (cloudsList.size() > 0)
                cityList.get(i).setWeather(weatherList);
            //Sys
            List<Sys> sysList= sysDao.query(sysDao.queryBuilder().where()
                    .eq(Sys.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                    .prepare());
            if (sysList.size() > 0)
                cityList.get(i).setSys(sysList.get(0));
            //Main
            List<Main> mainList= mainDao.query(mainDao.queryBuilder().where()
                    .eq(Main.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                    .prepare());
            if (mainList.size() > 0)
                cityList.get(i).setMain(mainList.get(0));
            //Wind
            List<Wind> windList= windDao.query(windDao.queryBuilder().where()
                    .eq(Wind.FIELD_NAME_CITY_ID, cityList.get(i).getId())
                    .prepare());
            if (windList.size() > 0)
                cityList.get(i).setWind(windList.get(0));
        }

        return cityList.get(0);
    }
}

package com.aaron.weather_java.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.aaron.weather_java.domain.FutureWeather;
import com.aaron.weather_java.domain.HourlyWeather;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    public Database(Context context) {
        super(context, DatabaseInformation.DB_NAME, null, DatabaseInformation.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String hourlyWeatherQuery = "CREATE TABLE " + DatabaseInformation.HOURLY_WEATHER_TABLE_NAME + " ("
                + DatabaseInformation.HOURLY_WEATHER_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DatabaseInformation.HOURLY_WEATHER_HOUR_COL + " TEXT,"
                + DatabaseInformation.HOURLY_WEATHER_TEMP_COL + " INTEGER,"
                + DatabaseInformation.HOURLY_WEATHER_IMG_RESOURCE_ID_COL + " INTEGER)";

        String futureWeatherQuery = "CREATE TABLE " + DatabaseInformation.FUTURE_WEATHER_TABLE_NAME + " ("
                + DatabaseInformation.FUTURE_WEATHER_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DatabaseInformation.FUTURE_WEATHER_DAY_COL + " TEXT,"
                + DatabaseInformation.FUTURE_WEATHER_STATUS_COL + " TEXT,"
                + DatabaseInformation.FUTURE_WEATHER_HIGH_TEMP_COL + " INTEGER,"
                + DatabaseInformation.FUTURE_WEATHER_LOW_TEMP_COL + " INTEGER,"
                + DatabaseInformation.FUTURE_WEATHER_IMG_RESOURCE_ID_COL + " INTEGER)";

        sqLiteDatabase.execSQL(hourlyWeatherQuery);
        sqLiteDatabase.execSQL(futureWeatherQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertHourlyWeather(HourlyWeather hourlyWeather) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseInformation.HOURLY_WEATHER_HOUR_COL, hourlyWeather.getHour());
        values.put(DatabaseInformation.HOURLY_WEATHER_TEMP_COL, hourlyWeather.getTemp());
        values.put(DatabaseInformation.HOURLY_WEATHER_IMG_RESOURCE_ID_COL, hourlyWeather.getImgResourceId());

        db.insert(DatabaseInformation.HOURLY_WEATHER_TABLE_NAME, null, values);
        db.close();
    }

    public void insertFutureWeather(FutureWeather futureWeather) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseInformation.FUTURE_WEATHER_DAY_COL, futureWeather.getDay());
        values.put(DatabaseInformation.FUTURE_WEATHER_STATUS_COL, futureWeather.getStatus());
        values.put(DatabaseInformation.FUTURE_WEATHER_HIGH_TEMP_COL, futureWeather.getHighTemp());
        values.put(DatabaseInformation.FUTURE_WEATHER_LOW_TEMP_COL, futureWeather.getLowTemp());
        values.put(DatabaseInformation.FUTURE_WEATHER_IMG_RESOURCE_ID_COL, futureWeather.getImgResourceId());

        db.insert(DatabaseInformation.FUTURE_WEATHER_TABLE_NAME, null, values);
        db.close();
    }

    public List<HourlyWeather> getAllHourlyWeather() {
        List<HourlyWeather> hourlyWeatherList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + DatabaseInformation.HOURLY_WEATHER_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HourlyWeather hourlyWeather = new HourlyWeather();
                int hourIndex = cursor.getColumnIndex(DatabaseInformation.HOURLY_WEATHER_HOUR_COL);
                if (hourIndex != -1) {
                    hourlyWeather.setHour(cursor.getString(hourIndex));
                }

                int tempIndex = cursor.getColumnIndex(DatabaseInformation.HOURLY_WEATHER_TEMP_COL);
                if (tempIndex != -1) {
                    hourlyWeather.setTemp(cursor.getInt(tempIndex));
                }

                int imgResourceIdIndex = cursor.getColumnIndex(DatabaseInformation.HOURLY_WEATHER_IMG_RESOURCE_ID_COL);
                if (imgResourceIdIndex != -1) {
                    hourlyWeather.setImgResourceId(cursor.getInt(imgResourceIdIndex));
                }

                hourlyWeatherList.add(hourlyWeather);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return hourlyWeatherList;
    }

    public List<FutureWeather> getAllFutureWeather() {
        List<FutureWeather> futureWeatherList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + DatabaseInformation.FUTURE_WEATHER_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                FutureWeather futureWeather = new FutureWeather();
                int dayColumnIndex = cursor.getColumnIndex(DatabaseInformation.FUTURE_WEATHER_DAY_COL);
                int statusColumnIndex = cursor.getColumnIndex(DatabaseInformation.FUTURE_WEATHER_STATUS_COL);
                int highTempColumnIndex = cursor.getColumnIndex(DatabaseInformation.FUTURE_WEATHER_HIGH_TEMP_COL);
                int lowTempColumnIndex = cursor.getColumnIndex(DatabaseInformation.FUTURE_WEATHER_LOW_TEMP_COL);
                int imgResourceIdColumnIndex = cursor.getColumnIndex(DatabaseInformation.FUTURE_WEATHER_IMG_RESOURCE_ID_COL);

                if (dayColumnIndex != -1) {
                    futureWeather.setDay(cursor.getString(dayColumnIndex));
                }

                if (statusColumnIndex != -1) {
                    futureWeather.setStatus(cursor.getString(statusColumnIndex));
                }

                if (highTempColumnIndex != -1) {
                    futureWeather.setHighTemp(cursor.getInt(highTempColumnIndex));
                }

                if (lowTempColumnIndex != -1) {
                    futureWeather.setLowTemp(cursor.getInt(lowTempColumnIndex));
                }

                if (imgResourceIdColumnIndex != -1) {
                    futureWeather.setImgResourceId(cursor.getInt(imgResourceIdColumnIndex));
                }

                futureWeatherList.add(futureWeather);
            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();
        return futureWeatherList;
    }


    private static class DatabaseInformation {
        public static final String DB_NAME = "weather_db";
        public static final int DB_VERSION = 1;
        public static final String HOURLY_WEATHER_TABLE_NAME = "hourly_weather";
        public static final String HOURLY_WEATHER_ID_COL = "hourly_id";
        public static final String HOURLY_WEATHER_HOUR_COL = "hour";
        public static final String HOURLY_WEATHER_TEMP_COL = "temp";
        public static final String HOURLY_WEATHER_IMG_RESOURCE_ID_COL = "hourly_img_resource_id";


        public static final String FUTURE_WEATHER_TABLE_NAME = "future_weather";
        public static final String FUTURE_WEATHER_ID_COL = "future_id";
        public static final String FUTURE_WEATHER_DAY_COL = "day";
        public static final String FUTURE_WEATHER_STATUS_COL = "status";
        public static final String FUTURE_WEATHER_HIGH_TEMP_COL = "high_temp";
        public static final String FUTURE_WEATHER_LOW_TEMP_COL = "low_temp";
        public static final String FUTURE_WEATHER_IMG_RESOURCE_ID_COL = "future_img_resource_id";

    }
}

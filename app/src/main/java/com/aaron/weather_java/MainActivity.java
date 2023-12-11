package com.aaron.weather_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aaron.weather_java.adapter.HourlyAdapter;
import com.aaron.weather_java.database.Database;
import com.aaron.weather_java.domain.HourlyWeather;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.database = new Database(this);
        List<HourlyWeather> hourlyWeathers = this.database.getAllHourlyWeather();

        RecyclerView rvHourly = findViewById(R.id.rvHourly);
        HourlyAdapter hourlyAdapter = new HourlyAdapter(hourlyWeathers);

        rvHourly.setAdapter(hourlyAdapter);
        rvHourly.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        findViewById(R.id.tvNextSevenDays).setOnClickListener(view -> {
            startActivity(new Intent(this, FutureActivity.class));
        });
    }

}
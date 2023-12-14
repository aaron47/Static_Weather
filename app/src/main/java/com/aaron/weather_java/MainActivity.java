package com.aaron.weather_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.weather_menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.miNextWeekWeather) {
            this.startActivity(new Intent(this, FutureActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }
}
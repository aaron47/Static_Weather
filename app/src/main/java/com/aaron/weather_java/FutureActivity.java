package com.aaron.weather_java;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aaron.weather_java.adapter.FutureAdapter;
import com.aaron.weather_java.database.Database;
import com.aaron.weather_java.domain.FutureWeather;

import java.util.List;

public class FutureActivity extends AppCompatActivity {
    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);
        this.database = new Database(this);
        List<FutureWeather> futureWeathers = this.database.getAllFutureWeather();

        RecyclerView rvFuture = findViewById(R.id.rvFuture);
        FutureAdapter futureAdapter = new FutureAdapter(futureWeathers);
        rvFuture.setAdapter(futureAdapter);
        rvFuture.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.ivBack).setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}

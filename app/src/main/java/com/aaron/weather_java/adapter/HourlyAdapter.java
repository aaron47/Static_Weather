package com.aaron.weather_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaron.weather_java.R;
import com.aaron.weather_java.domain.HourlyWeather;

import java.util.List;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder> {

    private final List<HourlyWeather> hourlyWeatherItems;

    public HourlyAdapter(List<HourlyWeather> hourlyWeatherItems) {
        this.hourlyWeatherItems = hourlyWeatherItems;
    }

    @NonNull
    @Override
    public HourlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.hourly_item, parent, false);
        return new HourlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyViewHolder holder, int position) {
        HourlyWeather item = hourlyWeatherItems.get(position);

        View itemView = holder.itemView;
        TextView tvHourlyTitle = itemView.findViewById(R.id.tvHourlyTitle);
        TextView tvHourlyDegrees = itemView.findViewById(R.id.tvHourlyDegrees);
        ImageView ivHourly = itemView.findViewById(R.id.ivHourly);

        tvHourlyTitle.setText(item.getHour());
        tvHourlyDegrees.setText(String.valueOf(item.getTemp()));
        ivHourly.setImageResource(item.getImgResourceId());
    }

    @Override
    public int getItemCount() {
        return this.hourlyWeatherItems.size();
    }

    public static class HourlyViewHolder extends RecyclerView.ViewHolder {
        public HourlyViewHolder(View itemView) {
            super(itemView);
        }
    }
}

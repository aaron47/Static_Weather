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
import com.aaron.weather_java.domain.FutureWeather;

import java.util.List;
import java.util.concurrent.Future;


public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.FutureViewHolder> {

    private final List<FutureWeather> futureWeatherItems;

    public FutureAdapter(List<FutureWeather> futureWeatherItems) {
        this.futureWeatherItems = futureWeatherItems;
    }


    @NonNull
    @Override
    public FutureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.future_item, parent, false);
        return new FutureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FutureViewHolder holder, int position) {
        FutureWeather item = futureWeatherItems.get(position);

        View itemView = holder.itemView;
        TextView tvDay = itemView.findViewById(R.id.tvDay);
        TextView tvStatus = itemView.findViewById(R.id.tvStatus);
        TextView tvLowTemp = itemView.findViewById(R.id.tvLowTemp);
        TextView tvHighTemp = itemView.findViewById(R.id.tvHighTemp);
        ImageView ivDayWeather = itemView.findViewById(R.id.ivDayWeather);

        tvDay.setText(item.getDay());
        tvStatus.setText(item.getStatus());
        tvLowTemp.setText(String.valueOf(item.getLowTemp()));
        tvHighTemp.setText(String.valueOf(item.getHighTemp()));
        ivDayWeather.setImageResource(item.getImgResourceId());
    }

    @Override
    public int getItemCount() {
        return this.futureWeatherItems.size();
    }

    public static class FutureViewHolder extends RecyclerView.ViewHolder {
        public FutureViewHolder(View itemView) {
            super(itemView);
        }
    }
}

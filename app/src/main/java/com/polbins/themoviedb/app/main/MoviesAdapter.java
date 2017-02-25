package com.polbins.themoviedb.app.main;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.polbins.themoviedb.R;
import com.polbins.themoviedb.api.model.Images;
import com.polbins.themoviedb.api.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by polbins on 25/02/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movies;
    private Activity activity;
    private Images images;

    public MoviesAdapter(List<Movie> movies, Activity activity, Images images) {
        this.movies = movies;
        this.activity = activity;
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movies.get(position);

        String fullImageUrl = getFullImageUrl(movie);
        if (!fullImageUrl.isEmpty()) {
            Glide.with(activity)
                    .load(fullImageUrl)
                    .centerCrop()
                    .into(holder.imageView);
        }

        String popularity = getPopularityString(movie.popularity);
        holder.popularityTextView.setText(popularity);
        holder.titleTextView.setText(movie.title);
    }

    @NonNull
    private String getFullImageUrl(Movie movie) {
        if (images != null && images.baseUrl != null && !images.baseUrl.isEmpty()) {
            if (images.posterSizes != null) {
                if (images.posterSizes.size() > 4) {
                    // usually equal to 'w500'
                    return images.baseUrl + images.posterSizes.get(4) + movie.posterPath;
                } else {
                    // back-off to hard-coded value
                    return images.baseUrl + "w500" + movie.posterPath;
                }
            }
        }

        return "";
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void clear() {
        movies.clear();
    }

    public void addAll(List<Movie> movies) {
        this.movies.addAll(movies);
    }

    public void setImages(Images images) {
        this.images = images;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.popularityTextView)
        TextView popularityTextView;
        @BindView(R.id.titleTextView)
        TextView titleTextView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    private String getPopularityString(float popularity) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.#");
        return decimalFormat.format(popularity);
    }

}

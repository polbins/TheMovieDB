# TheMovieDB
Android App using The Movie DB API

# Description
Shows a list of the latest Movies sorted by popularity, which could be drilled down to view the Detail.

Utilizes a simple MVP pattern, similar to [https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger](https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger) but without the use of Fragments. Implemented Unit Tests for the Presenter.

## Requirements
Minimum API: 9

## Libraries Used
Dagger 2.8, Retrofit 2.1, Glide, Butterknife, Stetho, Mockito/JUnit

## Features

### Movie List (Title, Image, Popularity)
  - Pull to Refresh
  - Endless Scroll

### Movie Detail (Overview, Genres, Duration, Language)
  - View in Custom Chrome Tab via "Book the Movie" Button
  

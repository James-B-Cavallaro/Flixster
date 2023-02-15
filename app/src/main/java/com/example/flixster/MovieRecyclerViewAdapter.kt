package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixster.R.id

class MovieRecyclerViewAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_movies, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
        var mItem: Movie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
        val mMovieDescription: TextView = mView.findViewById<View>(id.movie_description)  as TextView
        val mMoviePoster: ImageView = mView.findViewById<View>(id.movie_poster) as ImageView

        override fun toString(): String{
            return "$mMovieTitle '$mMovieDescription'"
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.name
        holder.mMovieDescription.text = movie.description

        val posterURL = "https://image.tmdb.org/t/p/w500/" + movie.posterURL

        Glide.with(holder.mView).load(posterURL).centerInside().into(holder.mMoviePoster)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
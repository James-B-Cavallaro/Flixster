package com.example.flixster

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("title")
    var name: String? = null

    @SerializedName("overview")
    var description: String? = null

    @SerializedName("poster_path")
    var posterURL: String? = null

}
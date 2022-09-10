package com.example.phonepe.model.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieList(
    @SerializedName("page")
    val page:Int,
    @SerializedName("total_pages")
    val total_pages:Int,
    @SerializedName("results")
    val results:List<MovieListV2>
):Parcelable

@Parcelize
data class MovieListV2(
    val adult:Boolean,
    val backdrop_path:String,
    val id:Int,
    val original_language:String,
    val original_title:String,
    val overview:String,
    val popularity:Double,
    val poster_path:String,
    val release_date:String,
    val title: String,
    val video: Boolean,
    val vote_average:Double,
    val vote_count:Int
):Parcelable
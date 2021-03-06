package com.hernandazevedo.moviedb.data.mapper

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import com.hernandazevedo.moviedb.data.api.remote.RemoteMovie
import com.hernandazevedo.moviedb.data.api.remote.RemoteMovieDetail
import com.hernandazevedo.moviedb.data.api.remote.RemoteMovieSearch

/**
 * Class used to transform from Strings representing json to valid objects.
 */
class MovieJsonMapper {

    private val gson: Gson = Gson()

    @Throws(JsonSyntaxException::class)
    fun transformToRemoteMovie(jsonReponse: String): RemoteMovie? {
        val userEntityType = object : TypeToken<RemoteMovie>() {
        }.type
        return this.gson.fromJson<RemoteMovie>(jsonReponse, userEntityType)
    }

    @Throws(JsonSyntaxException::class)
    fun transformToRemoteMovieDetail(jsonReponse: String): RemoteMovieDetail? {
        val userEntityType = object : TypeToken<RemoteMovieDetail>() {
        }.type
        return this.gson.fromJson<RemoteMovieDetail>(jsonReponse, userEntityType)
    }

    @Throws(JsonSyntaxException::class)
    fun transformSearch(listJsonReponse: String): RemoteMovieSearch? {
        val listOfUserEntityType = object : TypeToken<RemoteMovieSearch>() {
        }.type
        return this.gson.fromJson<RemoteMovieSearch>(listJsonReponse, listOfUserEntityType)
    }
}

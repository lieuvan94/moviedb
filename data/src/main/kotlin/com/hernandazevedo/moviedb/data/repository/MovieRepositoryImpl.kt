package com.hernandazevedo.moviedb.data.repository

import com.hernandazevedo.moviedb.Movie
import com.hernandazevedo.moviedb.data.datasource.MovieDataSource
import com.hernandazevedo.moviedb.data.mapper.MovieMapper
import com.hernandazevedo.moviedb.domain.repository.MovieRepository
import io.reactivex.Observable

class MovieRepositoryImpl(var movieDataSource: MovieDataSource) : MovieRepository {
    override fun findMovieByTitle(title: String): Observable<List<Movie>> {
        return movieDataSource.findMovieByTitle(title).map { MovieMapper.transformToList(it.search) }
    }
}
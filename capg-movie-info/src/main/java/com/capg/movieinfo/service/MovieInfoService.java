package com.capg.movieinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.capg.movieinfo.model.MovieInfo;
import com.capg.movieinfo.repo.MovieInfoRepo;

@Service
public class MovieInfoService {

	@Autowired
	MovieInfoRepo repo;
	public MovieInfo getMovieInfo(long id) {
		return repo.getOne(id);
	}
	public List<MovieInfo> getAllMovieInfo() {
		return repo.findAll();
	}
	public MovieInfo addMovieCatelog(MovieInfo movie) {
		return repo.save(movie);
	}
}

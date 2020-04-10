package com.capg.movieinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 import com.capg.movieinfo.model.MovieInfo;
import com.capg.movieinfo.service.MovieInfoService;

@RestController
@RequestMapping("/info")
public class MovieInfoController {

	@Autowired
	MovieInfoService service;
	@GetMapping("/id/{id}")
	public MovieInfo getMovieInfo(@PathVariable long id) {
		return service.getMovieInfo(id);
	}
	
	@GetMapping("/all")
	public List<MovieInfo> getAllMovieInfo(){
		return service.getAllMovieInfo();
	}
	@PostMapping("/add")
	public MovieInfo addMovieInfo(@RequestBody MovieInfo movie) {
		return service.addMovieInfo(movie);
	}
	
}

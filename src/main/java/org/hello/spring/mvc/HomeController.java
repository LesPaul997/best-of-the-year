package org.hello.spring.mvc;

import java.util.ArrayList;
import java.util.List;

import org.hello.spring.model.Movie;
import org.hello.spring.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	
	
	@GetMapping("/homepage")
	public String homepage(Model model) {
		model.addAttribute("title", "Homepage");
		model.addAttribute("name", "Mario");
		
		return "homepage";
	}
	
	@GetMapping("/movies")
	public String movies(Model model) {
    	model.addAttribute("title", "List of our best movies");
    	String bestMovies = "";
		
		for ( Movie movie : getBestMovies()) {
			bestMovies += movie.getTitle() + " - ";
		}
		model.addAttribute("list", bestMovies);
			
			return "titles";
	}
	
	@GetMapping("/songs")
	public String songTitle(Model model) {
		model.addAttribute("title", "List of our best songs");
		String bestSongs = "";
		
		for ( Song song : getBestSongs()) {
			bestSongs += song.getTitle() + " - ";
		}
		
		model.addAttribute("list", bestSongs);
		
		return "titles";
	}
	
	
	//Esempio Movies con ID
	@GetMapping("/movies/{id}")
	public String movieDetails(Model model, @PathVariable("id") Integer movieId) {
		model.addAttribute("title", "Single Movie Detail");
		String movieTitle = null;
		
		for ( Movie movie : getBestMovies()) {
			if(movieId.equals(movie.getId())) {
				movieTitle = movie.getTitle();
			}
		}
		
		model.addAttribute("name", movieTitle);
		
		return "detail";
	}
	
	
	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie(0, "Nuovo Cinema Paradiso"));
		movies.add(new Movie(1, "Il signore degli anelli"));
		movies.add(new Movie(2, "Need For Speed"));
		movies.add(new Movie(3, "Troy"));
		movies.add(new Movie(4, "Ti presento i miei"));
		
		return movies;
	}
	
	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<Song>();
		songs.add(new Song(0, "Acqua e Sale"));
		songs.add(new Song(1, "Hey Joe"));
		songs.add(new Song(2, "Imagine"));
		songs.add(new Song(3, "Me so mbriacato"));
		songs.add(new Song(4, "Brivido Felino"));
		
		return songs;
	}

}

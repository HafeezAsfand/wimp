package com.el.ally.wimp.api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.el.ally.wimp.models.Actor;
import com.el.ally.wimp.models.Movie;
import com.el.ally.wimp.repositories.MovieRepository;
import com.el.ally.wimp.repositories.ActorRepository;


@RestController
@RequestMapping("api/movies")
public class MovieController {
	
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private MovieRepository movieRepository;
	
	@PostMapping("/{movieId}/actors")
	public Movie movie(@PathVariable long movieId, @RequestBody Actor actor)
	{
		Movie movie = movieRepository.findOne(movieId);
		Actor actors = actorRepository.findOne(actor.getId());
		movie.getActors().add(actors);
		movieRepository.save(movie);
		return movie;
	}

	@GetMapping("/")
	public List<Movie> getMovie()
	{
		List<Movie> Movie = movieRepository.findAll();
		return Movie;
	}
	
	@GetMapping("{id}")
	public Movie getSpecificMovie(@PathVariable long id)
	{
		Movie movie = (Movie) movieRepository.findOne(id);
		return movie;
	}
	
	@PostMapping("/")
	public Movie createMovie(@RequestBody Movie movie)
	{
		Movie newMovie = movieRepository.save(movie);
		return newMovie;
	}
	
	@PutMapping("{id}")
	public Movie getSpecificMovie(@PathVariable long id, @RequestBody Movie movie)
	{
		movie.setId(id);
		Movie updatedMovie = movieRepository.save(movie);
		return updatedMovie;
	}
	
	@DeleteMapping("{id}")
	  public Movie delete(@PathVariable long id) 
	{
	    Movie originalMovie = movieRepository.findOne(id);
	    movieRepository.delete(originalMovie);
	    return originalMovie;
	  }
	
}

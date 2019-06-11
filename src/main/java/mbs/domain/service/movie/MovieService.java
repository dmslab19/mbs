package mbs.domain.service.movie;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mbs.domain.model.AvailableMovie;
import mbs.domain.model.AvailableMovieId;
import mbs.domain.model.Movie;
import mbs.domain.repository.movie.AvailableMovieRepository;
import mbs.domain.repository.movie.MovieRepository;

@Service
@Transactional
public class MovieService {
    @Autowired
    AvailableMovieRepository availableMovieRepository;

    @Autowired
    MovieRepository movieRepository;

    public List<AvailableMovie> findAvailableMovies(LocalDate date) {
        return availableMovieRepository
                .findByAvailableMovieId_BookedDateOrderByAvailableMovieId_MovieIdAsc(
                        date);
    }

    public Movie findMovie(Integer movieId) {
        return movieRepository.findOne(movieId);
    }
    
    public AvailableMovie findAvailableMovie(AvailableMovieId availableMovieId) {
    	return availableMovieRepository.findOneForUpdateByAvailableMovieId(availableMovieId);
    }
}
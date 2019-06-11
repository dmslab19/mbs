package mbs.domain.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import mbs.domain.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}

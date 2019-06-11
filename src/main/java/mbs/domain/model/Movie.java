package mbs.domain.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Movie implements Serializable{
	
	private static final long serialVersionUID = -3061200265893493806L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer movieId;
    private String movieName;
    
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}   
}

package mbs.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import mbs.domain.model.AvailableMovieId;

@Embeddable
public class AvailableMovieId implements Serializable{
	private static final long serialVersionUID = 734039175833985171L;
	private Integer movieId;
	private LocalDate availableDate;
	
	public AvailableMovieId(Integer movieId, LocalDate availableDate) {
		this.movieId = movieId;
		this.availableDate = availableDate;
	}
	
	public AvailableMovieId() {
		
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((availableDate == null) ? 0 : availableDate.hashCode());
        result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AvailableMovieId other = (AvailableMovieId) obj;
        if (availableDate== null) {
            if (other.availableDate != null)
                return false;
        } else if (!availableDate.equals(other.availableDate))
            return false;
        if (movieId == null) {
            if (other.movieId != null)
                return false;
        } else if (!movieId.equals(other.movieId))
            return false;
        return true;
    }

}

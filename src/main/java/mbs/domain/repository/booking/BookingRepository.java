package mbs.domain.repository.booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mbs.domain.model.AvailableMovieId;
import mbs.domain.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	List<Booking> findByAvailableMovie_AvailableMovieIdOrderByBookedDateAsc(AvailableMovieId availableMovieId); 
}

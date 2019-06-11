package mbs.domain.service.booking;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mbs.domain.model.AvailableMovie;
import mbs.domain.model.AvailableMovieId;
import mbs.domain.model.Booking;
import mbs.domain.model.RoleName;
import mbs.domain.model.User;
import mbs.domain.repository.booking.BookingRepository;
import mbs.domain.repository.movie.AvailableMovieRepository;

@Service
@Transactional
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    AvailableMovieRepository availableMovieRepository;

    public List<Booking> findBookings(
            AvailableMovieId availableMovieId) {
        return bookingRepository
                .findByAvailableMovie_AvailableMovieIdOrderByBookedDateAsc(
                        availableMovieId);
    }

    public Booking book(Booking booking) {
        AvailableMovieId availableMovieId = booking.getAvailableMovie()
                .getAvailableMovieId();

        // 비관적 락
        AvailableMovie available = availableMovieRepository
                .findOneForUpdateByAvailableMovieId(availableMovieId);
        if (available == null) {
            throw new UnavailableBookingException(
                    "선택한 날짜의 영화는 예매할 수 없습니다.");
        }
        // 예매 가능 여부 확인
        List<Booking> exist_bookings = bookingRepository
                .findByAvailableMovie_AvailableMovieIdOrderByBookedDateAsc(availableMovieId);
        boolean overbook = false;
        if (exist_bookings.size() == available.getSeats()) {
        	overbook = true;
        }
        if (overbook) {
            throw new AlreadyBookedException("해당 영화의 예매 가능한 빈 좌석이 없습니다.");
        }
        // 예약 정보 등록
        bookingRepository.save(booking);
        return booking;
    }

    public void cancel(Integer bookingId, User requestUser) {
        Booking booking = bookingRepository.findOne(bookingId);
        if (RoleName.ADMIN != requestUser.getRoleName()
                && !Objects.equals(booking.getUser().getUserId(),
                        requestUser.getUserId())) {
            throw new AccessDeniedException("예약을 취소할 수 없습니다.");
        }
        bookingRepository.delete(booking);
    }

    @PreAuthorize("hasRole('ADMIN')"
            + " or #booking.user.userId == principal.user.userId")
    public void cancel(@P("booking") Booking booking) {
        bookingRepository.delete(booking);
    }

    public Booking findOne(Integer bookingId) {
        return bookingRepository.findOne(bookingId);
    }

}
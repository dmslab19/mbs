package mbs.app.booking;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mbs.domain.model.AvailableMovie;
import mbs.domain.model.AvailableMovieId;
import mbs.domain.model.Booking;
import mbs.domain.service.booking.AlreadyBookedException;
import mbs.domain.service.booking.BookingService;
import mbs.domain.service.booking.UnavailableBookingException;
import mbs.domain.service.movie.MovieService;
import mbs.domain.service.user.BookingUserDetails;

@Controller
@RequestMapping("bookings/{date}/{movieId}")
public class BookingController {
    @Autowired
    MovieService movieService;
    @Autowired
    BookingService bookingService;

    @RequestMapping(method = RequestMethod.GET)
    String bookingForm(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
            @PathVariable("movieId") Integer movieId, Model model) {
        AvailableMovieId availableMovieId = new AvailableMovieId(movieId, date);
        List<Booking> bookings = bookingService
                .findBookings(availableMovieId);
        String remainSeats = String.valueOf(movieService.findAvailableMovie(availableMovieId).getSeats() - bookings.size());
        model.addAttribute("remainSeats", remainSeats);
        model.addAttribute("movie", movieService.findMovie(movieId));
        model.addAttribute("bookings", bookings);
        return "booking/bookingForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    String book(@Validated BookingForm bookingForm, BindingResult bindingResult,
            @AuthenticationPrincipal BookingUserDetails userDetails,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
            @PathVariable("movieId") Integer movieId, Model model) {
        if (bindingResult.hasErrors()) {
            return bookingForm(date, movieId, model);
        }
        AvailableMovie availableMovie = new AvailableMovie(
                new AvailableMovieId(movieId, date));
        
        Booking booking = new Booking();
        booking.setBookedDate(date);
        booking.setAvailableMovie(availableMovie);
        booking.setUser(userDetails.getUser());
        
        try {
            bookingService.book(booking);
        } catch (UnavailableBookingException | AlreadyBookedException e) {
            model.addAttribute("error", e.getMessage());
            return bookingForm(date, movieId, model);
        }
        return "redirect:/bookings/{date}/{movieId}";
    }

    @RequestMapping(method = RequestMethod.POST, params = "cancel")
    String cancel(@AuthenticationPrincipal BookingUserDetails userDetails,
            @RequestParam("bookingId") Integer bookingId,
            @PathVariable("movieId") Integer movieId,
            @DateTimeFormat(
                    iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
            Model model) {

        try {
            Booking booking = bookingService.findOne(bookingId);
            bookingService.cancel(booking);
        } catch (AccessDeniedException e) {
            model.addAttribute("error", e.getMessage());
            return bookingForm(date, movieId, model);
        }
        return "redirect:/bookings/{date}/{movieId}";
    }
}
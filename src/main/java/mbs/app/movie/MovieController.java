package mbs.app.movie;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mbs.domain.model.AvailableMovie;
import mbs.domain.service.movie.MovieService;

@Controller
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping(value = "{date}", method = RequestMethod.GET)
    String listMovies(@DateTimeFormat(
            iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date,
            Model model) {
        List<AvailableMovie> movies = movieService.findAvailableMovies(date);
        model.addAttribute("movies", movies);
        return "movie/listMovies";
    }

    @RequestMapping(method = RequestMethod.GET)
    String listMovies(Model model) {
        LocalDate today = LocalDate.now();
        model.addAttribute("date", today);
        return listMovies(today, model);
    }
}
package ToyProject.OttFind.controller;

import ToyProject.OttFind.domain.Film;

import ToyProject.OttFind.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/film")
    public List<Film> getAllFilms(){
        return filmService.getAllFilms();
    }

    @RequestMapping(value = "/film", params = "id")
    public Optional<Film> findById(@RequestParam Integer id) {return filmService.findFilmById(id);}

    @RequestMapping(value = "/film", params = "title")
    public List<Film> findByTitle(@RequestParam String title){
       return filmService.findFilmByTitle(title);
    }

    @RequestMapping(value = "/film", params = "genre")
    public List<Film> findByGenre(@RequestParam String genre){
        return filmService.findFilmByGenre(genre);
    }

    @RequestMapping(value = "/film", params = "type")
    public List<Film> findByType(@RequestParam String type){
        return filmService.findFilmByType(type);
    }

    @RequestMapping(value = "/film", params = "country")
    public List<Film> findByCountry(@RequestParam String country){
        return filmService.findFilmByCountry(country);
    }

    @RequestMapping(value = "/film", params = "year")
    public List<Film> findByYear(@RequestParam Integer year){
        return filmService.findFilmByYear(year);
    }

    @RequestMapping(value = "/film", params = "ott")
    public List<Film> findByOtt(@RequestParam String ott){
        return filmService.findFilmByOtt(ott);
    }
}

package ToyProject.OttFind.controller;

import ToyProject.OttFind.domain.Film;

import ToyProject.OttFind.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("/film")
    public List<Film> getAllFilms(){
        return filmService.getAllFilms();
    }

    @RequestMapping(value = "/film", params = "title")
    public List<Film> findByTitle(@RequestParam String title){
       return filmService.findFilmByTitle(title);
    }

    @RequestMapping(value = "/film", params = "genre")
    public List<Film> findByGenre(@RequestParam String genre){
        return filmService.findFilmByGenre(genre);
    }
}

package ToyProject.OttFind.controller;

import ToyProject.OttFind.domain.Ott;
import ToyProject.OttFind.service.OttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OttController {
    @Autowired
    private OttService ottService;

    @GetMapping("/ott")
    public List<Ott> getAllOtt(){
        return ottService.getAllOtt();
    }

    @RequestMapping(value="/ott", params="film_id")
    public List<Ott> getOttByFilm(@RequestParam("film_id") Integer id){
        return ottService.getFilmInOtt(id);
    }
}

package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.Ott;
import ToyProject.OttFind.repository.OttInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class OttService {
    @Autowired
    private final OttInterface OttRepository;

    public OttService(OttInterface filmInOttRepository) {
        this.OttRepository = filmInOttRepository;
    }

    public List<Ott> getFilmInOtt(Integer id){
        System.out.println(id+"no issang service");
        return OttRepository.findOttByFilm(id);
    }

    public List<Ott> getAllOtt(){
        return OttRepository.findAll();
    }

}

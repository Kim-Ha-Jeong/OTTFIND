package ToyProject.OttFind.service;

import ToyProject.OttFind.domain.Ott;
import ToyProject.OttFind.repository.OttInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class OttService {
    @Autowired
    private final OttInterface ottRepository;

    public OttService(OttInterface ottRepository) {
        this.ottRepository = ottRepository;
    }

    public List<Ott> getFilmInOtt(Integer id){
        return ottRepository.findOttByFilm(id);
    }

    public List<Ott> getAllOtt(){
        return ottRepository.findAll();
    }

}

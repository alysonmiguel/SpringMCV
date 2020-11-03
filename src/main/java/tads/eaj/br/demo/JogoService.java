package tads.eaj.br.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private JogoRepository repository;

    @Autowired
    public void setRepository(JogoRepository repository) {
        this.repository = repository;
    }

    public JogoRepository getRepository(){
        return repository;
    }

    public List<Jogo> findAll(){
        return  repository.findAll();
    }

    public void save(Jogo j){
        repository.save(j);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Jogo getById(Long id){
        return  repository.getOne(id);
    }

}

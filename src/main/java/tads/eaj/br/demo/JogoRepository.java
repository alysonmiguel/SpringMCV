package tads.eaj.br.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByAnoLancamento(Integer ano);
}

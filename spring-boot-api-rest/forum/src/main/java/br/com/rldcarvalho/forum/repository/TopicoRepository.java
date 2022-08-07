package br.com.rldcarvalho.forum.repository;

import br.com.rldcarvalho.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByCursoNome(String nomeCurso);

    //para mudar o nome padrão:
//    @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
//    List<Topico> carregaPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}

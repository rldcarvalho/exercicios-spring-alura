package br.com.rldcarvalho.forum.repository;

import br.com.rldcarvalho.forum.modelo.Curso;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void deveriaCarregarUmCursoAoBuscarPeloSeuNome(){
        String nomeCurso = "HTML 5";
        Curso curso = repository.findByNome(nomeCurso);

        Curso html5 = new Curso();
        html5.setNome(nomeCurso);
        html5.setCategoria("Programacao");
        em.persist(html5);

        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    public void NaoDeveriaCarregarUmCursoQueONomeNaoEstaCadastrado(){
        String nomeCurso = "JPA";
        Curso curso = repository.findByNome(nomeCurso);

        Assert.assertNull(curso);
    }
}
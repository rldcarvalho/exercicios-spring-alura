package br.com.rldcarvalho.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name="categorias")
public class Categoria {
//    @Id
//    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @EmbeddedId
    private CategoriaId id;


    public Categoria() {
    }

    public Categoria(String nome) {
        this.id = new CategoriaId(nome, "geral");
    }

    public String getNome() {
        return this.id.getNome();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

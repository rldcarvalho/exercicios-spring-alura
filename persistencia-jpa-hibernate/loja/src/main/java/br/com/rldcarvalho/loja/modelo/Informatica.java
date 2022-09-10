package br.com.rldcarvalho.loja.modelo;

import javax.persistence.Entity;

@Entity
public class Informatica extends Produto{

    private String marca;
    private String modelo;

    public Informatica() {
    }

    public Informatica(String autor, String modelo) {
        this.marca = autor;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import xml.DataAdapter;
import java.time.LocalDate;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author gabrielstahlberg
 */

@XmlAccessorType(XmlAccessType.FIELD)

public class Obra {
    @XmlElement(name = "titulo")
    private String titulo;
    
    @XmlElement(name = "isbn")
    private String isbn;
    
    @XmlElement(name = "editora")
    private String editora;
    
    @XmlElement(name = "data")
    @XmlJavaTypeAdapter(DataAdapter.class)
    private LocalDate dataPubl;
    
    @XmlElement(name = "autor")
    @XmlElementWrapper(name = "autores")
    private List<String> autores;
    
    @XmlElement(name = "palavra-chave")
    @XmlElementWrapper(name = "palavras-chave")
    private List<String> palavrasChaves;
    
    @XmlElement(name = "edicao")
    private int nroEdicao;
    
    @XmlElement(name = "categoria")
    private String categoriaCod;
    
    private List<Exemplar> exemplares;

    public Obra(String titulo, String isbn, String editora, LocalDate dataPubl, List<String> autores, List<String> palavrasChaves, int nroEdicao, String categoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editora = editora;
        this.dataPubl = dataPubl;
        this.autores = autores;
        this.palavrasChaves = palavrasChaves;
        this.nroEdicao = nroEdicao;
        this.categoriaCod = categoria;
    }
    
    public Obra(){
        
    }

    @Override
    public String toString() {
        return "Obra{" + "titulo=" + getTitulo() + ", isbn=" + getIsbn() + ", editora=" + getEditora() + ", dataPubl=" + getDataPubl() + ", autores=" + getAutores() + ", palavrasChaves=" + getPalavrasChaves() + ", nroEdicao=" + getNroEdicao() + ", categoria=" + getCategoria() + ", exemplares=" + getExemplares() + '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public LocalDate getDataPubl() {
        return dataPubl;
    }

    public void setDataPubl(LocalDate dataPubl) {
        this.dataPubl = dataPubl;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public List<String> getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(List<String> palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    public int getNroEdicao() {
        return nroEdicao;
    }

    public void setNroEdicao(int nroEdicao) {
        this.nroEdicao = nroEdicao;
    }

    public String getCategoria() {
        return categoriaCod;
    }

    public void setCategoria(String categoria) {
        this.categoriaCod = categoria;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(List<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }
    
    
}

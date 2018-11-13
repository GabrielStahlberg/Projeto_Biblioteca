/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author gabrielstahlberg
 */
public class Obra {
    private String titulo;
    private String isbn;
    private String editora;
    private LocalDate dataPubl;
    private List<String> autores;
    private List<String> palavrasChaves;
    private int nroEdicao;
    private String categoria;

    public Obra(String titulo, String isbn, String editora, LocalDate dataPubl, List<String> autores, List<String> palavrasChaves, int nroEdicao, String categoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editora = editora;
        this.dataPubl = dataPubl;
        this.autores = autores;
        this.palavrasChaves = palavrasChaves;
        this.nroEdicao = nroEdicao;
        this.categoria = categoria;
    }
}

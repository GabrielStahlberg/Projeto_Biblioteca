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
public class Pendencia {
    private LocalDate dataEmp;
    private LocalDate dataPrev;
    private String titulo;
    private int nroEdicao;
    private List<Integer> idExemplares;
    private String nomeLeitor;
    private String catLeitor;

    public Pendencia() {
    }

    public Pendencia(LocalDate dataEmp, LocalDate dataPrev, String titulo, int nroEdicao, List<Integer> idExemplares, String nomeLeitor, String catLeitor) {
        this.dataEmp = dataEmp;
        this.dataPrev = dataPrev;
        this.titulo = titulo;
        this.nroEdicao = nroEdicao;
        this.idExemplares = idExemplares;
        this.nomeLeitor = nomeLeitor;
        this.catLeitor = catLeitor;
    }

    public LocalDate getDataEmp() {
        return dataEmp;
    }

    public void setDataEmp(LocalDate dataEmp) {
        this.dataEmp = dataEmp;
    }

    public LocalDate getDataPrev() {
        return dataPrev;
    }

    public void setDataPrev(LocalDate dataPrev) {
        this.dataPrev = dataPrev;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNroEdicao() {
        return nroEdicao;
    }

    public void setNroEdicao(int nroEdicao) {
        this.nroEdicao = nroEdicao;
    }

    public List<Integer> getIdExemplares() {
        return idExemplares;
    }

    public void setIdExemplares(List<Integer> idExemplares) {
        this.idExemplares = idExemplares;
    }

    public String getNomeLeitor() {
        return nomeLeitor;
    }

    public void setNomeLeitor(String nomeLeitor) {
        this.nomeLeitor = nomeLeitor;
    }

    public String getCatLeitor() {
        return catLeitor;
    }

    public void setCatLeitor(String catLeitor) {
        this.catLeitor = catLeitor;
    }
}

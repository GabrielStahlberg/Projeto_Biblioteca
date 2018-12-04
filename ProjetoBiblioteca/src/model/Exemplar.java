/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MiND
 */
public class Exemplar {
    private int id;
    private boolean disponivel;
    
    public Exemplar(int id, boolean disponivel){
        this.id = id;
        this.disponivel = disponivel;
    }
    public Exemplar(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    @Override
    public String toString(){
        return String.format("ID: %d, %s",id, disponivel ? "disponivel":"nao disponivel");
    }
}

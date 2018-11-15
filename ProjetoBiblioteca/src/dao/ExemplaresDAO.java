/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Exemplar;

/**
 *
 * @author MiND
 */
public class ExemplaresDAO {
    public void salvar(String isbn, Connection con){
        String sql = "insert into exemplares(exemplar_id, obra_isbn) "
                + "values(exemplar_seq.nextval, ?)";
        try
        {
            try(PreparedStatement pStat = con.prepareStatement(sql)){

                pStat.setString(1, isbn);
                pStat.executeUpdate();

            }catch (RuntimeException erro){
                throw new RuntimeException(erro);
            }
        }
        catch(SQLException erro) {
            throw new RuntimeException(erro);
        }   
    }    
    
    public List<Exemplar> buscarExemplares(String obra_Isbn){
        String sql = "select * from exemplares where obra_isbn = ?";
        List<Exemplar> exemplares = new ArrayList<>();
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql);
            ){
            pStat.setString(1, obra_Isbn);
            
            try(ResultSet rs = pStat.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("exemplar_id");
                    boolean disponivel = "Disponivel".equals(rs.getString("exemplar_status"));
                    Exemplar e = new Exemplar(id,disponivel);
                    
                    exemplares.add(e);
                }
                
                return exemplares;
                
            }
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
}

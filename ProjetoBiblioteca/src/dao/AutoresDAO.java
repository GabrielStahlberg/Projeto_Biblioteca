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
import model.Obra;

/**
 *
 * @author gabrielstahlberg
 */
public class AutoresDAO {
    
        public void salvar(Obra obra){
        String sql = "insert into autores(autor_nro,autor_nome,obra_isbn) "
                + "values(autores_seq.nextval,?,?)";
        ConexaoBD conexao = ConexaoBD.getInstance();
        try (
                Connection con = conexao.getConnection())
        {
            con.setAutoCommit(false);

            try(PreparedStatement pStat = con.prepareStatement(sql)){
                for(int i=0; i<obra.getAutores().size(); i++){
                    pStat.setString(1, obra.getAutores().get(i));
                    pStat.setString(2, obra.getIsbn());
                    pStat.executeUpdate();
                }
                con.commit();
            }catch (RuntimeException erro){
                con.rollback();
                throw new RuntimeException(erro);
            }
        }
        catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public List<String> buscar(String obra_Isbn){
        String sql = "select * from autores where obra_isbn = ?";
        List<String> autores = new ArrayList<>();
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql);
            ){
            pStat.setString(1, obra_Isbn);
            
            try(ResultSet rs = pStat.executeQuery()){
                while(rs.next()){
                    autores.add(rs.getString("autor_nome"));
                }
                
                return autores;
                
            }
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
        
}

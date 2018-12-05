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

/**
 *
 * @author gabrielstahlberg
 */
public class LeitoresDAO {
    public int getID(String prontuario){
        String sql = "select leitor_id from leitores where leitor_prontuario = ?";
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql)                
            ){
            pStat.setString(1, prontuario);
            ResultSet rs = pStat.executeQuery();
                    
            rs.next();            
            return rs.getInt("leitor_id");
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public int getDias(String prontuario){
        String sql = "select c.cat_leitor_max_dias from categoria_leitor c, leitores l where leitor_prontuario = ? and c.cat_leitor_cod = l.cat_leitor_cod";
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql)                
            ){
            pStat.setString(1, prontuario);
            ResultSet rs = pStat.executeQuery();
                    
            rs.next();            
            return rs.getInt("cat_leitor_max_dias");
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public int getStatus(int idLeitor){
        String sql = "select l.leitor_status_emprestimo from leitores l where l.leitor_id = ?";
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql)                
            ){
            pStat.setInt(1, idLeitor);
            ResultSet rs = pStat.executeQuery();
                    
            rs.next();            
            return rs.getInt("leitor_status_emprestimo");
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public String buscaTipoLeitor(String prontuario){
        String sql = "select c.cat_leitor_desc from categoria_leitor c, leitores l where leitor_prontuario = ? and c.cat_leitor_cod = l.cat_leitor_cod";
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql)                
            ){
            pStat.setString(1, prontuario);
            ResultSet rs = pStat.executeQuery();
                    
            rs.next();            
            return rs.getString("cat_leitor_desc");
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public int totalPeloProntuario(String prontuario){
        String sql = "select count(*) from categoria_leitor c, leitores l where leitor_prontuario = ? and c.cat_leitor_cod = l.cat_leitor_cod";
        ConexaoBD conexao = ConexaoBD.getInstance();
        try (
                Connection con = conexao.getConnection();
                PreparedStatement pStat = con.prepareStatement(sql)
                )
        {
            pStat.setString(1, prontuario);
            ResultSet rs = pStat.executeQuery();
            
            rs.next();
            return rs.getInt(1);
        }
        catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}

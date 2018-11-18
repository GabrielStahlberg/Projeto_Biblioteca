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

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
public class LoginDAO {
    public String autentica(String login, String senha){
        String sql = "select usuario from usuarios where login = ? and senha = ?";
        ConexaoBD conexao = ConexaoBD.getInstance();
        String usuarioLogado = "";
        
        try(Connection con = conexao.getConnection();
            PreparedStatement pStat = con.prepareStatement(sql)){
            
            pStat.setString(1, login);
            pStat.setString(2, senha);
            
            ResultSet rs = pStat.executeQuery();
            
            if(rs.next()){
                usuarioLogado = rs.getString("usuario");
            }

        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
        return usuarioLogado;
    }
}

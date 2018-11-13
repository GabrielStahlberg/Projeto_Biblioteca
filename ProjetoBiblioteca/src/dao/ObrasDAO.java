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
public class ObrasDAO {
    
    public List<String> buscarCategoriasObra(){
        String sql = "select cat_obra_desc from categoria_obra";
        List<String> categorias = new ArrayList<>(15);
        
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql);
                ResultSet rs = pStat.executeQuery()
            ){
            while(rs.next()){
                categorias.add(rs.getString("cat_obra_desc"));
            }
            return categorias;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public void salvarObra(Obra obra){
        
    }
}

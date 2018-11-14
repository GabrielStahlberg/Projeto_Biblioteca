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
import java.time.format.DateTimeFormatter;
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
    
    public List<String> buscarObras(){
        String sql = "select obra_titulo from obras";
        List<String> obras = new ArrayList<>(50);
        
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql);
                ResultSet rs = pStat.executeQuery()
            ){
            while(rs.next()){
                obras.add(rs.getString("obra_titulo"));
            }
            return obras;
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public String buscarCategoriasObraCod(String categoria){
        String sql = "select cat_obra_cod from categoria_obra where upper(cat_obra_desc) = upper(?)";
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql)                
            ){
            pStat.setString(1, categoria);
            ResultSet rs = pStat.executeQuery();
                    
            rs.next();            
            return rs.getString("cat_obra_cod");
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
    public void salvar(Obra obra){
        String sql = "insert into obras(obra_isbn,obra_editora,obra_titulo,obra_num_edicao, data_publ, cat_obra_cod) "
                + "values(?,?,?,?,?,?)";
        ConexaoBD conexao = ConexaoBD.getInstance();
        try (
                Connection con = conexao.getConnection())
        {
            con.setAutoCommit(false);

            try(PreparedStatement pStat = con.prepareStatement(sql)){

                pStat.setString(1, obra.getIsbn());
                pStat.setString(2, obra.getEditora());
                pStat.setString(3, obra.getTitulo());
                pStat.setInt(4, obra.getNroEdicao());
                pStat.setDate(5, java.sql.Date.valueOf(obra.getDataPubl()));
                pStat.setString(6, obra.getCategoria());
                pStat.executeUpdate();
                
                AutoresDAO autoresDAO = new AutoresDAO();
                autoresDAO.salvar(obra);
                
                PalavrasChaveDAO palavrasChaveDAO = new PalavrasChaveDAO();
                palavrasChaveDAO.salvar(obra);

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
    
    public List<Obra> realizarRelatorio(int inicio, int fim){
        String sql = "select t.* from (select rownum rn, tt.* from (select * from obras order by obra_isbn) tt where rownum <=?) t where rn >=?";
        List<Obra> obras = new ArrayList<>();
        PalavrasChaveDAO pCDAO = new PalavrasChaveDAO();
        AutoresDAO aDAO = new AutoresDAO();
        ExemplaresDAO eDAO = new ExemplaresDAO();
        try(                
                Connection con = ConexaoBD.getInstance().getConnection();
                PreparedStatement pStat = con.prepareStatement(sql)
            ){
            
            pStat.setInt(1, fim);
            pStat.setInt(2,inicio);
            
            try(ResultSet rs = pStat.executeQuery()){
                while(rs.next()){
                    Obra o = new Obra();

                    o.setIsbn(rs.getString("obra_isbn"));
                    o.setTitulo(rs.getString("obra_titulo"));
                    o.setEditora(rs.getString("obra_editora"));
                    o.setNroEdicao(rs.getInt("obra_num_edicao"));
                    o.setAutores(aDAO.buscar(o.getIsbn()));
                    o.setPalavrasChaves(pCDAO.buscar(o.getIsbn()));
                    o.setCategoria(rs.getString("cat_obra_cod"));
                    if(rs.getDate("data_publ") == null){
                        o.setDataPubl(null);
                    }
                    else{
                        o.setDataPubl(rs.getDate("data_publ").toLocalDate());
                    }
                    o.setExemplares(eDAO.buscarExemplares(o.getIsbn()));
                    
                    
                    System.out.println(o);

                }
                return obras;
            }
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
}

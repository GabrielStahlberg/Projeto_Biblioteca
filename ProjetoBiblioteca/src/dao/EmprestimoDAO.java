/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author MiND
 */
public class EmprestimoDAO {
    private void alterarStatusExemplar(Connection con, int idExemplar, String status) throws SQLException{
        String sql = "update exemplares set exemplar_status = ? where exemplar_id = ?";
        PreparedStatement pStat = con.prepareStatement(sql);
        pStat.setString(1, status);
        pStat.setInt(2, idExemplar);
        pStat.executeUpdate();
    }
    
    public void realizarEmprestimo(int idExemplar, int idLeitor, int idFunc, int diasPrev){
        String sql = "insert into emprestimos (emp_id, emp_data, emp_data_prev_dev, exemplar_id, leitor_id, func_id)"
                +    "values(emprestimos_seq.nextval, sysdate, (sysdate + ?), ?, ?, ?)";
        ConexaoBD conexao = ConexaoBD.getInstance();
        try (Connection con = conexao.getConnection()){
            con.setAutoCommit(false);
            try(PreparedStatement pStat = con.prepareStatement(sql)){
                pStat.setInt(1,diasPrev);
                pStat.setInt(2, idExemplar);
                pStat.setInt(3, idLeitor);
                pStat.setInt(4, idFunc);
                pStat.executeUpdate();
                
                alterarStatusExemplar(con,idExemplar,"Indisponivel");
                con.commit();
            }
        }
        catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
    
    public void realizarDevolucao(int idExemplar, int idLeitor){
        String sql = "update emprestimos set emp_data_real_dev = sysdate where exemplar_id = ? and emp_data_real_dev is null and leitor_id = ?";
        ConexaoBD conexao = ConexaoBD.getInstance();
        try (Connection con = conexao.getConnection()){
            con.setAutoCommit(false);
            try(PreparedStatement pStat = con.prepareStatement(sql)){
                pStat.setInt(1,idExemplar);
                pStat.setInt(2, idLeitor);
                pStat.executeUpdate();
                
                alterarStatusExemplar(con,idExemplar,"Disponivel");
                con.commit();
            }
        }
        catch(SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.CadastroListaMed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo.hpavan
 */
public class ListaMedicamentoDAO {
    public List<CadastroListaMed> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CadastroListaMed> medicamentos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM lista_medicamento");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                CadastroListaMed p = new CadastroListaMed();
                p.setCodigo(rs.getString("codigo"));
                p.setCnpj_lab(rs.getString("cnpj_lab"));
                p.setCusto_unit(rs.getString("custo_unit"));
                p.setValor_unit(rs.getString("valor_unit"));
                p.setDescricao(rs.getString("descricao"));
                medicamentos.add(p);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
    
        return medicamentos;
    }
    
    public void create(CadastroListaMed p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into lista_medicamento(codigo,cnpj_lab, custo_unit, valor_unit, descricao) values(?, ?, ?, ?, ?)");
            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getCnpj_lab());
            stmt.setString(3, p.getCusto_unit());
            stmt.setString(4, p.getValor_unit());
            stmt.setString(5, p.getDescricao());
        
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(CadastroListaMed p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update lista_medicamento set  cnpj_lab = ?, custo_uni = ?, valor_unit = ?, descricao = ? where codigo = ?");
            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getCnpj_lab());
            stmt.setString(3, p.getCusto_unit());
            stmt.setString(4, p.getValor_unit());
            stmt.setString(5, p.getDescricao());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(CadastroListaMed p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from lista_medicamento where cnpj = ?");
            stmt.setString(1, p.getCnpj_lab());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}

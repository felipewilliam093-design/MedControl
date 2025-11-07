/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.CadastroItemCompra;
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
public class ItemCompraDAO {
    public List<CadastroItemCompra> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CadastroItemCompra> itemcompra = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM item_compra");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                CadastroItemCompra ic = new CadastroItemCompra();
                ic.setCodigo(rs.getInt("codigo"));
                ic.setNum_nf_entrada_compra(rs.getInt("num_nf_entrada_compra"));
                ic.setCusto_unit(rs.getDouble("custo_unit"));
                ic.setValor_unit(rs.getDouble("valor_unit"));
                ic.setDescricao("descricao");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
    
        return itemcompra;
    }
    
    public void create(CadastroItemCompra ic){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into item_compra(codigo,  num_nf_entrada_compra, custo_unit, valor_unit, descricao) values(?, ?, ?, ?, ?)");
            stmt.setInt(1, ic.getCodigo());
            stmt.setInt(2, ic.getNum_nf_entrada_compra());
            stmt.setDouble(3, ic.getCusto_unit());
            stmt.setDouble(4, ic.getValor_unit());
            stmt.setString(5, ic.getDescricao());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(CadastroItemCompra ic){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update num_nf_entrada_compra = ?, custo_unit = ?, valor_unit = ?, descricao = ? where codigo = ?");
            stmt.setInt(1, ic.getCodigo());
            stmt.setInt(2, ic.getNum_nf_entrada_compra());
            stmt.setDouble(3, ic.getCusto_unit());
            stmt.setDouble(4, ic.getValor_unit());
            stmt.setString(5, ic.getDescricao());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(CadastroItemCompra ic){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from item_compra where codigo = ?");
            stmt.setInt(1, ic.getCodigo());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}

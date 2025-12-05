/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.CadastroItemVendas;
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
public class ItemVendaDAO {
    public List<CadastroItemVendas> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CadastroItemVendas> itemvenda = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM item_venda");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                CadastroItemVendas iv = new CadastroItemVendas();
                iv.setCodigo(rs.getInt("codigo"));
                iv.setNum_nf_entrada_venda(rs.getInt("num_nf_entrada_venda"));
                iv.setCusto_unit(rs.getDouble("custo_unit"));
                iv.setValor_unit(rs.getDouble("valor_unit"));
                iv.setDescricao("descricao");
                CadastroItemVendas p;
                itemvenda.add(iv);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
    
        return itemvenda;
    }
    
    public void create(CadastroItemVendas iv){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into item_venda(codigo,  num_nf_entrada_venda, custo_unit, valor_unit, descricao) values(?, ?, ?, ?, ?)");
            stmt.setInt(1, iv.getCodigo());
            stmt.setInt(2, iv.getNum_nf_entrada_venda());
            stmt.setDouble(3, iv.getCusto_unit());
            stmt.setDouble(4, iv.getValor_unit());
            stmt.setString(5, iv.getDescricao());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(CadastroItemVendas iv){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update num_nf_entrada_venda = ?, custo_unit = ?, valor_unit = ?, descricao = ? where codigo = ?");
            stmt.setInt(1, iv.getCodigo());
            stmt.setInt(2, iv.getNum_nf_entrada_venda());
            stmt.setDouble(3, iv.getCusto_unit());
            stmt.setDouble(4, iv.getValor_unit());
            stmt.setString(5, iv.getDescricao());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(CadastroItemVendas iv){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from item_venda where codigo = ?");
            stmt.setInt(1, iv.getCodigo());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}

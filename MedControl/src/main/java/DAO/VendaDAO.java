/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.CadastroVendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author leonardo.hpavan
 */
public class VendaDAO {
    public List<CadastroVendas> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CadastroVendas> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM venda");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                CadastroVendas p = new CadastroVendas();
                p.setNmr_nf_entrada(rs.getInt("nmr_nf_entrada"));
                p.setCnpj_drogaria(rs.getString("cnpj_drogaria"));
                p.setData_entrega(rs.getDate("data_entrega"));
                p.setValor_total(rs.getDouble("valor_total"));
                p.setCusto_total(rs.getDouble("custo_total"));
                p.setTotal_nota(rs.getDouble("total_nota"));
                p.setForma_pagamento(rs.getString("forma_pagamento"));
                p.setData_ult_venda((rs.getDate("data_ult_venda")));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
    
        return produtos;
    }
    
    public void create(CadastroVendas p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into venda(nmr_nf_entrada,cnpj_drogaria,data_entrega, custo_total, valor_total,total_nota, forma_pagamento, data_ult_venda) values(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getNmr_nf_entrada());
            stmt.setString(2, p.getCnpj_drogaria());
            stmt.setDate(3, new java.sql.Date(p.getData_entrega().getTime()));     
            stmt.setDouble(4, p.getCusto_total());
            stmt.setDouble(5, p.getValor_total());
            stmt.setDouble(6, p.getTotal_nota());
            stmt.setString(7, p.getForma_pagamento());
            stmt.setDate(8, new java.sql.Date(p.getData_ult_venda().getTime()));     
        
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(CadastroVendas p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update cnpj_drogaria = ?,data_entrega = ?, custo_total = ?, valor_total = ?,total_nota = ?, forma_pagamento = ?, data_ult_venda = ? where nmr_nf_entrada = ?");
            stmt.setInt(1, p.getNmr_nf_entrada());
            stmt.setString(2, p.getCnpj_drogaria());
            stmt.setDate(3, (java.sql.Date) p.getData_entrega());
            stmt.setDouble(4, p.getCusto_total());
            stmt.setDouble(5, p.getValor_total());
            stmt.setDouble(6, p.getTotal_nota());
            stmt.setString(7, p.getForma_pagamento());
            stmt.setDate(8, (java.sql.Date) p.getData_ult_venda());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(CadastroVendas p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from compra where nmr_nf_entrada = ?");
            stmt.setInt(1, p.getNmr_nf_entrada());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}

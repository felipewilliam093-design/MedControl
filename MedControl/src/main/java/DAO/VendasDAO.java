/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.CadastroVendas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class VendasDAO {
    public List<CadastroVendas> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CadastroVendas> vendas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM vendas");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                CadastroVendas p = new CadastroVendas();
                p.setNmr_nf_entrada(rs.getInt("nmr_nf_entrada"));
                p.setCnpj_drogaria(rs.getString("cnpj_drogaria"));
                p.setData_entrega(rs.getDate("data_entrega"));
                p.setValor_total(rs.getDouble("valor_total"));
                p.setCusto_total(rs.getDouble("custo_total"));
                p.setQtde(rs.getInt("qtde"));
                
                p.setTotal_nota(rs.getDouble("total_nota"));
                p.setForma_pagamento(rs.getString("forma_pagamento"));
                p.setData_ult_compra((rs.getDate("data_ult_compra")));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
    
        return vendas;
    }
    
    public void create(CadastroVendas p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into venda(nmr_nf_entrada,cnpj_drogaria,data_entrega, valor_total, custo_total, qtde, total_nota, forma_pagamento, data_ult_compra) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getNmr_nf_entrada());
            stmt.setString(2, p.getCnpj_drogaria());
            stmt.setDate(3, (Date) p.getData_entrega());
            stmt.setDouble(4, p.getValor_total());
            stmt.setDouble(5, p.getCusto_total());
            stmt.setInt(6, p.getQtde());
            stmt.setDouble(7, p.getTotal_nota());
            stmt.setString(8, p.getForma_pagamento());
            stmt.setDate(9, (Date) p.getData_ult_venda());
        
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar venda! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(CadastroVendas p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update cnpj_drogaria = ?,data_entrega = ?, valor_total = ?, custo_total = ?, qtde = ?, total_nota = ?, forma_pagamento = ?, data_ult_compra = ?, where nmr_nf_entrada = ?");
            stmt.setInt(1, p.getNmr_nf_entrada());
            stmt.setString(2, p.getCnpj_drogaria());
            stmt.setDate(3, (Date) p.getData_entrega());
            stmt.setDouble(4, p.getValor_total());
            stmt.setDouble(5, p.getCusto_total());
            stmt.setInt(6, p.getQtde());
            stmt.setDouble(7, p.getTotal_nota());
            stmt.setString(8, p.getForma_pagamento());
            stmt.setDate(9, (Date) p.getData_ult_venda());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar venda! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(CadastroVendas p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from venda where nmr_nf_entrada = ?");
            stmt.setInt(1, p.getNmr_nf_entrada());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Venda removida com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover venda! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}

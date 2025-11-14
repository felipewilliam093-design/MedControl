/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.CadastroCompras;
import java.sql.Connection;
import java.sql.Date;
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
public class CompraDAO {
    public List<CadastroCompras> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CadastroCompras> compras = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM compra");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                CadastroCompras p = new CadastroCompras();
                p.setNum_nf_entrada(rs.getInt("num_nf_entrada"));
                p.setCnpj_lab(rs.getString("cnpj_lab"));
                p.setData_entrada(rs.getDate("data_entrada"));
                p.setValor_total(rs.getDouble("valor_total"));
                p.setCusto_total(rs.getDouble("custo_total"));
                p.setTotal_nota(rs.getDouble("total_nota"));
                p.setForma_pagamento(rs.getString("forma_pagamento"));
                p.setData_ult_compra((rs.getDate("data_ult_compra")));
                compras.add(p);
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
    
        return compras;
    }
    
    public void create(CadastroCompras p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into compra(num_nf_entrada,cnpj_lab,data_entrada, custo_total, valor_total,total_nota, forma_pagamento, data_ult_compra) values(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getNum_nf_entrada());
            stmt.setString(2, p.getCnpj_lab());
            stmt.setDate(3, new java.sql.Date(p.getData_entrada().getTime()));
            stmt.setDouble(4, p.getCusto_total());
            stmt.setDouble(5, p.getValor_total());
            stmt.setDouble(6, p.getTotal_nota());
            stmt.setString(7, p.getForma_pagamento());
            stmt.setDate(8, new java.sql.Date(p.getData_ult_compra().getTime()));     
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(CadastroCompras p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update cnpj_lab = ?,data_entrada = ?, custo_total = ?, valor_total = ?,total_nota = ?, forma_pagamento = ?, data_ult_compra = ? where num_nf_entrada = ?");
            stmt.setInt(1, p.getNum_nf_entrada());
            stmt.setString(2, p.getCnpj_lab());
            stmt.setDate(3, (Date) p.getData_entrada());
            stmt.setDouble(4, p.getCusto_total());
            stmt.setDouble(5, p.getValor_total());
            stmt.setDouble(6, p.getTotal_nota());
            stmt.setString(7, p.getForma_pagamento());
            stmt.setDate(8, (Date) p.getData_ult_compra());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(CadastroCompras p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from compra where num_nf_entrada = ?");
            stmt.setInt(1, p.getNum_nf_entrada());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}

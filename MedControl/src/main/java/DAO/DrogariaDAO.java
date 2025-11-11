/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.Drogaria;
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
public class DrogariaDAO {
    public List<Drogaria> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Drogaria> drogarias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM drogaria");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Drogaria p = new Drogaria();
                p.setCnpj(rs.getString("cnpj"));
                p.setNome(rs.getString("Nome"));
                p.setCep(rs.getString("CEP"));
                p.setEstado(rs.getString("Estado"));
                p.setCidade(rs.getString("Cidade"));
                p.setBairro(rs.getString("Bairro"));
                p.setRua(rs.getString("Rua"));
                p.setNumero(rs.getInt("Numero"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
    
        return drogarias;
    }
    
    public void create(Drogaria p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into drogaria(cnpj,Nome, CEP, Estado, Cidade, Bairro, Rua, Numero) values(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getCnpj());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getCep());
            stmt.setString(4, p.getEstado());
            stmt.setString(5, p.getCidade());
            stmt.setString(6, p.getBairro());
            stmt.setString(7, p.getRua());
            stmt.setInt(8, p.getNumero());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(Drogaria p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update drogaria set  Nome = ?, CEP = ?, Estado = ?, Cidade = ?, Bairro = ?, Rua = ?, Numero = ? where cnpj = ?");
            stmt.setString(1, p.getCnpj());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getCep());
            stmt.setString(4, p.getEstado());
            stmt.setString(5, p.getCidade());
            stmt.setString(6, p.getBairro());
            stmt.setString(7, p.getRua());
            stmt.setInt(8, p.getNumero());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(Drogaria p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from drogaria where cnpj = ?");
            stmt.setString(1, p.getCnpj());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
}

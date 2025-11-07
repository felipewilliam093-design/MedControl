/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.Cadastro;
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
public class LaboratorioDAO {
    public List<Cadastro> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cadastro> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM laboratorio_fornecedor");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cadastro p = new Cadastro();
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
    
        return produtos;
    }
    
    public void create(Cadastro p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into laboratorio_fornecedor(cnpj,Nome, CEP, Estado, Cidade, Bairro, Rua, Numero) values(?, ?, ?, ?, ?, ?, ?, ?)");
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
    
    public void update(Cadastro p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update laboratorio_fornecedor set  Nome = ?, CEP = ?, Estado = ?, Cidade = ?, Bairro = ?, Rua = ?, Numero = ? where cnpj = ?");
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
    
    public void delete(Cadastro p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from laboratorio_fornecedor where cnpj = ?");
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

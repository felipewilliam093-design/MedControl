/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import BD.Conexao;
import Objetos.Laboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LaboratorioDAO {
    public List<Laboratorio> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Laboratorio> cadastros = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM laboratorio_fornecedor");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Laboratorio p = new Laboratorio();
                p.setCnpj(rs.getString("cnpj"));
                p.setIE(rs.getString("IE"));
                p.setNome(rs.getString("Nome"));
                p.setCep(rs.getString("CEP"));
                p.setEstado(rs.getString("Estado"));
                p.setCidade(rs.getString("Cidade"));
                p.setBairro(rs.getString("Bairro"));
                p.setRua(rs.getString("Rua"));
                p.setNumero(rs.getInt("Numero"));
                cadastros.add(p);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
    
        return cadastros;
    }
    
    public void create(Laboratorio p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into laboratorio_fornecedor(cnpj, IE, Nome, CEP, Estado, Cidade, Bairro, Rua, Numero) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getCnpj());
            stmt.setString(2, p.getIE());
            stmt.setString(3, p.getNome());
            stmt.setString(4, p.getCep());
            stmt.setString(5, p.getEstado());
            stmt.setString(6, p.getCidade());
            stmt.setString(7, p.getBairro());
            stmt.setString(8, p.getRua());
            stmt.setInt(9, p.getNumero());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(Laboratorio p){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update laboratorio_fornecedor set Cnpj= ?, IE = ?, Nome = ?, CEP = ?, Estado = ?, Cidade = ?, Bairro = ?, Rua = ?, Numero = ? where cnpj = ?");
            stmt.setString(1, p.getCnpj());
            stmt.setString(2, p.getIE());
            stmt.setString(3, p.getNome());
            stmt.setString(4, p.getCep());
            stmt.setString(5, p.getEstado());
            stmt.setString(6, p.getCidade());
            stmt.setString(7, p.getBairro());
            stmt.setString(8, p.getRua());
            stmt.setInt(9, p.getNumero());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(Laboratorio p){
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

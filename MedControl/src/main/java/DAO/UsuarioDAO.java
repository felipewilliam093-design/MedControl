/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import BD.Conexao;
import Objetos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author william.flima4
 */
public class UsuarioDAO {
    public List<Usuario> read(){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_usuarios");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setTipo(rs.getString("tipo"));
                usuarios.add(u);
                
                usuarios.add(u);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
    
        return usuarios;
    }
    
    public void create(Usuario u){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into tbl_usuarios(nome, login, senha, tipo) values (?, ?, ?, ?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenhaHash());
            stmt.setString(4, u.getTipo());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(Usuario u){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update tbl_usuarios set nome = ?, login = ?, senha = ?, tipo = ? where id = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getLogin());
            stmt.setString(3, u.getSenhaHash());
            stmt.setString(3, u.getTipo());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar usuário! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void delete(Usuario u){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("delete from tbl_usuarios where id = ?");
            stmt.setInt(1, u.getId());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover usuário! " + e);
        }finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public Usuario verificaUsuario (String login){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_usuarios");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setTipo(rs.getString("tipo"));
                
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author giovani
 */
public class UsuarioDAO {
    
    // Insere um usuário no banco.
    public void create(Usuario usuario) {
        
        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO usuarios (nome, cpf, dataNascimento, sexo, cargos_nome)VALUES(?,?,?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getDataNascimento());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.cargo.getNomeCargo());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }

    }

    // Lê os dados no banco e os retorna como vetor.
    public ArrayList<Usuario> read() {

        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM usuarios");
            rs = stmt.executeQuery();

            while (rs.next()) { // Enquanto existir um valor, passa para o próximo.

                Usuario usuario = new Usuario();

                //nome, cpf, dataNascimento, sexo, cargos_nome
                usuario.setNome(rs.getString("nome"));
                usuario.setDataNascimento(rs.getString("dataNascimento"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.cargo.setNomeCargo(rs.getString("cargos_nome"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }

        return usuarios;

    }
    
    
    // Edita os atributos do usuário no banco.
    public void update(Usuario usuario) {

        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE usuarios SET nome = ? ,dataNascimento = ?,sexo = ?,cargos_nome = ? ,cpf = ? WHERE cpf = ?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getDataNascimento());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.cargo.getNomeCargo());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }

    }
    
    // Deleta um usuário do banco.
    public void delete(Usuario usuario) {

        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM usuarios WHERE cpf = ?");
            stmt.setString(2, usuario.getCpf());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }
    }
}

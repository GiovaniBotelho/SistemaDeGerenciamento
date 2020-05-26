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
import model.bean.Perfil;

/**
 *
 * @author giovani
 */
public class PerfilDAO {
    
     // Insere um perfil no banco.
    public void create(Perfil perfil) {
        
        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO perfis (nome)VALUES(?)");
            stmt.setString(1, perfil.getNomePerfil());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }

    }

    // Lê os dados no banco e os retorna como vetor.
    public ArrayList<Perfil> read() {

        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Perfil> perfis = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM perfis");
            rs = stmt.executeQuery();

            while (rs.next()) { // Enquanto existir um valor, passa para o próximo.

                Perfil perfil = new Perfil();

                perfil.setNomePerfil(rs.getString("nome"));
                perfis.add(perfil);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PerfilDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }

        return perfis;

    }
    
    // Edita o nome do perfil no banco.    
    public void update(Perfil perfil) {

        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE perfis SET nome = ? WHERE nome = ?");
            stmt.setString(1, perfil.getNomePerfil());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }

    }
    
    // Deleta um usuário do banco.
    public void delete(Perfil perfil) {

        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM perfis WHERE nome = ?");
            stmt.setString(1, perfil.getNomePerfil());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }

    }
}

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
import model.bean.Cargo;

/**
 *
 * @author giovani
 */
public class CargoDAO {
    
    // Insere um cargo no banco.
    public void create(Cargo cargo) {
        
        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO cargos (nome)VALUES(?)");
            stmt.setString(1, cargo.getNomeCargo());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }

    }

    // Lê os dados no banco e os retorna como vetor.
    public ArrayList<Cargo> read() {

        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Cargo> cargos = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM cargos");
            rs = stmt.executeQuery();

            while (rs.next()) { // Enquanto existir um valor, passa para o próximo.

                Cargo cargo = new Cargo();

                cargo.setNomeCargo(rs.getString("nome"));
                cargos.add(cargo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CargoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }

        return cargos;

    }
    
    // Edita o nome do cargo no banco.    
    public void update(Cargo cargo) {

        Connection conexao = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE cargos SET nome = ? WHERE nome = ?");
            stmt.setString(1, cargo.getNomeCargo());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt);
        }

    }
}

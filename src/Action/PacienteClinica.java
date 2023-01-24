/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Action;

/**
 *
 * @author lubin.lionel
 */

import model.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import Interface_grafica.DashboardLoginTela;


public class PacienteClinica extends GenericMetodo {

    public void salvar(Paciente paciente) throws SQLException {
        String insert = "INSERT INTO paciente(cpf, nome, sobrenome, endereco, data_de_nasc) VALUES(?,?,?,?,?)";
        save(insert, paciente.getCpf(), paciente.getNome(), paciente.getSobrenome(), 
                paciente.getEndereco(), paciente.getData_de_nasc() );
    }

    public void alterar(Paciente paciente) throws SQLException {
        String update = "UPDATE paciente SET cpf =?, nome = ?, sobrenome = ?, endereco=?, data_de_nasc = ? WHERE cpf = ?";
        update(update, paciente.getCpf(), paciente.getNome(), paciente.getSobrenome(), 
                paciente.getEndereco(), paciente.getData_de_nasc());
    }


    public void excluir(String cpf) throws SQLException {
        String delete = "DELETE FROM paciente WHERE cpf = ?";
            delete(delete, cpf);
        
    }


    public Paciente buscar_por_cpf(String cpf) throws SQLException {
        String select = "SELECT cpf, nome, sobrenome, endereco, data_de_nasc FROM paciente WHERE cpf = ?";
        Paciente paciente = null;
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setString(1, cpf);
        
        
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Paciente com os dados seguintes:   "+ "CPF: "+rs.getString(1) +" | "+ "Nome: "+rs.getString(2)+" | " + "Sobrenome: "+rs.getString(3)+" | "+"Endereço: " + rs.getString(4)+" | "+"Data De Nasc: "+ rs.getString(5) );
            DashboardLoginTela dash = new DashboardLoginTela();
            dash.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, " Desculpa nao existe paciente com esse CPF !");
        }

        while (rs.next()) {
            
            paciente = new Paciente();
            paciente.setCpf(rs.getString("cpf"));
            paciente.setNome(rs.getString("nome"));
            paciente.setSobrenome(rs.getString("sobrenome"));
            paciente.setEndereco(rs.getString("endereco"));
            paciente.setData_de_nasc(rs.getString("data_de_nasc"));
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return paciente;
    }
}

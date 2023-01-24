package controller;

import java.sql.SQLException;
import java.text.ParseException;

import model.Medico;



public class MedicoController {
    public void salvar(String id, String senha, String email) 
		throws SQLException, ParseException 
	{
        Medico medico = new Medico();
        medico.setId(id);
        medico.setSenha(senha);
        medico.setEmail(email);
        

        new Action.Medico().salvar(medico);
    }
}

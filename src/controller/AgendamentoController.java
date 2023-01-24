package controller;

import model.Agendamento;
import Action.AgendaPaciente;
import java.sql.SQLException;
import java.text.ParseException;


public class AgendamentoController {

    public void salvar(String cpf, String data_agendamento, String status, String observacao) 
		throws SQLException, ParseException 
	{
        Agendamento agendamento = new Agendamento();
        agendamento.setCpf(cpf);
        agendamento.setData_agendamento(data_agendamento);
        agendamento.setStatus(status);
        agendamento.setObservacao(observacao);

        new AgendaPaciente().salvar(agendamento);
    }

    public Agendamento buscaPorcpf(String cpf) throws SQLException {
        AgendaPaciente agendamento = new AgendaPaciente();
        return agendamento.buscar_por_cpf(cpf);
    }


}

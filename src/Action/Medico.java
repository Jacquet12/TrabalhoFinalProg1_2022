package Action;


import java.sql.SQLException;

/**
 *
 * @author lubin.lionel
 */
public class Medico extends GenericMetodo {

    public void salvar(model.Medico medico) throws SQLException {
        String insert = "INSERT INTO medico(id, senha, email) VALUES(?,?,?)";
        save(insert, medico.getId(),medico.getSenha(), medico.getEmail());
    }
}

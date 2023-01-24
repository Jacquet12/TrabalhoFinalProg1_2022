/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Action;

/**
 *
 * @author lubin.lionel
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericMetodo {
    private Connection connection;

    protected GenericMetodo () {
        this.connection = Conexao.getConnection();
    }

    protected Connection getConnection() {
        return connection;
    }

    protected void save(String insertSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt = 
			getConnection().prepareStatement(insertSql);

        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
        connection.close();
    }

    protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
        PreparedStatement pstmt = 
		getConnection().prepareStatement(updateSql);
			
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }
        pstmt.setObject(parametros.length + 1, id);
        pstmt.execute();
        pstmt.close();
        connection.close();
    }

    protected void delete(String deleteSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt = 
		getConnection().prepareStatement(deleteSql);
			
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i+1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
        connection.close();
    }
}
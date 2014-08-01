package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gian
 */
public class Conexao {
    static Connection conexao;
    
    public Conexao() {
        conexao = null;
    }
    
    public Connection conectar() throws Exception {
        try {
            Class.forName("org.postgresql.Driver"); // nome do driver
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projetosd","postgres", "masterkey");            
            return conexao;
        } catch (ClassNotFoundException ex) {
            throw new Exception("Erro na localização do driver!\n(" + ex.getMessage() + ")");
        } catch (SQLException sqle) {
            throw new Exception("Erro na conexão!\n(" + sqle.getMessage() + ")");
        }
    }
    
    public void desconectar() throws Exception {
        try {
            conexao.close();
        } catch(SQLException e) {
            throw new Exception("Erro ao desconectar! Mensagem: "+e.getMessage());
        }        
    }
}

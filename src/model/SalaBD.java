package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleberson
 */
public class SalaBD {

    Conexao conexao;
    Connection con;

    public SalaBD() {
        try {
            conexao = new Conexao();
            con = conexao.conectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertSala(SalaVO salavo) throws Exception {
        try {
            Statement stmt = con.createStatement();
            String query = "INSERT INTO sala("
                    + "descricao"
                    + ", num_computadores"
                    + ", recursos_didaticos"
                    + ", departamento"
                    + ", capacidade_alunos)"
                    + "    VALUES (\'" + salavo.getDescricao() + "\'"
                    + "," + salavo.getNum_computadores()
                    + ",\'" + salavo.getRecursos_didaticos() + "\'"
                    + ",\'" + salavo.getDepartamento() + "\'"
                    + "," + salavo.getCapacidade_alunos()
                    + ");";
            System.err.println(query);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void alterarSala(SalaVO salaVO) throws Exception {
        try {
            Statement stm = con.createStatement();
            String query = "UPDATE sala"
                    + " SET descricao = '" + salaVO.getDescricao() + "'"
                    + ", num_computadores = " + salaVO.getNum_computadores()
                    + ", recursos_didaticos = '" + salaVO.getRecursos_didaticos() + "'"
                    + ", departamento = '" + salaVO.getDepartamento() + "'"
                    + ", capacidade_alunos =" + salaVO.getCapacidade_alunos()
                    + "  WHERE  sala_id =" + salaVO.getSala_id();
            System.out.println(query);
            stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void deletarSala(SalaVO salaVO) throws Exception {
        try {
            Statement stm = con.createStatement();
            String query = "DELETE FROM sala"
                    + " WHERE  sala_id =" + salaVO.getSala_id();
            System.out.println(query);
            stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
    
    public void consultarSala(SalaVO salavo) throws Exception {
        try {
            Statement stm = con.createStatement();
            ResultSet rs;
            String query = "SELECT sala_id, descricao, num_computadores, recursos_didaticos, departamento, "+
                    "capacidade_alunos FROM sala WHERE 1=1";
            
            if(salavo.getSala_id() != 0) {
                query += " and sala_id = "+salavo.getSala_id();
            }
            if(salavo.getRecursos_didaticos() != null) {
                query += " and recursos_didaticos = '"+salavo.getRecursos_didaticos()+"'";
            }
            if(salavo.getNum_computadores() != 0) {
                query += " and num_computadores = "+salavo.getNum_computadores();
            }
            if(salavo.getDescricao() != null) {
                query += " and descricao = '"+salavo.getDescricao()+"'";
            }
            if(salavo.getDepartamento() != null) {
                query += " and departamento = '"+salavo.getDepartamento()+"'";
            }
            if(salavo.getCapacidade_alunos() != 0) {
                query += "and capacidade_alunos = "+salavo.getCapacidade_alunos();
            }            
            System.out.println(query);
            
            //stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
}

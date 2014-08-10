/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class AulaBD {
    Conexao conexao;
    Connection con;

    public AulaBD() {
        try {
            conexao = new Conexao();
            con = conexao.conectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertAula(AulaVO aulavo) throws Exception {
        try {
            Statement stmt = con.createStatement();
            String query = "INSERT INTO aula("
                    + "disciplina_associada"
                    + ", sala_aula_associada"
                    + ", conteudo_programatico"
                    + ", alunos_presentes)"
                    + "    VALUES (\'" + aulavo.getDisciplina_associada() + "\'"
                    + "," + aulavo.getSala_aula_associada()
                    + ",\'" + aulavo.getConteudo_programatico() + "\'"
                    + ",\'" + aulavo.getAlunos_presentes() + "\'"
                    + ");";
            System.err.println(query);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void alterarAula(AulaVO aulavo) throws Exception {
        try {
            Statement stm = con.createStatement();
            String query = "UPDATE aula"
                    + " SET disciplina_associada = '" + aulavo.getDisciplina_associada() + "'"
                    + ", sala_aula_associada = " + aulavo.getSala_aula_associada()
                    + ", conteudo_programatico = '" + aulavo.getConteudo_programatico() + "'"
                    + ", alunos_presentes = '" + aulavo.getAlunos_presentes() + "'"
                    + "  WHERE  aula_id =" + aulavo.getAula_id();
            System.out.println(query);
            stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void deletarAula(AulaVO aulavo) throws Exception {
        try {
            Statement stm = con.createStatement();
            String query = "DELETE FROM aula"
                    + " WHERE  aula_id =" + aulavo.getAula_id();
            System.out.println(query);
            stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
    
    public void consultarAula(int disciplina) throws Exception {
        try {
            Statement stm = con.createStatement();
            ResultSet rs;
            String query = "SELECT aula_id, disciplina_associada, sala_aula_associada, conteudo_programatico, alunos_presentes, "+
                    " FROM aula WHERE disciplina_associada = '"+disciplina+"' ";
            
            /*if(aulavo.getAula_id() != 0) {
                query += " and aula_id = "+aulavo.getAula_id();
            }
            if(aulavo.getDisciplina_associada() != 0) {
                query += " and disciplina_associada = '"+aulavo.getDisciplina_associada()+"'";
            }
            if(aulavo.getSala_aula_associada() != 0) {
                query += " and sala_aula_associada = "+aulavo.getSala_aula_associada();
            }
            if(aulavo.getConteudo_programatico() != null) {
                query += " and conteudo_programatico = '"+aulavo.getConteudo_programatico()+"'";
            }
            if(aulavo.getAlunos_presentes() != null) {
                query += " and alunos_presentes = '"+aulavo.getAlunos_presentes()+"'";
            }*/
            System.out.println(query);
            
            //stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
}

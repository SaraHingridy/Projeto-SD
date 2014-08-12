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
public class AulaBD{
    Conexao conexao;
    Connection con;

    public AulaBD(){
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
    
    public void consultarAula(AulaVO aulavo) throws Exception {
        try {
            Statement stm = con.createStatement();
            ResultSet rs;
            String query = "SELECT aula_id, disciplina_associada, sala_aula_associada, conteudo_programatico, alunos_presentes "+
                    " FROM aula WHERE disciplina_associada = '"+aulavo.getDisciplina_associada()+"' ";
            
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
    
    public void preencherAula(AulaVO aulavo) throws Exception {
        try {
            Statement stm = con.createStatement();
            ResultSet rs;
            String query = "SELECT disciplina_id, titulo "+
                    " FROM disciplina ";
            
           rs = stm.executeQuery(query);
           int i = 0;
           while(rs.next()){
               int disciplina_id = rs.getInt("disciplina_id");
               String titulo = rs.getString("titulo");
               int[] array_disciplina = new int[10];
               String[] array_titulo = new String[10];
               array_disciplina[i] = disciplina_id;
               array_titulo[i] = titulo;
               aulavo.setDisciplina_associada(array_disciplina);
               aulavo.setTitulo(array_titulo);
               i++;
           }
           
           String query2 = "SELECT sala_id "+
                    " FROM sala ";
            
           rs = stm.executeQuery(query);
           int j = 0;
           while(rs.next()){
               int sala_id = rs.getInt("sala_id");
               int[] array_sala = new int[10];
               array_sala[j] = sala_id;
               aulavo.setSala_aula_associada(array_sala);
               j++;
           }
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
}

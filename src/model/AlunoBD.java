/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author Rauch
 */
public class AlunoBD {
    
    Conexao conexao;
    Connection con;
    
    public AlunoBD() {
        try {
            conexao = new Conexao();
            con = conexao.conectar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void insertAluno(AlunoVO alunovo) throws Exception {
        try {
            Statement stmt = con.createStatement();
            String query = "INSERT INTO aluno("
                    + ", nome"
                    + ", idade"
                    + ", endereco"
                    + ", curso"
                    + ", disciplinas_matriculas"
                    + ", ano_entrada_curso)"
                    + "    VALUES (" + alunovo.getRA() 
                    + ",\'" + alunovo.getNome() + "\'"
                    + "," + alunovo.getIdade()
                    + ",\'" + alunovo.getRua() + "\'"
                    + ",\'" + alunovo.getNumero() + "\'"
                    + ",\'" + alunovo.getBairro() + "\'"
                    + ",\'" + alunovo.getCep() + "\'"
                    + ",\'" + alunovo.getCidade() + "\'"
                    + ",\'" + alunovo.getUf() + "\'"
                    + ",\'" + alunovo.getCurso() + "\'"
                    + ",\'" + alunovo.getDisciplinas_matriculadas() + ",\'"
                    + "," + alunovo.getAno_entrada_curso()
                    + ");";
            System.err.println(query);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
    
    public void alterarAluno(AlunoVO alunoVO) throws Exception {
        try {
            Statement stm = con.createStatement();
            String query = "UPDATE aluno"
                  + " SET nome = \'" + alunoVO.getNome() + "\'"
                    + ", idade = " + alunoVO.getIdade()
                    + ", endereco = \'" + alunoVO.getRua() + "\'"
                    + ", endereco = \'" + alunoVO.getNumero() + "\'"
                    + ", endereco = \'" + alunoVO.getBairro() + "\'"
                    + ", endereco = \'" + alunoVO.getCep() + "\'"
                    + ", endereco = \'" + alunoVO.getCidade() + "\'"
                    + ", endereco = \'" + alunoVO.getUf() + "\'"
                    + ", curso = \'" + alunoVO.getCurso() + "\'"
                    + ", disciplinas_matriculas = \'" + alunoVO.getDisciplinas_matriculadas() + "\'"
                    + ", ano_entrada_curso = " + alunoVO.getAno_entrada_curso()
                    + "  WHERE  RA =" + alunoVO.getRA();
            System.out.println(query);
            stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
    
    public void deletarAluno(AlunoVO alunoVO) throws Exception {
        try {
            Statement stm = con.createStatement();
            String query = "DELETE FROM aluno"
                    + " WHERE  RA =" + alunoVO.getRA();
            System.out.println(query);
            stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
    
    public void consultarAluno(AlunoVO alunovo) throws Exception {
        try {
            Statement stm = con.createStatement();
            ResultSet rs;
            String query = "SELECT  RA, nome, idade, endereco,curso "+
                    "ano_entrada_curso FROM aluno WHERE 1=1";
            
            if(alunovo.getRA() != 0) {
                query += " and RA = "+alunovo.getRA();
            }
            if(alunovo.getNome() != null) {
                query += " and nome = \'"+alunovo.getNome()+"\'";
            }
            if(alunovo.getIdade() != 0) {
                query += " and idade = "+alunovo.getIdade();
            }
            if(alunovo.getRua() != null) {
                query += " and endereco = \'"+alunovo.getRua()+"\'";
            }
            if(alunovo.getNumero() != null) {
                query += " and endereco = \'"+alunovo.getNumero()+"\'";
            }
            if(alunovo.getBairro() != null) {
                query += " and endereco = \'"+alunovo.getBairro()+"\'";
            }
            if(alunovo.getCep() != null) {
                query += " and endereco = \'"+alunovo.getCep()+"\'";
            }
            if(alunovo.getCidade() != null) {
                query += " and endereco = \'"+alunovo.getCidade()+"\'";
            }
            if(alunovo.getUf() != null) {
                query += " and endereco = \'"+alunovo.getUf()+"\'";
            }
            if(alunovo.getCurso() != null) {
                query += " and curso = \'"+alunovo.getCurso()+"\'";
            }
            if(alunovo.getDisciplinas_matriculadas() != null){
                query += "and disciplinas_matriculas = \'"+alunovo.getDisciplinas_matriculadas()+"\'";
            }
            if(alunovo.getAno_entrada_curso() != 0) {
                query += "and ano_entrada_curso = "+alunovo.getAno_entrada_curso();
            }              
            System.out.println(query);
            
            //stm.executeUpdate(query);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
}

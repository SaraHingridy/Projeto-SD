/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testes;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.AlunoVO;
import model.AlunoBD;

/**
 *
 * @author Rauch
 */
public class testeAluno {

    public testeAluno() {
       
    }
    
    public static void main(String[] args) {
       AlunoVO aluno = new AlunoVO();
        AlunoBD bd = new AlunoBD();
        
        aluno.setNome("thamirys");
        aluno.setRA(12345);
        aluno.setIdade(21);
        aluno.setEndereco("rua teste");
        aluno.setCurso("computacao");
        aluno.setAno_entrada_curso(2009);
        
        try {
            bd.insertAluno(aluno);
        } catch (Exception ex) {
            System.out.println("deu ruim");
            Logger.getLogger(testeAluno.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}

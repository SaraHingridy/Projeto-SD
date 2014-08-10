/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rafael
 */
public class AulaVO {
    public int aula_id;
    public int disciplina_associada;
    public int sala_aula_associada;
    public String conteudo_programatico;
    public String[] alunos_presentes;

    public int getAula_id() {
        return aula_id;
    }

    public void setAula_id(int aula_id) {
        this.aula_id = aula_id;
    }

    public int getDisciplina_associada() {
        return disciplina_associada;
    }

    public void setDisciplina_associada(int disciplina_associada) {
        this.disciplina_associada = disciplina_associada;
    }

    public int getSala_aula_associada() {
        return sala_aula_associada;
    }

    public void setSala_aula_associada(int sala_aula_associada) {
        this.sala_aula_associada = sala_aula_associada;
    }

    public String getConteudo_programatico() {
        return conteudo_programatico;
    }

    public void setConteudo_programatico(String conteudo_programatico) {
        this.conteudo_programatico = conteudo_programatico;
    }

    public String[] getAlunos_presentes() {
        return alunos_presentes;
    }

    public void setAlunos_presentes(String[] alunos_presentes) {
        this.alunos_presentes = alunos_presentes;
    }
}

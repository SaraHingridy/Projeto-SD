/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Rauch
 */
public class AlunoVO {
    private int aluno_id;
    private int RA;
    private String nome;
    private int idade;
    private String endereco;
    private String curso;
    private int ano_entrada_curso;

    /**
     * @return the aluno_id
     */
    public int getAluno_id() {
        return aluno_id;
    }

    /**
     * @param aluno_id the aluno_id to set
     */
    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    /**
     * @return the RA
     */
    public int getRA() {
        return RA;
    }

    /**
     * @param RA the RA to set
     */
    public void setRA(int RA) {
        this.RA = RA;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the ano_entrada_curso
     */
    public int getAno_entrada_curso() {
        return ano_entrada_curso;
    }

    /**
     * @param ano_entrada_curso the ano_entrada_curso to set
     */
    public void setAno_entrada_curso(int ano_entrada_curso) {
        this.ano_entrada_curso = ano_entrada_curso;
    }
}



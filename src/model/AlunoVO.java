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
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String curso;
    private int ano_entrada_curso;
    private String disciplinas_matriculadas;

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

    /**
     * @return the disciplinas_matriculadas
     */
    public String getDisciplinas_matriculadas() {
        return disciplinas_matriculadas;
    }

    /**
     * @param disciplinas_matriculadas the disciplinas_matriculadas to set
     */
    public void setDisciplinas_matriculadas(String disciplinas_matriculadas) {
        this.disciplinas_matriculadas = disciplinas_matriculadas;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Cleberson
 */
public class SalaVO {
    private int sala_id;
    private String descricao;
    private int num_computadores;
    private String recursos_didaticos;
    private String departamento;
    private int capacidade_alunos;

    /**
     * @return the sala_id
     */
    public int getSala_id() {
        return sala_id;
    }

    /**
     * @param sala_id the sala_id to set
     */
    public void setSala_id(int sala_id) {
        this.sala_id = sala_id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the num_computadores
     */
    public int getNum_computadores() {
        return num_computadores;
    }

    /**
     * @param num_computadores the num_computadores to set
     */
    public void setNum_computadores(int num_computadores) {
        this.num_computadores = num_computadores;
    }

    /**
     * @return the recursos_didaticos
     */
    public String getRecursos_didaticos() {
        return recursos_didaticos;
    }

    /**
     * @param recursos_didaticos the recursos_didaticos to set
     */
    public void setRecursos_didaticos(String recursos_didaticos) {
        this.recursos_didaticos = recursos_didaticos;
    }

    /**
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the capacidade_alunos
     */
    public int getCapacidade_alunos() {
        return capacidade_alunos;
    }

    /**
     * @param capacidade_alunos the capacidade_alunos to set
     */
    public void setCapacidade_alunos(int capacidade_alunos) {
        this.capacidade_alunos = capacidade_alunos;
    }
    
}

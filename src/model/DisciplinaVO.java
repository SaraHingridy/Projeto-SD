package model;

/**
 *
 * @author Gian
 */
public class DisciplinaVO {
    private int disciplina_id;
    private String titulo;
    private String metodo_avaliacao;
    private String ementa;
    private String pre_requisito;
    private String dependencia;

    /**
     * @return the disciplina_id
     */
    public int getDisciplina_id() {
        return disciplina_id;
    }

    /**
     * @param disciplina_id the disciplina_id to set
     */
    public void setDisciplina_id(int disciplina_id) {
        this.disciplina_id = disciplina_id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the metodo_avaliacao
     */
    public String getMetodo_avaliacao() {
        return metodo_avaliacao;
    }

    /**
     * @param metodo_avaliacao the metodo_avaliacao to set
     */
    public void setMetodo_avaliacao(String metodo_avaliacao) {
        this.metodo_avaliacao = metodo_avaliacao;
    }

    /**
     * @return the ementa
     */
    public String getEmenta() {
        return ementa;
    }

    /**
     * @param ementa the ementa to set
     */
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    /**
     * @return the pre_requisito
     */
    public String getPre_requisito() {
        return pre_requisito;
    }

    /**
     * @param pre_requisito the pre_requisito to set
     */
    public void setPre_requisito(String pre_requisito) {
        this.pre_requisito = pre_requisito;
    }

    /**
     * @return the dependencia
     */
    public String getDependencia() {
        return dependencia;
    }

    /**
     * @param dependencia the dependencia to set
     */
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
    
}

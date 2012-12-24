/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dto;

/**
 *
 * @author itakenami
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="projetos")
@XmlRootElement(name = "projeto")
public class Projeto  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_fim;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_inicio;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="analistas_projetos", joinColumns={@JoinColumn(name="projeto_id")}, inverseJoinColumns={@JoinColumn(name="analista_id")})
    private Set<Analista> analistas;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
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
     * @return the data_fim
     */
    public Date getData_fim() {
        return data_fim;
    }

    /**
     * @param data_fim the data_fim to set
     */
    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    /**
     * @return the data_inicio
     */
    public Date getData_inicio() {
        return data_inicio;
    }

    /**
     * @param data_inicio the data_inicio to set
     */
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    /**
     * @return the analistas
     */
    public Set<Analista> getAnalistas() {
        return analistas;
    }

    /**
     * @param analistas the analistas to set
     */
    public void setAnalistas(Set<Analista> analistas) {
        this.analistas = analistas;
    }


}

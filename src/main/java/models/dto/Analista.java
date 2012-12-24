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
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name="analistas")
@XmlRootElement(name = "analista")
public class Analista implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String especialidade;

    @ManyToOne
    @JoinColumn(name ="cargo_id")
    private Cargo cargo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}


package br.com.seteideias.repository.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Empresa")
public class Empresa implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "razao_social")
    private String razaoSocial;


}

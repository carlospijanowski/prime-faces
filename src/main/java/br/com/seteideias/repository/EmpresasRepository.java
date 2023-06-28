package br.com.seteideias.repository;

import br.com.seteideias.repository.dto.Empresa;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class EmpresasRepository implements Serializable {
    public static final long serialVersionUID = 1L;

    private EntityManager manager;

    public Empresa procuraPorEmpresa (Long id){
        return manager.find(Empresa.class, id);
    }

}

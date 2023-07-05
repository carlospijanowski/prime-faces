package br.com.seteideias.repository;

import br.com.seteideias.repository.entity.RamoAtividade;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class RamoAtividadesRepository implements Serializable {
    public static final long serialVersionUID = 1L;

    private EntityManager manager;

    public RamoAtividadesRepository() {
    }

    public RamoAtividadesRepository(EntityManager manager) {
        this.manager = manager;
    }

//    public Empresa porId(String id) {
//        return manager.find(Empresa.class, id);
//    }

    public List<RamoAtividade> pesquisar(String descricao) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
        Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));
        TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

//
//    public Empresa guardar(Empresa empresa) {
//        return manager.merge(empresa);
//    }
//
//    public void remover(Empresa empresa){
//        Empresa porId = porId(empresa.getId().toString());
//        if(Objects.nonNull(porId)){
//            manager.remove(porId);
//        }
}

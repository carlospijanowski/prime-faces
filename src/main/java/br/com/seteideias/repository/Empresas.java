package br.com.seteideias.repository;

import br.com.seteideias.repository.entity.Empresa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresas implements Serializable {
    public static final long serialVersionUID = 1L;

//    @Inject
    private EntityManager manager;

    public Empresas() {
    }

    public Empresas(EntityManager manager) {
        this.manager = manager;
    }

    public Empresa porId(String id) {
        return manager.find(Empresa.class, id);
    }

    public List<Empresa> pesquisar(String nome) {
        String jpql = "from Empresa where nomeFantasia like: nomeFantasia";
        TypedQuery<Empresa> query = manager.createQuery(jpql, Empresa.class);
        query.setParameter("nomeFantasia", nome + "%");
        return query.getResultList();
    }

    public List<Empresa> todasAsEmpresas() {
        List<Empresa> resultList;
        try {
            resultList = manager.createQuery("from empresa", Empresa.class).getResultList();
        } catch (Exception e) {
            resultList = getEmpresasEmCasoDeErroNaConsultaAoBanco();
        }
        return resultList;
    }

    private static List<Empresa> getEmpresasEmCasoDeErroNaConsultaAoBanco() {
        List<Empresa> resultList;
        Empresa empresa = new Empresa();
        empresa.setId(1L);
        empresa.setRazaoSocial("Razao Social QUERY NAO FUNFANDO ARRUME!");
        empresa.setNomeFantasia("7 ideias QUERY NAO FUNFANDO ARRUME!");

        Empresa empresa2 = new Empresa();
        empresa2.setId(1L);
        empresa2.setRazaoSocial("Razao Social 22222222222 QUERY NAO FUNFANDO ARRUME!");
        empresa2.setNomeFantasia("7 ideias 222222222 QUERY NAO FUNFANDO ARRUME!");

        List<Empresa> list = new ArrayList<>();
        list.add(empresa);
        list.add(empresa2);
        resultList = list;
        return resultList;
    }

    public Empresa guardar(Empresa empresa) {
        return manager.merge(empresa);
    }

    public void remover(Empresa empresa) {
        Empresa porId = porId(empresa.getId().toString());
        if (Objects.nonNull(porId)) {
            manager.remove(porId);
        }
    }

}

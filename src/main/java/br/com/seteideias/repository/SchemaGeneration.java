package br.com.seteideias.repository;

import br.com.seteideias.repository.entity.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

import static br.com.seteideias.util.StringUtils.PERSISTENCE_UNIT_NAME;

public class SchemaGeneration {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        EntityManager em = emf.createEntityManager();

        List<Empresa> lista = em.createQuery("from Empresa", Empresa.class)
                .getResultList();

        System.out.println(lista);

        em.close();
        emf.close();
    }

}

package br.com.seteideias;

import br.com.seteideias.repository.entity.Teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static br.com.seteideias.utils.StringUtils.PERSISTENCE_UNIT_NAME;

public class SchemaGeneration {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Teste> result =    entityManager.createQuery("from Teste", Teste.class).getResultList();
//2
        result.forEach(e-> System.out.println(e.getTeste()));

        entityManager.close();
        entityManagerFactory.close();

    }
}

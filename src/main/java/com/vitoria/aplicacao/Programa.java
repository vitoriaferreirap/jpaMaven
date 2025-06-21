package com.vitoria.aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.vitoria.dominio.Pessoa;

public class Programa {
    public static void main(String[] args) {

        // Ao instanciando o EntityManagerFactory acessa as config persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        // instanciando EntityManger conecta com o banco de dados
        EntityManager em = emf.createEntityManager();

        // SEMPRE QUE É OPERAÇÃO QUE NÃO SEJA APENAS CONSULTA

        /*
         * OBJS ADICIONADO NO BANCO
         * 
         * em.getTransaction().begin();
         * 
         * // persiste pega o objeto e salva os dados no banco
         * em.persist(p1);
         * em.persist(p2);
         * em.persist(p3);
         * 
         * // finaliza a transação
         * em.getTransaction().commit();
         * System.out.println("Dados inseridos com sucesso!");
         * 
         * System.out.println(p1);
         * System.out.println(p2);
         * System.out.println(p3);
         */

        /*
         * // BUSCANDO OBJETO NO BANCO - metodo find JPA
         * Pessoa p = em.find(Pessoa.class, 2);
         * System.out.println("Pessoa encontrada: " + p);
         */

        // Exluindo entidade monitorada APENAS
        // obj Monitorado: Ou acabou de inserir ou foi buscado do banco e ainda não
        // fechou

        em.getTransaction().begin();
        Pessoa p = em.find(Pessoa.class, 2);
        em.remove(p);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
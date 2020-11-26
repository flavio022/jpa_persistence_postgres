package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null,"Flavio Costa","flavio.danilo022@gmail.com");
		Pessoa p2 = new Pessoa(null,"Diego Costa","diego.costa@gmail.com");
		Pessoa p3 = new Pessoa(2,"Marcelo Pão","marcelopao@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitName");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//em.persist(p1);
		//em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		
		Pessoa p  = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println(p);
		em.close();
		emf.close();
		
		
		
		System.out.println("Pronto");
		
		
		

	}

}

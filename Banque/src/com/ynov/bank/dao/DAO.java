package com.ynov.bank.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.bank.TestJPA;
import com.ynov.bank.model.Client;
import com.ynov.bank.model.Compte;
import com.ynov.bank.model.Transaction;

public class DAO 
{
	private static final String PERSISTENCE_UNIT_NAME = "JPA_test";
	private static EntityManagerFactory factory;
	private static Logger logger = LogManager.getLogger(TestJPA.class);
	
	public DAO()
	{

	}
	
	public static EntityManagerFactory getFactoryInstance()
	{
		if(factory == null)
		{
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		
		return factory;
	}
		
	
	//pour les client
	
	public static Client getClientbyID(int id)
	{	
		EntityManager em = getFactoryInstance().createEntityManager();
		em.getTransaction().begin();
		Client c = em.find(Client.class, id);
		em.close();
		return c;
	}
	
	public static List<Client> getAllClient()
	{
		EntityManager em = getFactoryInstance().createEntityManager();
		em.getTransaction().begin();
		//return em.createQuery("select clientID, nom, prenom from Client", Client.class).getResultList();
		Query q = em.createNativeQuery("select * from Client", Client.class);
		List<Client> liste = q.getResultList();
		em.close();
		return liste;
	}
	
	public static List<Compte> getCompteByClientID(int clientID)
	{
		EntityManager em = getFactoryInstance().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("from Compte where clientID = :id", Compte.class).setParameter("id", clientID);
		List<Compte> liste = q.getResultList();
		em.close();
		return liste;
	}
	
	public static List<Transaction> getTransactionByCompteID(int compteID)
	{
		EntityManager em = getFactoryInstance().createEntityManager();
		em.getTransaction().begin();
		//return em.createQuery("select clientID, nom, prenom from Client", Client.class).getResultList();
		List<Transaction> liste = em.createQuery("from Transaction where compteID = :compteID", Transaction.class).setParameter("compteID", compteID).getResultList();;
		em.getTransaction().commit();
		em.close();
		return liste;
	}
	
	public static Compte getCompteByID(int id)
	{
		EntityManager em = getFactoryInstance().createEntityManager();
		em.getTransaction().begin();
		Compte compte = em.createQuery("from Compte where numero = :id",
				Compte.class).setParameter("id", id).getSingleResult(); 	
		em.close();
		return compte;
	}
	
	public static void deleteClientById(int id)
	{
		EntityManager em = getFactoryInstance().createEntityManager();
		em.getTransaction().begin();
		Client c = em.find(Client.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void addTransaction(Transaction t)
	{
		//em.persist(Transaction) pour inserer 
		Date d = new Date();
		EntityManager em = getFactoryInstance().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("INSERT INTO Transaction (`date`, `libelle`, `montant`, `compteID`) VALUES (?,?,?,?)",
				Transaction.class);
        q.setParameter(1, t.getDate());
        q.setParameter(2, t.getLibelle());
        q.setParameter(3, t.getMontant());
        q.setParameter(4, t.getCompte_t().getNumero());
		q.executeUpdate(); 	
		em.getTransaction().commit();	
		em.close();
	}
	
	public static void addCompte(Compte c)
	{
		//em.persist(Transaction) pour inserer 
		
		EntityManager em = getFactoryInstance().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createNativeQuery("INSERT INTO Compte (`libelle`, `clientID`) VALUES (?,?)",
				Compte.class);
        q.setParameter(1, c.getLibelle());
        q.setParameter(2, c.getClient());
		q.executeUpdate(); 	
		em.getTransaction().commit();	
		em.close();
	}
	
	
	//pour le login
	
	public static void checkLog()
	{
		EntityManager em = getFactoryInstance().createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
		List<Client> clientList = tQuery.getResultList();
		
		PersistenceUtil util = Persistence.getPersistenceUtil();
		for(Client c : clientList)
		{
			logger.info(c.toString());
			logger.debug("is client loaded ? "+util.isLoaded(c));
			logger.debug("is client loaded ? "+util.isLoaded(c.getComptes()));
			Compte co = c.getComptes().get(0);
			logger.debug("are transactions loaded ? "+util.isLoaded(co, "transactions"));
			co.getTransactions();
			logger.debug("are transactions loaded now ?"+util.isLoaded(co, "transactions"));
			for(Transaction tran : co.getTransactions())
			{
				logger.info(tran.toString());
			}
		}
		logger.info("Size: "+ clientList.size());
		logger.info("ca devrait marcher laaaaaaa !!!");
	
		em.persist(clientList);
		em.getTransaction().commit();	
		em.close();
	}
}

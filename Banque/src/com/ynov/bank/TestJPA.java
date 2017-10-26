package com.ynov.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynov.bank.dao.ClientManager;
import com.ynov.bank.dao.DAO;
import com.ynov.bank.model.Client;
import com.ynov.bank.model.Compte;
import com.ynov.bank.model.Transaction;

public class TestJPA 
{
	private static final String PERSISTENCE_UNIT_NAME = "JPA_test";
	private static EntityManagerFactory factory;
	private static Logger logger = LogManager.getLogger(TestJPA.class);
	
	public static void main(String[] args)
	{
		
		
		
//		Client c = new Client("mama", "sita", "lamama", "delacasa123");
//		Compte compte = new Compte("compte courant", c, 1234);
//		Transaction trans = new Transaction(compte, "pour maman", 900.03);
//		List<Compte> listeComptes = new ArrayList<Compte>();
//		List<Transaction> transactions = new ArrayList<Transaction>();
//		transactions.add(trans);
//		listeComptes.add(compte);
//		compte.setTransactions(transactions);
//		c.setComptes(listeComptes);
//		em.persist(c);
//		em.getTransaction().commit();
		
		//Client c = new Client();
		//c.deleteClientById(em, 4);
		

		DAO.checkLog();
		
		
		//c = c.getClientbyID(1);
		
		//System.out.println("le client trouvé s'appelle :"+ c.getPrenom());
		
		
		//important de fermer sinon la bdd reste active
	}
}

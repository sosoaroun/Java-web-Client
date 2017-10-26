package com.ynov.bank.model;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Client 
{
	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	private static final String PERSISTENCE_UNIT_NAME = "JPA_test";
	private static EntityManagerFactory factory;
	
	private String nom;
	private String prenom;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientID;
	private String passwd;
	private String login;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="client", fetch = FetchType.EAGER)
	private List<Compte> comptes;
	
	public Client(String nom, String prenom, String login, String mdp)
	{
		this.nom = nom;
		this.prenom = prenom;
		//this.clientID = id;
		this.passwd = mdp;
		this.login = login;
	}

	public Client()
	{
		
	}
	
	
	

	
	
	
	public String toString() 
	{
		return "Client [nom=" + nom + ", prenom=" + prenom + ", clientID=" + clientID
				+ ", login=" + login + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}

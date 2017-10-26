package com.ynov.bank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compte 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="clientID")
	private Client client;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="compte_t", fetch = FetchType.LAZY)
	private List<Transaction> transactions; 

	public Compte(String libelle, Client c)
	{
		this.libelle = libelle;
		this.client = c;
	}
	
	public Compte()
	{
		
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Boolean addTransaction(Transaction t)
	{
		return this.transactions.add(t);
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) 
	{
		this.libelle = libelle;
	}

	public int getClient() 
	{
		return client.getClientID();
	}

	public void setClient(Client client) 
	{
		this.client.setClientID(client.getClientID());
	}
	
//	public Compte getByID(int id)
//	{
//		Compte resultat = new Compte();
//		resultat.setClient(client);
//		resultat.setLibelle(libelle);		
//	}
}

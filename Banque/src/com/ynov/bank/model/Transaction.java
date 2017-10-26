package com.ynov.bank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transacID;
	private String libelle;
	private Date date;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="compteID")
	private Compte compte_t;
	
	public Transaction(Compte c, String l, double m)
	{
		this.compte_t = c;
		this.libelle = l;
		this.date = new Date();
		this.montant = m;
	}
	
	public Transaction()
	{}
	
	public int getTransacID() {
		return transacID;
	}

	public void setTransacID(int transacID) {
		this.transacID = transacID;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte_t() 
	{
		return compte_t;
	}

	public void setCompte_t(Compte compte) 
	{
		this.compte_t = compte;
	}
	
	
}

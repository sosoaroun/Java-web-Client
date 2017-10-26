package com.ynov.bank;

import java.util.ArrayList;
import java.util.List;

import com.ynov.bank.dao.ClientManager;
import com.ynov.bank.model.Client;
import com.ynov.bank.model.Compte;

public class Connect {

	public static void main(String[] args) 
		{
	        //ClientManager.loadClientByID(1);
	        
	        Client c = new Client("mama", "sita", "lamama", "delacasa123");
			Compte compte = new Compte("compte courant", c, 23930);
			List<Compte> listeComptes = new ArrayList<Compte>();
			listeComptes.add(compte);
			c.setComptes(listeComptes);
			ClientManager.addClient(c);
	        ClientManager.addCompte(compte);
	    }
}

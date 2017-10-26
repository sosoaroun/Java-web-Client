package com.ynov.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ynov.bank.model.Client;
import com.ynov.bank.model.Compte;

public class ClientManager 
{
	public static final String DB_LOGIN = "root";
	public static final String DB_PASSWD = "root";
	
	public static Client loadClientByID(int clientID)
	{
		Client result = new Client();
		try {
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:8889/Banque_JPA", DB_LOGIN, DB_PASSWD);
			
			
			PreparedStatement stmt = con.prepareStatement("SELECT clientID, nom, prenom, login FROM client WHERE clientID = ?");
			stmt.setInt(1,  clientID);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				result.setClientID(rs.getInt("clientID"));
				result.setNom(rs.getString("nom"));
				result.setPrenom(rs.getString("prenom"));
				result.setLogin(rs.getString("login"));
				
				System.out.println("Trouvé un client "+result.toString());
			}
			
			rs.close();
			con.close();
		} catch (Exception e) { e.printStackTrace(); }
		
		return result;
	}

	public static Client addClient(Client client)
	{	
		Client result = new Client();
		try {
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:8889/Banque", DB_LOGIN, DB_PASSWD);
			
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO client (nom, prenom, login, passwd) VALUES (?,?,?,?)");
			stmt.setString(1,  client.getNom());
			stmt.setString(2,  client.getPrenom());
			stmt.setString(3,  client.getLogin());
			stmt.setString(4,  client.getPasswd());
			int rs = stmt.executeUpdate();
			
			if(rs > 0)
			{
				System.out.println("Client Ajouté");
			}
			
//			while(rs.next())
//			{
//				result.setClientID(rs.getInt("clientID"));
//				result.setNom(rs.getString("nom"));
//				result.setPrenom(rs.getString("prenom"));
//				result.setLogin(rs.getString("login"));
//				
//				System.out.println("Trouvé un client "+result.toString());
//			}
//			
//			rs.close();
			con.close();
		} catch (Exception e) { e.printStackTrace(); }
		
		return result;
	}
	
	public static Compte addCompte(Compte compte)
	{	
		Compte result = new Compte();
		try {
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:8889/Banque", DB_LOGIN, DB_PASSWD);
			
			
			PreparedStatement stmt = con.prepareStatement("INSERT INTO compte (libelle, clientID, numero) VALUES (?,?,?)");
			stmt.setString(1,  compte.getLibelle());
			stmt.setInt(2,  compte.getClient());
			stmt.setInt(3,  compte.getNumero());
			int rs = stmt.executeUpdate();
			
			if(rs > 0)
			{
				System.out.println("Client Ajouté");
			}
			
//			while(rs.next())
//			{
//				result.setClientID(rs.getInt("clientID"));
//				result.setNom(rs.getString("nom"));
//				result.setPrenom(rs.getString("prenom"));
//				result.setLogin(rs.getString("login"));
//				
//				System.out.println("Trouvé un client "+result.toString());
//			}
//			
//			rs.close();
			con.close();
		} catch (Exception e) { e.printStackTrace(); }
		
		return result;
	}



}
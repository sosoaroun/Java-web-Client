package com.ynov.bank.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ynov.bank.dao.DAO;
import com.ynov.bank.model.Client;
import com.ynov.bank.model.Compte;
import com.ynov.bank.model.Transaction;

/**
 * Servlet implementation class AfficheCompte
 */
@WebServlet("/AfficheCompte")
public class AfficheCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String clientIDStr = request.getParameter("id");
		
		int clientID = Integer.parseInt(clientIDStr);
		
		Client client = DAO.getClientbyID(clientID);
		
		request.setAttribute("client", client);
		request.getRequestDispatcher("/WEB-INF/ListeCompte.jsp").forward(request, response);
		//request.getRequestDispatcher("/WEB-INF/header.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String libelle = request.getParameter("libelle");
	    int clientID = Integer.parseInt(request.getParameter("id"));
	    Client client = DAO.getClientbyID(clientID);
	    Compte compte = new Compte(libelle, client);
	    
	    DAO.addCompte(compte);
	}

}

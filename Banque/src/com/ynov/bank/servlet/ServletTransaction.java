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
 * Servlet implementation class ServletTransaction
 */
@WebServlet("/ServletTransaction")
public class ServletTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTransaction() {
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
		
		String compteIDStr = request.getParameter("id");
		
		int compteID = Integer.parseInt(compteIDStr);
		Compte compte = DAO.getCompteByID(compteID);
		request.setAttribute("compte", compte);
		//response.setIntHeader("Refresh", 1);
		request.getRequestDispatcher("/WEB-INF/ListeTransaction.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String libelle = request.getParameter("libelle");
	    String m = request.getParameter("montant");	    
	    Double montant = Double.parseDouble(m);
	    int compteID = Integer.parseInt(request.getParameter("id"));	
	    Compte c = DAO.getCompteByID(compteID);
	    
	    Transaction t = new Transaction(c,libelle,montant);
	    
	    DAO.addTransaction(t);
//	    
	}

}

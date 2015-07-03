package com.loncoto.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String titreDefaut;
	private int compteur; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        System.out.println("construction de la servlet Home");
        compteur = 0;
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init de home servlet");
		titreDefaut = getServletConfig().getInitParameter("titreDefaut");
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		compteur++;
		System.out.println("appel de la méthode get de home : compteur = " + compteur);
		response.setContentType("text/html");
		// je récupere un flux vers la réponse
		PrintWriter pw = response.getWriter();
		pw.println("<html><head><title>" + titreDefaut + "</title></head>");
		pw.println("<body><h2>bonjour, nous sommmes le " 
					+ new Date() 
					+ "</h2></body></html>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		compteur++;
		System.out.println("appel de la méthode post de home : compteur = " + compteur);
		// getParameter est en provenance des formulaire
		// uniquement du texte
		String nom = request.getParameter("nom");
		String mdp = request.getParameter("motdepasse");

		System.out.println("j'ai recu le login = " + nom + " avec mdp = " + mdp);
		
		if (mdp.length() < 4) // le mot de passe est trop court
		{
			getServletContext().getRequestDispatcher("/erreur.jsp")
								.forward(request, response);
		}
		else
		{
			String message = "bienvenue " + nom;
			// les attributes permettent de communiquer entre servlet et jsp
			// on peu ici mette un objet quelconque, contrairement au parameter
			// c'est strictement interne serveur
			request.setAttribute("msg", message);
			getServletContext().getRequestDispatcher("/bienvenue.jsp")
								.forward(request, response);		
		}
	}

}

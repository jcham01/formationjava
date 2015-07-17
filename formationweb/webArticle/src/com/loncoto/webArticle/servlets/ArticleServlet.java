package com.loncoto.webArticle.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loncoto.webArticle.utils.ArticleDAO;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ArticleDAO articleDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		articleDAO = (ArticleDAO)getServletContext().getAttribute("articleDAO");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" uri = " + request.getRequestURI());
		String uri = request.getRequestURI();
		String[] champs = uri.split("/");
		String order = champs[champs.length - 1];
		int choix = ArticleDAO.ORDERED_BY_DEFAULT;
		switch (order) {
			case "prix":
				choix = articleDAO.ORDERED_BY_PRIX;
				break;
			case "poids":
				choix = articleDAO.ORDERED_BY_POIDS;
				break;
		}
		request.setAttribute("articles", articleDAO.findAll(choix));
		getServletContext().getRequestDispatcher("/liste.jsp")
							.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

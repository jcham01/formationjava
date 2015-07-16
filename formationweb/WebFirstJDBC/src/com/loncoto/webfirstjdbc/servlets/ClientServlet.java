package com.loncoto.webfirstjdbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loncoto.webfirstjdbc.beans.Client;
import com.loncoto.webfirstjdbc.utils.ClientDAO;

/**
 * Servlet implementation class ClientServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private ClientDAO clientDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		clientDAO = (ClientDAO)getServletContext().getAttribute("clientDAO");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clients = clientDAO.findAll();
		request.setAttribute("clients", clients);
		
		getServletContext().getRequestDispatcher("/liste.jsp")
							.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
			case "editer":
				int id = Integer.parseInt(request.getParameter("id"));
				Client c = clientDAO.findByID(id);
				request.setAttribute("client", c);
				getServletContext().getRequestDispatcher("/edit.jsp")
					.forward(request, response);				
				break;
			case "creer":
				Client c3 = new Client(0, "noname", "noemail@toto.com", 100.0);
				request.setAttribute("client", c3);
				getServletContext().getRequestDispatcher("/edit.jsp")
					.forward(request, response);				
				break;
			case "sauver":
				Client c2 = new Client(Integer.parseInt(request.getParameter("id"))
									 ,request.getParameter("nom")
									 ,request.getParameter("email")
									 ,Double.parseDouble(request.getParameter("solde"))
									 );
				clientDAO.save(c2);
				// renvoie une redirection http
				response.sendRedirect("ClientServlet");
				break;
			case "supprimer":
				int cid = Integer.parseInt(request.getParameter("id"));
				clientDAO.delete(cid);
				response.sendRedirect("ClientServlet");			
				break;
		}
	}

}

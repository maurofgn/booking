package org.mf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mf.dao.SocietaDao;
import org.mf.model.Societa;
import org.mf.util.Utility;

/**
 * Servlet implementation class SocietaController
 */
@WebServlet("/SocietaController")
public class SocietaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/societa.jsp";
	private static String LIST = "/listsocieta.jsp";
	private SocietaDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocietaController() {
        super();
        dao = new SocietaDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if (action == null)
			action = "list";

		if (action.equalsIgnoreCase("edit")) {
			Integer id = getId(request);
			Societa societa = dao.getById(id);
			forward = INSERT_OR_EDIT;
			request.setAttribute("bean", societa);
		} else if (action.equalsIgnoreCase("delete")) {
			Integer id = getId(request);
			dao.delete(id);
			forward = LIST;
			request.setAttribute("beans", dao.getAll());
		} else if (action.equalsIgnoreCase("list")) {
			forward = LIST;
			request.setAttribute("beans", dao.getAll());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = getId(request);
		
		Societa retValue = new Societa();
		
		retValue.setId(id);
		retValue.setNome(request.getParameter("nome"));
		retValue.setCitta(request.getParameter("citta"));
		retValue.setProv(request.getParameter("prov"));
		retValue.setIndirizzo(request.getParameter("indirizzo"));
		retValue.setCodiceFederale(request.getParameter("codiceFederale"));
		retValue.setGiorniRitardoAmmesso(Utility.parseInteger(request.getParameter("giorniRitardoAmmesso")));
		retValue.setSite(request.getParameter("site"));
		retValue.setMail(request.getParameter("mail"));
		retValue.setPersonaId(Utility.parseInteger(request.getParameter("personaId")));
		
		if (id == null || id == 0) {
			dao.add(retValue);
		} else {
			dao.check(retValue);
		}
		
		RequestDispatcher view = request.getRequestDispatcher(LIST);
		request.setAttribute("beans", dao.getAll());
		view.forward(request, response);
	}
	
	private Integer getId(HttpServletRequest request) {
		return Utility.getInteger(request.getParameter("id"));
	}

}

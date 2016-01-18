package org.mf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mf.dao.PersonaDao;
import org.mf.dao.SocietaDao;
import org.mf.dao.SocioDao;
import org.mf.model.Socio;
import org.mf.util.Utility;

/**
 * Servlet implementation class SocioController
 */
@WebServlet("/SocioController")
public class SocioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/socio.jsp";
	private static String LIST = "/listsocio.jsp";
	private SocioDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocioController() {
        super();
        dao = new SocioDao();
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
			Socio socio = dao.getById(id);
			forward = INSERT_OR_EDIT;
			setSocietaList(request);
			setPersoneList(request);
			request.setAttribute("bean", socio);
		} else if (action.equalsIgnoreCase("delete")) {
			Integer id = getId(request);
			dao.delete(id);
			forward = LIST;
			request.setAttribute("beans", dao.getAll());
		} else if (action.equalsIgnoreCase("list")) {
			forward = LIST;
			request.setAttribute("beans", dao.getAll());
		} else {
			setSocietaList(request);
			setPersoneList(request);
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
		
		Socio retValue = new Socio();
		
		retValue.setId(id);
		retValue.setTessera(Utility.parseInteger(request.getParameter("tessera")));
		retValue.setAnnoInizio(Utility.parseInteger(request.getParameter("annoInizio")));
		retValue.setScadenza(Utility.parseDate(request.getParameter("scadenza")));
		retValue.setSocietaId(Utility.parseInteger(request.getParameter("societaId")));
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
	
	/**
	 * mette in request l'elenco di tutte le società
	 * @param request
	 */
	private void setSocietaList(HttpServletRequest request) {
		request.setAttribute("societaList", new SocietaDao().getAllOrdered());	//tutte le società ordinate secondo l'ordine definito in Societa
	}
	private void setPersoneList(HttpServletRequest request) {
		request.setAttribute("personeList", new PersonaDao().getAllOrdered());	//tutte le persone ordinate secondo l'ordine definito in Persona
	}

}

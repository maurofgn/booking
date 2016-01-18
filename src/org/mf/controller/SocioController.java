package org.mf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mf.dao.SocioDao;
import org.mf.model.Socio;
import org.mf.util.Utility;

@WebServlet("/SocioController")	
public class SocioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/socio.jsp";
	private static String LIST = "/listsocio.jsp";
	private SocioDao dao;
	
	public SocioController() {
		super();
		dao = new SocioDao();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if (action == null)
			action = "list";

		if (action.equalsIgnoreCase("edit")) {
			Integer id = getId(request);
			Socio socio = dao.getById(id);
			forward = INSERT_OR_EDIT;
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
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = getId(request);
		
		Socio retValue = new Socio();
		
		retValue.setId(id);
		retValue.setNome(request.getParameter("nome"));
		retValue.setCognome(request.getParameter("cognome"));
		retValue.setCitta(request.getParameter("citta"));
		retValue.setProv(request.getParameter("prov"));
		retValue.setIndirizzo(request.getParameter("indirizzo"));
		retValue.setTelefono(request.getParameter("telefono"));
		retValue.setMail(request.getParameter("mail"));
		retValue.setCodFisc(request.getParameter("codFisc"));
		retValue.setPsw(request.getParameter("psw"));
		retValue.setUtente(request.getParameter("utente"));
		retValue.setRuolo(request.getParameter("ruolo"));
		retValue.setNascita(Utility.parseDate(request.getParameter("nascita")) );
		retValue.setSesso(request.getParameter("sesso"));
		
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

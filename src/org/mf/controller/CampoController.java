package org.mf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mf.dao.CampoDao;
import org.mf.model.Campo;
import org.mf.modelView.Fondo;
import org.mf.util.Utility;

/**
 * Servlet implementation class CampoController
 */
@WebServlet("/CampoController")
public class CampoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/campo.jsp";
	private static String LIST = "/listcampo.jsp";
	private CampoDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CampoController() {
        super();
        dao = new CampoDao();
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
			Campo campo = dao.getById(id);
			forward = INSERT_OR_EDIT;
			request.setAttribute("bean", campo);
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
		
		Campo retValue = new Campo();
		
		retValue.setId(id);
		retValue.setNome(request.getParameter("nome"));
		retValue.setTipo(Fondo.fromOrdinal(Utility.parseInteger(request.getParameter("citta"))));
		retValue.setDescrizione(request.getParameter("Descrizione"));
		retValue.setAperturaOra(Utility.parseInteger(request.getParameter("Apertura_Ora")));
		retValue.setAperturaMin(Utility.parseInteger(request.getParameter("Apertura_Min")));
		retValue.setChiusuraOra(Utility.parseInteger(request.getParameter("Chiusura_Ora")));
		retValue.setIntervalloOra(Utility.parseInteger(request.getParameter("Intervallo_Ora")));
		retValue.setIntervalloOre(Utility.parseInteger(request.getParameter("Intervallo_Ore")));
		retValue.setSequenza(Utility.parseInteger(request.getParameter("Sequenza")));
		retValue.setSocietaId(Utility.parseInteger(request.getParameter("Societa_Id")));
		
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

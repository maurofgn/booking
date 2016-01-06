package org.mf.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mf.dao.PrenoDao;
import org.mf.model.Preno;
import org.mf.util.Utility;


@WebServlet("/PrenoController")	
public class PrenoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/Preno.jsp";
	private static String LIST = "/Preno.jsp";
	private PrenoDao dao;
	
	public PrenoController() {
		super();
		dao = new PrenoDao();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if (action == null)
			action = "list";

		if (action.equalsIgnoreCase("edit")) {
			Integer id = getId(request);
			Preno preno = dao.getById(id);
			forward = INSERT_OR_EDIT;
			request.setAttribute("bean", preno);
/*		} else if (action.equalsIgnoreCase("delete")) {
			Integer id = getId(request);
			dao.delete(id);
			forward = LIST;
			request.setAttribute("beans", dao.getAll());
*/		
		} else if (action.equalsIgnoreCase("list")) {
			forward = LIST;
			loadPreno(request);
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("save")) {
			System.out.println("save");
		}
		
		loadPreno(request);
		
		
		
		loadPreno(request);
		
		RequestDispatcher view = request.getRequestDispatcher(LIST);
		view.forward(request, response);
	}
	
	private void loadPreno(HttpServletRequest request) {
		
		Integer personaId = Utility.getInteger(request.getParameter("personaId"));
		if (personaId == 0) {
			HttpSession session = request.getSession(false);	//false ==> se non esiste non la crea
			if (session != null)
				personaId = (Integer)session.getAttribute("userId");
		}
		
		 
		Date data = Utility.parseDate(request.getParameter("dataPreno"));
		if (data == null)
			data = new Date();
		request.setAttribute("dataPreno", data);
		request.setAttribute("beans", dao.getAll(data, personaId));
	}
	
	private Integer getId(HttpServletRequest request) {
		return Utility.getInteger(request.getParameter("personaId"));
	}
	
}

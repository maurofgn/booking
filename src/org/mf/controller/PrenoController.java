package org.mf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mf.dao.CampoDao;
import org.mf.dao.PrenoDao;
import org.mf.model.Preno;
import org.mf.modelView.PrenoHourJson;
import org.mf.modelView.PrenoHoursJson;
import org.mf.modelView.PrenoState;
import org.mf.util.Utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/PrenoController")	
public class PrenoController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String PRENOTA = "/Preno.jsp";
	private static String LIST_PRENO = "/PrenoList.jsp";
	private PrenoDao dao;
	
	public PrenoController() {
		super();
		dao = new PrenoDao();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String forward = PRENOTA;
		
		String action = request.getParameter("action");
		if (action != null && action.equalsIgnoreCase("PrenoList")) {
			forward = LIST_PRENO;
			loadPrenoList(request);
		} else {
			forward = PRENOTA;	//default
			loadPreno(request, getPersonaId(request));
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Integer personaId = getPersonaId(request);
		
		String action = request.getParameter("action");
		if (personaId > 0 && action != null && action.equalsIgnoreCase("save")) {
			String jsonLine = request.getParameter("matrix");
			savePrenos(personaId, jsonLine);
		}
		
		loadPreno(request, personaId);
		
		RequestDispatcher view = request.getRequestDispatcher(PRENOTA);
		view.forward(request, response);
	}
	
	/**
	 * save prenotazioni
	 * @param personaId
	 * @param jsonLine
	 */
	private void savePrenos(Integer personaId, String jsonLine) {
		
		if (personaId == 0 || jsonLine == null || jsonLine.isEmpty())
			return;
		
		CampoDao campoDao = new CampoDao();
		Hashtable<Integer, Integer> campoSocio = new Hashtable<Integer, Integer>();
		
		Gson gson=  new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		
		PrenoHoursJson prenoHoursJson = gson.fromJson(jsonLine, PrenoHoursJson.class);
		
		List<Preno> prenosToRemove = new ArrayList<Preno>();
		List<Preno> prenosToInsert = new ArrayList<Preno>();
		for (int i = 0; i < prenoHoursJson.getHours().length; i++) {
			PrenoHourJson prenoHourJson = prenoHoursJson.getHours()[i];
			Integer socio = getSocio(campoDao, campoSocio, prenoHourJson.getCampo(), personaId);
			Preno preno = new Preno(prenoHourJson, socio, prenoHoursJson.getData());
			if (PrenoState.MiaPreno == prenoHourJson.getStato())
				prenosToRemove.add(preno);
			else
				prenosToInsert.add(preno);
		}
			
		dao.save(prenosToRemove, prenosToInsert);
	}

	private Integer getSocio(CampoDao campoDao, Hashtable<Integer, Integer> campoSocio, int campo, Integer personaId) {
		Integer retValue = campoSocio.get(campo);
		if (retValue != null)
			return retValue;
		
		retValue = campoDao.getSocio(campo, personaId);
		campoSocio.put(campo, retValue);
		return retValue;
	}

	private void loadPreno(HttpServletRequest request, Integer personaId) {
		
		Date data = Utility.parseDate(request.getParameter("dataPreno"));
		if (data == null)
			data = new Date();
		request.setAttribute("dataPreno", data);
		request.setAttribute("beans", dao.getAll(data, personaId));
	}
	
	private Integer getPersonaId(HttpServletRequest request) {
		Integer personaId = Utility.getInteger(request.getParameter("personaId"));
		if (personaId == 0) {
			HttpSession session = request.getSession(false);	//false ==> se non esiste non la crea
			if (session != null)
				personaId = (Integer)session.getAttribute("userId");
		}
		
		return personaId;
	}
	
	private void loadPrenoList(HttpServletRequest request) {
		
		Date data = Utility.parseDate(request.getParameter("dataPreno"));
		if (data == null)
			data = new Date();
		
		String nomePersona = request.getParameter("nomePersona");
		String cognomePersona = request.getParameter("cognomePersona");
		String nomeCampo = request.getParameter("nomeCampo");
		String nomeSocieta = request.getParameter("nomeSocieta");
		
		request.setAttribute("beans", dao.getPrenoList(data, nomePersona, cognomePersona, nomeCampo, nomeSocieta));
	}
	
}

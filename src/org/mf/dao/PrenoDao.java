package org.mf.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.mf.model.Campo;
import org.mf.model.Preno;
import org.mf.modelView.Fondo;
import org.mf.modelView.PrenoList;
import org.mf.modelView.PrenoRow;

public class PrenoDao extends Dao {
	
	private static final String TABLE_NAME = "preno";

	public PrenoDao() {
		super();
	}
	
	@Override
	String getTableName() {
		return TABLE_NAME;
	}

	public void check(Preno preno) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("select * from preno where id = ?");
			ps.setInt(1, preno.getId() );
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				update(preno);	
			} else {
				add(preno);
			}
		} catch (SQLException ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
	}

	public void add(Preno preno) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO preno "); 
		sb.append("(socio_id ,campo_id ,data ,ora) VALUES ");
		sb.append("(?        ,?        ,?    ,?  ) ");
		//          1   	  2     	3	  4

		try {
			PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
			
			stmtPara(stmt, 1, Types.VARCHAR, preno.getSocioId());
			stmtPara(stmt, 2, Types.INTEGER, preno.getCampoId());
			stmtPara(stmt, 3, Types.DATE, preno.getData());
			stmtPara(stmt, 4, Types.INTEGER, preno.getOra());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Preno preno) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE preno SET "); 
		sb.append("socio_id=?, "); 			//1
		sb.append("campo_id=?, ");  		//2
		sb.append("data=?, ");  			//3
		sb.append("ora=?, ");  				//4
		sb.append("WHERE id = ? "); 		//5
		
		try {
			
			PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
			
			stmtPara(stmt, 1, Types.VARCHAR, preno.getSocioId());
			stmtPara(stmt, 2, Types.INTEGER, preno.getCampoId());
			stmtPara(stmt, 3, Types.VARCHAR, preno.getData());
			stmtPara(stmt, 4, Types.INTEGER, preno.getOra());

			stmtPara(stmt, 5, Types.INTEGER, preno.getId());
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Preno> getAll(int campoId) {
		List<Preno> retValue = new ArrayList<Preno>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT "); 
		sb.append("pr.* "); 
		sb.append("FROM preno pr "); 
		sb.append("where "); 
		sb.append("pr.data >= CURDATE() "); 
		sb.append("and pr.campo_ID = ? "); 
		sb.append("order by pr.data, pr.ora ");
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sb.toString());
			ps.setInt(1, campoId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				retValue.add(assignBean(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retValue;
	}
	
	/**
	 * 
	 * @param data
	 * @param socioId
	 * @return List<PrenoRow> della data e per i campi a cui ha accesso il socio
	 * 
	 */
	public List<PrenoRow> getAll(Date data, int socioId) {
		List<PrenoRow> retValue = new ArrayList<PrenoRow>();
		if (data == null)
			data = new Date();
		
		CampoDao campoDao = new CampoDao();
		Hashtable<Integer, List<Campo>> campiSoc = campoDao.getAllSocPerSocio(socioId);
		if (campiSoc == null || campiSoc.isEmpty())
			return retValue;
		
		int primaOra = 24;
		int ultimaOra = 0;
		Hashtable<Integer, Campo> playGrounds = new Hashtable<Integer, Campo>();
		
		for (List<Campo> campi : campiSoc.values()) {
			for (Campo campo : campi) {
				playGrounds.put(campo.getId(), campo);
				if (primaOra > campo.getAperturaOra())
					primaOra = campo.getAperturaOra();
				if (ultimaOra < campo.getChiusuraOra())
					ultimaOra = campo.getChiusuraOra();
			}
		}
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("SELECT "); 
		sb.append("pg.id k ,s.persona_ID, pr.ora, p.utente "); 
		sb.append("FROM campo pg "); 
		sb.append("left join ( "); 
		sb.append("   preno pr "); 
		sb.append("   inner join socio s on s.id =pr.socio_ID "); 
		sb.append("   inner join persona p on p.id = s.persona_ID "); 
		sb.append(") on pr.campo_id = pg.id and pr.data = ? "); 
		sb.append("where "); 
		sb.append("pg.societa_id in ( ");
		sb.append(StringUtils.join(campiSoc.keySet(), ','));
		sb.append(") ");
		sb.append("order by pg.sequenza, pg.id, pr.ora ");
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sb.toString());
			ps.setDate(1, new java.sql.Date(data.getTime()));
			ResultSet rs = ps.executeQuery();
			
			PrenoRow prenoRow = null;

			while (rs.next()) {
				
				int key = rs.getInt("k") ;
				if (prenoRow == null || prenoRow.getCampo().getId() != key) {
					prenoRow = new PrenoRow(socioId, playGrounds.get(key), data, primaOra, ultimaOra);
					retValue.add(prenoRow);
				}
				
				prenoRow.reserveOneHour(rs.getInt("ora"), rs.getInt("persona_ID"), rs.getString("utente"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retValue;
	}
	
//	/**
//	 * 
//	 * @param data
//	 * @param societa
//	 * @return List<PrenoRow> della data e per i campi delle società
//	 */
//	public List<PrenoRow> getAll(Date data, List<Integer> societa) {
//		List<PrenoRow> retValue = new ArrayList<PrenoRow>();
//		if (data == null)
//			return retValue;
//		
//		CampoDao campoDao = new CampoDao();
//		Hashtable<Integer, List<Campo>> campiSoc = campoDao.getAllSoc(societa);
//		int primaOra = 0;
//		int ultimaOra = 24;
//		Hashtable<Integer, Campo> playGrounds = new Hashtable<Integer, Campo>();
//		
//		for (List<Campo> campi : campiSoc.values()) {
//			for (Campo campo : campi) {
//				playGrounds.put(campo.getId(), campo);
//				if (primaOra > campo.getAperturaOra())
//					primaOra = campo.getAperturaOra();
//				if (ultimaOra < campo.getChiusuraOra())
//					ultimaOra = campo.getChiusuraOra();
//			}
//		}
//		
//		StringBuffer sb = new StringBuffer();
//		sb.append("SELECT "); 
//		sb.append("pg.id key "); 
//		sb.append(",pr.socio_ID, pr.ora ");
//		sb.append("FROM campo pg "); 
//		sb.append("left join preno pr on pr.campo_id = pg.id and pr.data = ? "); 
//		if (societa != null && !societa.isEmpty()) {
//			sb.append("where "); 
//			sb.append("pg.societa_id in ( ");
//			sb.append(StringUtils.join(societa, ','));
//			sb.append(") ");
//		}
//		sb.append("order by pg.sequenza, pg.id, pr.ora ");
//		
//		try {
//			
//			PreparedStatement ps = getConnection().prepareStatement(sb.toString());
//			ps.setDate(1, new java.sql.Date(data.getTime()));
//			ResultSet rs = ps.executeQuery();
//			
//			PrenoRow prenoRow = null;
//
//			while (rs.next()) {
//				
//				int key = rs.getInt("key") ;
//				if (prenoRow == null || prenoRow.getCampo().getId() != key) {
//					prenoRow = new PrenoRow(playGrounds.get(key), data, primaOra, ultimaOra);
//					retValue.add(prenoRow);
//				}
//				
//				prenoRow.addOneHour(rs.getInt("ora"), rs.getInt("socio_ID"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return retValue;
//	}
	

	public Preno getById(int id) {
		return (Preno)super.getById(id);
	}
	
	Preno assignBean(ResultSet rs) throws SQLException {
		Preno retValue = new Preno();

		retValue.setId(rs.getInt("id"));
		retValue.setSocioId(rs.getInt("socio_id"));
		retValue.setCampoId(rs.getInt("campo_id"));
		retValue.setData(rs.getDate("data"));
		retValue.setOra(rs.getInt("ora"));
		
		return retValue;
	}

	/**
	 * elimina o salva una serie di prenotazioni
	 * @param prenosToRemove da eliminare
	 * @param prenosToInsert da creare
	 */
	public void save(List<Preno> prenosToRemove, List<Preno> prenosToInsert) {
		
		if (prenosToRemove != null && !prenosToRemove.isEmpty()) {
		
			StringBuffer sb = new StringBuffer();
			sb.append("DELETE from preno "); 
			sb.append("where socio_id=? and campo_id=? and data=? and ora=? ");
			//            			  1   	 		 2     		3	  	  4
	
			try {
				PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
				
				for (Preno preno : prenosToRemove) {
				
					stmtPara(stmt, 1, Types.INTEGER, preno.getSocioId());
					stmtPara(stmt, 2, Types.INTEGER, preno.getCampoId());
					stmtPara(stmt, 3, Types.DATE, new java.sql.Date(preno.getData().getTime()));
					stmtPara(stmt, 4, Types.INTEGER, preno.getOra());
	
					stmt.executeUpdate();
				}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		if (prenosToInsert != null && !prenosToInsert.isEmpty()) {
			
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO preno "); 
			sb.append("(socio_id ,campo_id ,data ,ora) VALUES ");
			sb.append("(?        ,?        ,?    ,?  ) ");
			//          1   	  2     	3	  4
	
			try {
				PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
				
				for (Preno preno : prenosToInsert) {
				
					stmtPara(stmt, 1, Types.INTEGER, preno.getSocioId());
					stmtPara(stmt, 2, Types.INTEGER, preno.getCampoId());
					stmtPara(stmt, 3, Types.DATE, new java.sql.Date(preno.getData().getTime()));
					stmtPara(stmt, 4, Types.INTEGER, preno.getOra());
	
					stmt.executeUpdate();
					//questa insert potrebbe dare errore per eventuali prenotazioni fatte da altri in contemporanea (key-dup)
				}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * 
	 * @param data
	 * @param nomePersona
	 * @param cognomePersona
	 * @param nomeCampo
	 * @param nomeSocieta
	 * @return lista di PrenoList
	 */
	public List<PrenoList> getPrenoList(Integer personaId) {
	
		return getPrenoList(personaId, null, null, null, null, null);
	}
	
	public List<PrenoList> getPrenoList(Integer personaId, Date data, String nomePersona, String cognomePersona, String nomeCampo, String nomeSocieta) {
		
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT "); 
		sb.append("pr.data, "); 
		sb.append("sa.id societa_id, "); 
		sb.append("sa.nome societa, "); 
		sb.append("pr.campo_id, "); 
		sb.append("pg.nome campo, "); 
		sb.append("tipo fondo, "); 
		sb.append("pr.ora, "); 
		sb.append("so.persona_id, "); 
		sb.append("pe.nome, "); 
		sb.append("pe.cognome, "); 
		sb.append("pe.nascita, "); 
		sb.append("round(DATEDIFF(curDate(), pe.nascita)/365, 0) eta_day, "); 
		sb.append("YEAR(curDate()) - YEAR(pe.nascita) eta_year, "); 
		sb.append("pr.socio_id, "); 
		sb.append("so.tessera, "); 
		sb.append("DATEDIFF(curDate(), so.scadenza) gg_due, "); 
		sb.append("so.scadenza, "); 
		sb.append("so.anno_inizio "); 
		sb.append("FROM preno pr "); 
		sb.append("inner join campo pg on pg.id = pr.campo_id "); 
		sb.append("inner join socio so on so.id = pr.socio_id "); 
		sb.append("inner join societa sa on so.societa_id = sa.id "); 
		sb.append("inner join persona pe on pe.id = so.persona_id "); 
		sb.append("where "); 
		
		if (personaId > 0) {
			sb.append("so.persona_id = " + personaId + " "); 
			sb.append("and pr.data >= curDate() ");
		} else {
			if (data != null)
				sb.append("pr.data = ? ");
			else
				sb.append("pr.data >= curDate() ");
			
			if (nomePersona != null && !nomePersona.isEmpty())
				sb.append("and lower(pe.nome) like ('%" + nomePersona.toLowerCase().replaceAll("'","''") + "%' ) ");
			
			if (cognomePersona != null && !cognomePersona.isEmpty())
				sb.append("and lower(pe.cognome) like ('%" + cognomePersona.toLowerCase().replaceAll("'","''") + "%') "); 
				
			if (nomeCampo != null && !nomeCampo.isEmpty())
				sb.append("and lower(pg.nome) like lower('%" + nomeCampo.toLowerCase().replaceAll("'","''") + "%') ");
			
			if (nomeSocieta != null && !nomeSocieta.isEmpty())
				sb.append("--and lower(sa.nome) like lower('%" + nomeSocieta.toLowerCase().replaceAll("'","''") + "%') "); 
		}
		
		sb.append("order by pr.data, pg.sequenza, pg.id, pr.ora ");
		
		List<PrenoList> retValue = new ArrayList<PrenoList>();
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sb.toString());
			if (personaId <= 0 && data != null) {
				ps.setDate(1, new java.sql.Date(data != null ? data.getTime() : new Date().getTime()));
			}
			
			ResultSet rs = ps.executeQuery();
			
			PrenoList prenoRow = null;

			while (rs.next()) {
				
				prenoRow = new PrenoList();
				
				prenoRow.setData(rs.getDate("data")); 
				prenoRow.setSocietaId(rs.getInt("societa_Id"));
				prenoRow.setSocieta(rs.getString("societa")); 
				prenoRow.setCampoId(rs.getInt("campo_Id"));
				prenoRow.setCampo(rs.getString("campo"));
				prenoRow.setFondo(Fondo.fromOrdinal(rs.getInt("fondo"))); 
				prenoRow.setOra(rs.getInt("ora")); 
				prenoRow.setPersonaId(rs.getInt("persona_Id"));
				prenoRow.setNome(rs.getString("nome")); 
				prenoRow.setCognome(rs.getString("cognome")); 
				prenoRow.setNascita(rs.getDate("nascita")); 
				prenoRow.setEtaDay(rs.getInt("eta_Day")); 
				prenoRow.setEtaYear(rs.getInt("eta_Year")); 
				prenoRow.setSocioId(rs.getInt("socio_Id"));
				prenoRow.setTessera(rs.getInt("tessera")); 
				prenoRow.setGgDue(rs.getInt("gg_Due")); 
				prenoRow.setScadenza(rs.getDate("scadenza")); 
				prenoRow.setAnnoInizio(rs.getInt("anno_Inizio"));
				retValue.add(prenoRow);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retValue;
	}
	
}

package org.mf.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.mf.model.Persona;
import org.mf.model.Societa;
import org.mf.model.Socio;

public class SocioDao extends Dao {

	private static final String TABLE_NAME = "socio";

	public SocioDao() {
		super();
	}
	
	@Override
	String getTableName() {
		return TABLE_NAME;
	}

	public void check(Socio socio) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("select * from socio where id = ?");
			ps.setInt(1, socio.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				update(socio);	
			} else {
				add(socio);
			}
		} catch (SQLException ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
	}

	public void add(Socio socio) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO socio "); 
		sb.append("(tessera ,anno_Inizio ,scadenza ,societa_id ,persona_id) VALUES "); 
		sb.append("(?       ,?           ,?        ,?          ,?         ) ");
			//      1     	 2        	  3         4           5

		try {
			PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
			stmtPara(stmt, 1, Types.VARCHAR, socio.getTessera());
			stmtPara(stmt, 2, Types.VARCHAR, socio.getAnnoInizio());
			stmtPara(stmt, 3, Types.VARCHAR, socio.getScadenza());
			stmtPara(stmt, 4, Types.VARCHAR, socio.getSocietaId());
			stmtPara(stmt, 5, Types.VARCHAR, socio.getPersonaId());


			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Socio socio) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE socio SET "); 
		sb.append("tessera=?, "); 			//1
		sb.append("anno_Inizio=?, "); 		//2
		sb.append("scadenza=?, "); 			//3
		sb.append("societa_id=?, "); 		//4
		sb.append("persona_id=? "); 		//5
		sb.append("where id=? "); 			//6

		try {
			
			PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
			
			stmtPara(stmt, 1, Types.INTEGER, socio.getTessera());
			stmtPara(stmt, 2, Types.INTEGER, socio.getAnnoInizio());
			stmtPara(stmt, 3, Types.DATE, new java.sql.Date(socio.getScadenza().getTime()));
			stmtPara(stmt, 4, Types.INTEGER, socio.getSocietaId());
			stmtPara(stmt, 5, Types.INTEGER, socio.getPersonaId());
			stmtPara(stmt, 6, Types.INTEGER, socio.getId());

			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Socio> getAll() {
		List<Socio> retValue = new ArrayList<Socio>();
		PersonaDao pdao = new PersonaDao();
		Hashtable<Integer, Persona> htPeople = pdao.getAllHt();
		
		SocietaDao sdao = new SocietaDao();
		Hashtable<Integer, Societa> htSocieta = sdao.getAllHt();

		StringBuffer sb = new StringBuffer();
		sb.append("select "); 
		sb.append("s.* "); 
		sb.append("from socio s "); 
		sb.append("inner join persona p on p.id = s.persona_ID "); 
		sb.append("order by p.nome, p.cognome, s.persona_ID ");


		try {
			Statement statement = getConnection().createStatement();
			
			ResultSet rs = statement.executeQuery(sb.toString());
			while (rs.next()) {
				Socio socio = assignBean(rs);
				socio.setPersona(htPeople.get(socio.getPersonaId()));
				socio.setSocieta(htSocieta.get(socio.getSocietaId()));
				retValue.add(socio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retValue;
	}
	
	
//	private Hashtable<Integer, Persona> getAllHt() {
//		PersonaDao pdao = new PersonaDao();
//		List<Persona> people = pdao.getAll();
//		Hashtable<Integer, Persona> htPeople = new Hashtable<Integer, Persona>(people.size()); 
//		for (Persona persona : people) 
//			htPeople.put(persona.getId(), persona);
//		
//		return htPeople;
//	}

	public Socio getById(int id) {
		return (Socio)super.getById(id);
	}
	
	Socio assignBean(ResultSet rs) throws SQLException {
		Socio retValue = new Socio();
		retValue.setId(rs.getInt("id"));
		retValue.setTessera(rs.getInt("Tessera"));
		retValue.setAnnoInizio(rs.getInt("Anno_Inizio"));
		retValue.setScadenza(rs.getDate("Scadenza"));
		retValue.setSocietaId(rs.getInt("Societa_Id"));
		retValue.setPersonaId(rs.getInt("Persona_Id"));
		return retValue;
	}
	
	
}
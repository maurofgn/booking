package org.mf.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.mf.model.Persona;
import org.mf.model.Societa;

public class PersonaDao extends Dao {
	
	private static final String TABLE_NAME = "persona";

	public PersonaDao() {
		super();
	}
	
	@Override
	String getTableName() {
		return TABLE_NAME;
	}

	public void check(Persona persona) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("select nome from persona where id = ?");
			ps.setInt(1, persona.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				update(persona);	
			} else {
				add(persona);
			}
		} catch (SQLException ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
	}

	public void add(Persona persona) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO persona "); 
		sb.append("(nome ,cognome ,citta ,prov ,indirizzo ,telefono    ,mail ,cod_Fisc ,psw ,utente ,ruolo ,nascita ,sesso) VALUES "); 
		sb.append("(?    ,?       ,?     ,?    ,?         ,?           ,?    ,?        ,?   ,?      ,?     ,?       ,?    ) ");
		//          1     2        3      4     5          6            7     8        9     0       1      2        3

		try {
			PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
			
			stmtPara(stmt, 1, Types.VARCHAR, persona.getNome());
			stmtPara(stmt, 2, Types.VARCHAR, persona.getCognome());
			stmtPara(stmt, 3, Types.VARCHAR, persona.getCitta());
			stmtPara(stmt, 4, Types.VARCHAR, persona.getProv());
			stmtPara(stmt, 5, Types.VARCHAR, persona.getIndirizzo());
			stmtPara(stmt, 6, Types.VARCHAR, persona.getTelefono());
			stmtPara(stmt, 7, Types.VARCHAR, persona.getMail());
			stmtPara(stmt, 8, Types.VARCHAR, persona.getCodFisc() );
			stmtPara(stmt, 9, Types.VARCHAR, persona.getPsw());
			stmtPara(stmt, 10, Types.VARCHAR, persona.getUtente());
			stmtPara(stmt, 11, Types.VARCHAR, persona.getRuolo().toString());
			stmtPara(stmt, 12, Types.DATE, new java.sql.Date(persona.getNascita().getTime()));
			stmtPara(stmt, 13, Types.VARCHAR, persona.getSesso().toString());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Persona persona) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE persona SET "); 
		sb.append("nome=?, "); 			//1
		sb.append("cognome=?, "); 		//2
		sb.append("citta=?, "); 		//3
		sb.append("prov=?, "); 			//4
		sb.append("indirizzo=?, "); 	//5
		sb.append("telefono=?, "); 		//6
		sb.append("mail=?, "); 			//7
		sb.append("cod_Fisc=?, "); 		//8
		sb.append("psw=?, "); 			//9
		sb.append("utente=?, "); 		//10
		sb.append("ruolo=?, "); 		//11
		sb.append("nascita=?, "); 		//12
		sb.append("sesso=? "); 			//13
		sb.append("WHERE ");
		sb.append("id = ? ");			//14
		
		try {
			
			PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
			
			stmtPara(stmt, 1, Types.VARCHAR, persona.getNome());
			stmtPara(stmt, 2, Types.VARCHAR, persona.getCognome());
			stmtPara(stmt, 3, Types.VARCHAR, persona.getCitta());
			stmtPara(stmt, 4, Types.VARCHAR, persona.getProv());
			stmtPara(stmt, 5, Types.VARCHAR, persona.getIndirizzo());
			stmtPara(stmt, 6, Types.VARCHAR, persona.getTelefono());
			stmtPara(stmt, 7, Types.VARCHAR, persona.getMail());
			stmtPara(stmt, 8, Types.VARCHAR, persona.getCodFisc());
			stmtPara(stmt, 9, Types.VARCHAR, persona.getPsw());
			stmtPara(stmt, 10, Types.VARCHAR, persona.getUtente());
			stmtPara(stmt, 11, Types.VARCHAR, persona.getRuolo());
			stmtPara(stmt, 12, Types.DATE, new java.sql.Date(persona.getNascita().getTime()));
			stmtPara(stmt, 13, Types.VARCHAR, persona.getSesso());
			stmtPara(stmt, 14, Types.INTEGER, persona.getId());
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Persona> getAll() {
		List<Persona> retValue = new ArrayList<Persona>();

		try {
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from persona");
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
	 * @return il primo ammistratore
	 */
	public Persona getOneAmministratore() {
		Persona retValue = null;
		
		try {
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from persona where ruolo = 'A' order by id");
			if (rs.next()) 
				retValue = assignBean(rs);				
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retValue;
	}
	
	public List<Societa> getSocieta(int personaId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select "); 
		sb.append("so.* "); 
		sb.append("from socio s "); 
		sb.append("inner join societa so on so.id = s.societa_id "); 
		sb.append("where s.persona_id = ?");
		
		List<Societa> retValue = new ArrayList<Societa>();
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sb.toString());
			ps.setInt(1, personaId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Societa soc = new Societa();
				
				soc.setId(rs.getInt("id"));
				soc.setNome(rs.getString("nome"));
				soc.setCitta(rs.getString("citta"));
				soc.setProv(rs.getString("prov"));
				soc.setIndirizzo(rs.getString("indirizzo"));
				soc.setCodiceFederale(rs.getString("codice_Federale"));
				soc.setGiorniRitardoAmmesso(rs.getInt("giorni_Ritardo_Ammesso"));
				soc.setSite(rs.getString("site"));
				soc.setMail(rs.getString("mail"));
				
				retValue.add(soc);
			}
			ps.close();
		} catch (SQLException ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
		
		return retValue;
	}


	public Persona getById(int id) {
		return (Persona)super.getById(id);
	}
	
	Persona assignBean(ResultSet rs) throws SQLException {
		Persona retValue = new Persona();
		retValue.setId(rs.getInt("id"));
		retValue.setNome(rs.getString("nome"));
		retValue.setCognome(rs.getString("cognome"));
		retValue.setCitta(rs.getString("citta"));
		retValue.setProv(rs.getString("prov"));
		retValue.setIndirizzo(rs.getString("indirizzo"));
		retValue.setTelefono(rs.getString("telefono"));
		retValue.setMail(rs.getString("mail"));
		retValue.setCodFisc(rs.getString("cod_Fisc"));
		retValue.setPsw(rs.getString("psw"));
		retValue.setUtente(rs.getString("utente"));
		retValue.setRuolo(rs.getString("ruolo"));
		retValue.setNascita(rs.getDate("nascita"));
		retValue.setSesso(rs.getString("sesso"));
		return retValue;
	}

}

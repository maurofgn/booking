package org.mf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mf.model.Persona;
import org.mf.util.Database;


public class PersonaDao {

	private Connection connection;

	public PersonaDao() {
		connection = Database.getConnection();
	}

	public void check(Persona persona) {
		try {
			PreparedStatement ps = connection.prepareStatement("select nome from persona where id = ?");
			ps.setInt(1, persona.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) // found
			{
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
			PreparedStatement stmt = connection.prepareStatement(sb.toString());
			// Parameters start with 1
			
			stmt.setString(1, persona.getNome());
			stmt.setString(2, persona.getCognome());
			stmt.setString(3, persona.getCitta());
			stmt.setString(4, persona.getProv());
			stmt.setString(5, persona.getIndirizzo());
			stmt.setString(6, persona.getTelefono());
			stmt.setString(7, persona.getMail());
			stmt.setString(8, persona.getCodFisc() );
			stmt.setString(9, persona.getPsw());
			stmt.setString(10, persona.getUtente());
			stmt.setString(11, persona.getRuolo().toString());
			stmt.setDate(12, new java.sql.Date(persona.getNascita().getTime()));
			stmt.setString(13, persona.getSesso().toString());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer id) {
		
		if (id == null || id == 0)
			return;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from persona where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

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
			
			PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
			// Parameters start with 1
//			System.out.println(new java.sql.Date(persona.getRegisteredon().getTime()));
			
			preparedStatement.setString(1, persona.getNome());
			preparedStatement.setString(2, persona.getCognome());
			preparedStatement.setString(3, persona.getCitta());
			preparedStatement.setString(4, persona.getProv());
			preparedStatement.setString(5, persona.getIndirizzo());
			preparedStatement.setString(6, persona.getTelefono());
			preparedStatement.setString(7, persona.getMail());
			preparedStatement.setString(8, persona.getCodFisc());
			preparedStatement.setString(9, persona.getPsw());
			preparedStatement.setString(10, persona.getUtente());
			preparedStatement.setString(11, persona.getRuolo());
			preparedStatement.setDate(12, new java.sql.Date(persona.getNascita().getTime()));
			preparedStatement.setString(13, persona.getSesso());
			preparedStatement.setInt(14, persona.getId());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Persona> getAll() {
		List<Persona> retValue = new ArrayList<Persona>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from persona");
			while (rs.next()) {
				retValue.add(assignBean(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retValue;
	}

	public Persona getById(int id) {
		Persona persona = new Persona();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from persona where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				persona = assignBean(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return persona;
	}
	
	private Persona assignBean(ResultSet rs) throws SQLException {
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

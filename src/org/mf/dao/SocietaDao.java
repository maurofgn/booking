package org.mf.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;

import org.mf.model.Societa;

public class SocietaDao extends Dao {

	private static final String TABLE_NAME = "societa";

	public SocietaDao() {
		super();
	}

	@Override
	String getTableName() {
		return TABLE_NAME;
	}

	public void check(Societa societa) {

		try {
			PreparedStatement ps = getConnection().prepareStatement(
					"select nome from societa where id = ?");
			ps.setInt(1, societa.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				update(societa);
			} else {
				add(societa);
			}
		} catch (SQLException ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}

	}

	public void add(Societa societa) {

		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO societa ");
		sb.append("(nome ,citta,prov,indirizzo,codice_federale,persona_id ,giorni_ritardo_ammesso,site,mail) VALUES ");
		sb.append("(?    ,?    ,?   ,?        ,?              ,?          ,?                     ,?   ,?   ) ");
		// 1 2 3 4 5 6 7 8 9

		try {
			PreparedStatement stmt = getConnection().prepareStatement(
					sb.toString());

			stmtPara(stmt, 1, Types.VARCHAR, societa.getNome());
			stmtPara(stmt, 2, Types.VARCHAR, societa.getCitta());
			stmtPara(stmt, 3, Types.VARCHAR, societa.getProv());
			stmtPara(stmt, 4, Types.VARCHAR, societa.getIndirizzo());
			stmtPara(stmt, 5, Types.VARCHAR, societa.getCodiceFederale());
			stmtPara(stmt, 6, Types.INTEGER, societa.getPersonaId());
			stmtPara(stmt, 7, Types.INTEGER, societa.getGiorniRitardoAmmesso());
			stmtPara(stmt, 8, Types.VARCHAR, societa.getSite());
			stmtPara(stmt, 9, Types.VARCHAR, societa.getMail());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Societa societa) {

		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE persona SET ");
		sb.append("nome=?, "); // 1
		sb.append("citta=?, "); // 2
		sb.append("indirizzo=?, "); // 3
		sb.append("prov=?, "); // 4
		sb.append("codiceFederale=?, "); // 5
		sb.append("giorniRitardoAmmesso=?, "); // 6
		sb.append("site=?, "); // 7
		sb.append("mail=?, "); // 8
		sb.append("persona=?, "); // 9
		sb.append("WHERE "); // 10
		sb.append("id = ? "); // 11

		try {

			PreparedStatement stmt = getConnection().prepareStatement(
					sb.toString());

			stmtPara(stmt, 1, Types.VARCHAR, societa.getNome());
			stmtPara(stmt, 3, Types.VARCHAR, societa.getCitta());
			stmtPara(stmt, 5, Types.VARCHAR, societa.getIndirizzo());
			stmtPara(stmt, 4, Types.VARCHAR, societa.getProv());
			stmtPara(stmt, 8, Types.VARCHAR, societa.getCodiceFederale());
			stmtPara(stmt, 9, Types.INTEGER, societa.getGiorniRitardoAmmesso());
			stmtPara(stmt, 10, Types.VARCHAR, societa.getSite());
			stmtPara(stmt, 7, Types.VARCHAR, societa.getMail());
			stmtPara(stmt, 11, Types.INTEGER, societa.getPersonaId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Societa> getAll() {
		List<Societa> retValue = new ArrayList<Societa>();

		try {
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from societa");
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
	 * @return Hashtable<Integer, Societa> tutte le società 
	 */
	public Hashtable<Integer, Societa> getAllHt() {
		List<Societa> people = getAll();
		Hashtable<Integer, Societa> retValue = new Hashtable<Integer, Societa>(people.size()); 
		for (Societa one : people) 
			retValue.put(one.getId(), one);

		return retValue;
	}

	public Societa getById(int id) {
		return (Societa) super.getById(id);
	}

	Societa assignBean(ResultSet rs) throws SQLException {

		Societa retValue = new Societa();

		retValue.setId(rs.getInt("id"));
		retValue.setNome(rs.getString("nome"));
		retValue.setCitta(rs.getString("citta"));
		retValue.setProv(rs.getString("prov"));
		retValue.setIndirizzo(rs.getString("indirizzo"));
		retValue.setCodiceFederale(rs.getString("codice_Federale"));
		retValue.setGiorniRitardoAmmesso(rs.getInt("giorni_Ritardo_Ammesso"));
		retValue.setSite(rs.getString("site"));
		retValue.setMail(rs.getString("mail"));
		// retValue.setPersona(rs.getString("persona"));
		return retValue;
	}

	public TreeSet<Societa> getAllOrdered() {
		return new TreeSet<Societa>(getAll());
	}

}

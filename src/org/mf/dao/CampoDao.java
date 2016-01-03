package org.mf.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.mf.model.Campo;
import org.mf.model.Fondo;

public class CampoDao extends Dao {
	
	private static final String TABLE_NAME = "campo";

	public CampoDao() {
		super();
	}
	
	@Override
	String getTableName() {
		return TABLE_NAME;
	}

	public void check(Campo campo) {
		try {
			PreparedStatement ps = getConnection().prepareStatement("select nome from campo where id = ?");
			ps.setInt(1, campo.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				update(campo);	
			} else {
				add(campo);
			}
		} catch (SQLException ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
	}

	public void add(Campo campo) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO campo "); 
		sb.append("(nome ,tipo ,descrizione,apertura_ora ,apertura_min ,chiusura_ora ,intervallo_ora ,intervallo_ore ,societa_id ,sequenza) VALUES "); 
		sb.append("(?    ,?    ,?          ,?            ,?            ,?            ,?              ,?              ,?          ,?       ) ");
		//          1     2     3           4     		  5             6             7     		  8        		  9     	  0

		try {
			PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
			
			stmtPara(stmt, 1, Types.VARCHAR, campo.getNome());
			stmtPara(stmt, 2, Types.INTEGER, campo.getTipo());
			stmtPara(stmt, 3, Types.VARCHAR, campo.getDescrizione());
			stmtPara(stmt, 4, Types.INTEGER, campo.getAperturaOra());
			stmtPara(stmt, 5, Types.INTEGER, campo.getAperturaMin());
			stmtPara(stmt, 6, Types.INTEGER, campo.getChiusuraOra());
			stmtPara(stmt, 7, Types.INTEGER, campo.getIntervalloOra());
			stmtPara(stmt, 8, Types.INTEGER, campo.getIntervalloOre());
			stmtPara(stmt, 9, Types.INTEGER, campo.getSocieta_Id());
			stmtPara(stmt, 10, Types.INTEGER, campo.getSequenza());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Campo campo) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("UPDATE campo SET "); 
		sb.append("nome=?, "); 				//1
		sb.append("tipo=?, ");  			//2
		sb.append("descrizione=?, ");  		//3
		sb.append("apertura_ora=?, ");  	//4
		sb.append("apertura_min=?, ");  	//5
		sb.append("chiusura_ora=?, ");  	//6
		sb.append("intervallo_ora=?, ");  	//7
		sb.append("intervallo_ore=?, ");  	//8
		sb.append("societa_id=?, ");  		//9
		sb.append("sequenza=? ");  			//10
		sb.append("WHERE id = ? "); 		//11
		
		try {
			
			PreparedStatement stmt = getConnection().prepareStatement(sb.toString());
			
			stmtPara(stmt, 1, Types.VARCHAR, campo.getNome());
			stmtPara(stmt, 2, Types.INTEGER, campo.getTipo());
			stmtPara(stmt, 3, Types.VARCHAR, campo.getDescrizione());
			stmtPara(stmt, 4, Types.INTEGER, campo.getAperturaOra());
			stmtPara(stmt, 5, Types.INTEGER, campo.getAperturaMin());
			stmtPara(stmt, 6, Types.INTEGER, campo.getChiusuraOra());
			stmtPara(stmt, 7, Types.INTEGER, campo.getIntervalloOra());
			stmtPara(stmt, 8, Types.INTEGER, campo.getIntervalloOre());
			stmtPara(stmt, 9, Types.INTEGER, campo.getSocieta_Id());
			stmtPara(stmt, 10, Types.INTEGER, campo.getSequenza());

			stmtPara(stmt, 11, Types.INTEGER, campo.getId());
			
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Campo> getAll() {
		List<Campo> retValue = new ArrayList<Campo>();

		try {
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from campo");
			while (rs.next()) {
				retValue.add(assignBean(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retValue;
	}

	public Campo getById(int id) {
		return (Campo)super.getById(id);
	}
	
	Campo assignBean(ResultSet rs) throws SQLException {
		Campo retValue = new Campo();
		
		retValue.setId(rs.getInt("id"));
		retValue.setTipo(Fondo.fromOrdinal(rs.getInt("tipo")));
		retValue.setNome(rs.getString("nome"));
		retValue.setDescrizione(rs.getString("descrizione"));
		retValue.setAperturaOra(rs.getInt("aperturaOra"));
		retValue.setAperturaMin(rs.getInt("aperturaMin"));
		retValue.setChiusuraOra(rs.getInt("chiusuraOra"));
		retValue.setIntervalloOra(rs.getInt("intervalloOra"));
		retValue.setIntervalloOre(rs.getInt("intervalloOre"));
		retValue.setSocieta_Id(rs.getInt("societa_ID"));
		retValue.setSequenza(rs.getInt("sequenza"));
		
		return retValue;
	}

}

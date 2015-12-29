package org.mf.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -8456588024401763035L;
	
	private static final String DB_NAME = "booking";
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "toor";
	private static final String MAX_POOL = "250"; // set your own limit
	private static final String DATABASE_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;	// + "?user" + USERNAME + "?password" + PASSWORD + "?MaxPooledStatements" + MAX_POOL;
	
	private Connection connection;
	private Properties properties;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
				
		int userId = 0;
    	String nome = null;
    	String cognome = null;		    	
//    	int societaId = 0;
//    	String societa = null;
//    	int tessera = 0;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("select p.id, p.nome, p.cognome ");
//			sb.append( ",s.societa_id, so.nome societa, s.tessera ");
			sb.append("from persona p ");
//			sb.append("left join (socio s ");
//			sb.append("inner join societa so on so.id = s.societa_id) ");
//			sb.append("on s.persona_id = p.id ");
			sb.append("where p.utente = ? ");
			sb.append("and p.psw = ? ");

			PreparedStatement pps = getConnection().prepareStatement(sb.toString());
			pps.setString(1, user);
			pps.setString(2, pwd);
			ResultSet rs = pps.executeQuery();
			if (rs.next()) {
				userId = rs.getInt("id");
				nome = rs.getString("nome");
				cognome = rs.getString("cognome");
//				societaId = rs.getInt("societa_id");
//				societa = rs.getString("societa");
//				tessera = rs.getInt("tessera");
			}
			// close connection
			pps.close();
			disconnect();
		} catch (SQLException ex) {
			ex.printStackTrace();			
		} finally {
			disconnect();
		}
		
		if (userId> 0) {
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			session.setAttribute("userId",userId);
			session.setAttribute("nome", nome);
			session.setAttribute("cognome", cognome);
//			session.setAttribute("societa_id", societaId);
//			session.setAttribute("societa", societa);
//			session.setAttribute("tessera", tessera);
			
			// setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30 * 60);
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30 * 60);
			response.addCookie(userName);
			response.sendRedirect(request.getContextPath() + "/LoginSuccess.jsp");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Utente o password non corretti.</font>");
			rd.include(request, response);
		}

	}
	
	// connect database
	private Connection getConnection() {
		if (connection == null) {
			try {
				// DriverManager.registerDriver((Driver)
				// Class.forName(DATABASE_DRIVER).newInstance());
				Class.forName(DATABASE_DRIVER);
				connection = DriverManager.getConnection(DATABASE_URL, getProperties());

			} catch (ClassNotFoundException | SQLException e) {				
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	private Properties getProperties() {
		if (properties == null) {
			properties = new Properties();
			properties.setProperty("user", USERNAME);
			properties.setProperty("password", PASSWORD);
			properties.setProperty("MaxPooledStatements", MAX_POOL);
		}
		return properties;
	}
	
	private void disconnect() {
	    if (connection != null) {
	        try {
	            connection.close();
	            connection = null;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	

}

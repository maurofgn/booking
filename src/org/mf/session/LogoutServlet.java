package org.mf.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = -8140233950282075068L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logout(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logout(request, response);
//		response.setContentType("text/html");
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("JSESSIONID")) {
//					System.out.println("JSESSIONID=" + cookie.getValue());
//					break;
//				}
//			}
//		}
//		// invalidate the session if exists
//		HttpSession session = request.getSession(false);
//		System.out.println("User=" + session.getAttribute("user"));
//		if (session != null) {
//			session.invalidate();
//		}
//		response.sendRedirect("login.html");
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					System.out.println("JSESSIONID=" + cookie.getValue());
					break;
				}
			}
		}
		// invalidate the session if exists
		HttpSession session = request.getSession(false);
		System.out.println("User=" + session.getAttribute("user"));
		if (session != null) {
			session.invalidate();
		}
		response.sendRedirect("login.html");
	}
	
}

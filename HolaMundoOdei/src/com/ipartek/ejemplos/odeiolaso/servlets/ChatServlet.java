package com.ipartek.ejemplos.odeiolaso.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/chatservlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String chat = "";
	String nombre;
	String mensajePrevio;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String mensaje = request.getParameter("mensaje");

		nombre = request.getParameter("nombre");
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();

		mensajePrevio = (String) session.getAttribute("mensaje");
		if (nombre == null)
			nombre = (String) session.getAttribute("nombre");
		chat = (String) application.getAttribute("chat");
		if (chat == null)
			chat = "";

		out.println("<html><head><meta charset='UTF-8'><title>Chat de Los Conspiranoicos</title></head><body><h1>Chat de Los Conspiranoicos</h1><ul>");
		if (nombre == null) {

			out.println("<form action='chatservlet' method='get'><fieldset><label  for='nombre'>Introduce tu Nombre</label><br><input id='nombre' name='nombre'/><br><input type='submit' value='Entrar'/></fieldset></form></ul>");

		} else {
			if (mensaje == null) {
				// String nombre = request.getParameter("nombre");

				session.setAttribute("nombre", nombre);

				if (mensajePrevio == null || !mensajePrevio.equals(chat))
					chat = (chat + "<h5>" + nombre + " Se unio a la conspiracion</h5>");

				session.setAttribute("mensaje", chat);
			} else {
				String nombre = (String) session.getAttribute("nombre");
				if (!mensajePrevio.equals(mensaje))
					chat = (chat + "<li>" + nombre + ": " + mensaje + "</li>");

				session.setAttribute("mensaje", mensaje);
			}

			application.setAttribute("chat", chat);

			out.println(chat);

			out.println("</ul>");
			out.println("<form action='chatservlet' method='get'><fieldset><label  for='mensaje'>Introduce tu Sentencia </label><input id='mensaje' name='mensaje'/><input type='submit' value='Enviar Mensaje'/></fieldset></form>");
			out.println("<form action='chatservlet' method='post'><input type='submit' value='Salir'/></form>");

		}
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("nombre", null);

		doGet(request, response);
	}

}

package com.ipartek.ejemplos.odeiolaso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.odeiolaso.dal.UsuariosDAL;
import com.ipartek.ejemplos.odeiolaso.dal.UsuariosDALUsuarioUnico;
import com.ipartek.ejemplos.odeiolaso.tipos.Usuario;

@WebServlet(name = "Saludo", urlPatterns = { "/hola" })
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");

		Usuario usuario = new Usuario(nombre, pass);

		UsuariosDAL usuariosDAL = new UsuariosDALUsuarioUnico();

		usuariosDAL.alta(new Usuario("javi", "Lete"));

		if (usuariosDAL.validar(usuario))
			out.println("Bienvenido");
		else
			out.println("Usuario no válido");

		// if (nombre == null || nombre.trim().length() == 0)
		// nombre = "Desconocido";
		// else if ("javierlete".equals(nombre) && "SuperS3creta".equals(pass))
		// out.println("Bienvenido " + nombre);
		// else
		// out.println("¿Y tu de quien eres?");

		// out.println("Hola " + nombre);
		// out.println(new java.util.Date());

	}

}

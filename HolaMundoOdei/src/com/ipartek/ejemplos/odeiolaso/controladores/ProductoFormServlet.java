package com.ipartek.ejemplos.odeiolaso.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.odeiolaso.dal.DALException;
import com.ipartek.ejemplos.odeiolaso.dal.ProductosDAL;
import com.ipartek.ejemplos.odeiolaso.tipos.Producto;

/**
 * Servlet implementation class ProductoFormServlet
 */
@WebServlet("/productoform")
public class ProductoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rutaTienda = request.getRequestDispatcher(TIendaCRUDServlet.RUTA_SERVLET_LISTADO);
		RequestDispatcher rutaFormulario = request.getRequestDispatcher(TIendaCRUDServlet.RUTA_FORMULARIO);

		Producto producto;

		String op = request.getParameter("ops");
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double precioviejo = Double.parseDouble(request.getParameter("precioviejo"));
		double precio;
		try {
			precio = Double.parseDouble(request.getParameter("precio"));
			producto = new Producto(id, nombre, descripcion, precio);
		} catch (NumberFormatException ne) {
			producto = new Producto(id, nombre, descripcion, precioviejo);
			producto.setErrores("El precio a de no es numerico");

			request.setAttribute("producto", producto);
			rutaFormulario.forward(request, response);
			return;

		}

		if (op == null) {
			request.getRequestDispatcher(TIendaCRUDServlet.RUTA_TIENDA).forward(request, response);
			return;
		}

		ServletContext application = request.getServletContext();
		ProductosDAL dal = (ProductosDAL) application.getAttribute("dal");

		switch (op) {
		case "alta":
			// dal.idNuevo();
			if (nombre != "" && precio > 0) {
				dal.alta(producto);

				response.sendRedirect("tiendacrud");
			} else {
				rutaFormulario.forward(request, response);
			}

			break;
		case "modificar":

			try {
				dal.modificar(producto);
			} catch (DALException de) {
				producto.setErrores("Producto en el limbo, resucitelo para poder usarlo");
				request.setAttribute("producto", producto);
				rutaFormulario.forward(request, response);
			}
			response.sendRedirect("tiendacrud");

			break;
		case "borrar":
			dal.borrar(producto);
			response.sendRedirect("tiendacrud");
			// rutaListado.forward(request, response);
			break;

		default:

			response.sendRedirect("tiendacrud");
			break;
		}
	}
}

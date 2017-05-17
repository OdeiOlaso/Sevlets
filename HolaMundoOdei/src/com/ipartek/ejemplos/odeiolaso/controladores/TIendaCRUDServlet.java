package com.ipartek.ejemplos.odeiolaso.controladores;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.odeiolaso.dal.DALFactory;
import com.ipartek.ejemplos.odeiolaso.dal.ProductosDAL;
import com.ipartek.ejemplos.odeiolaso.tipos.Producto;

/**
 * Servlet implementation class TIendaCRUDServlet
 */
@WebServlet("/tiendacrud")
public class TIendaCRUDServlet extends HttpServlet {
	static final String RUTA_FORMULARIO = "/WEB-INF/vistas/productoform.jsp";
	static final String RUTA_TIENDA = "/WEB-INF/vistas/tiendacrud.jsp";
	static final String RUTA_SERVLET_LISTADO = "/tiendacrud";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		ProductosDAL dal = (ProductosDAL) application.getAttribute("dal");
		int ultimoId = 0;
		try {
			ultimoId = (Integer) application.getAttribute("ultimoId");
		} catch (NullPointerException npe) {
			application.setAttribute("ultimoId", 0);
		}

		if (dal == null) {
			dal = DALFactory.getProductosDAL();

			for (int i = 1; i <= 13; i++) {

				dal.alta(new Producto(dal.idNuevo(), "Procusto" + i, "Descripcion" + i, i * 4.7));
			}

			application.setAttribute("dal", dal);
		}

		String op = request.getParameter("op");

		if (op == null) {

			Producto[] productos = dal.buscarTodosLosProductos();

			request.setAttribute("productos", productos);

			request.getRequestDispatcher(RUTA_TIENDA).forward(request, response);

		} else {

			if (ultimoId == 0 || dal.existeProducto(ultimoId)) {
				ultimoId = dal.idNuevo();
				application.setAttribute("ultimoId", ultimoId);
			}

			int id = 0;
			Producto producto;

			switch (op) {
			case "modificar":

			case "borrar":
				id = Integer.parseInt(request.getParameter("id"));
			case "alta":
				if (op.equals("alta"))

					producto = new Producto(ultimoId, "", "", 0);

				else
					producto = dal.buscarPorId(id);
				request.setAttribute("producto", producto);
				request.getRequestDispatcher(RUTA_FORMULARIO).forward(request, response);

				break;
			default:
				request.getRequestDispatcher(RUTA_TIENDA).forward(request, response);
			}
		}
	}
}

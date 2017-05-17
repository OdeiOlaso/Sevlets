package com.ipartek.ejemplos.odeiolaso.dal;

import com.ipartek.ejemplos.odeiolaso.tipos.Producto;

public interface ProductosDAL {

	public void alta(Producto producto);

	public void modificar(Producto producto);

	public void borrar(Producto producto);

	public Producto buscarPorId(Integer id);

	public Producto[] buscarTodosLosProductos();

	public boolean validar(Producto producto);

	public int idNuevo();

	public boolean existeProducto(int id);

}

package com.ipartek.ejemplos.odeiolaso.dal;

import com.ipartek.ejemplos.odeiolaso.tipos.Usuario;

public interface UsuariosDAL {

	public void alta(Usuario usuario);
	public void modificar(Usuario usuario);
	public void borrar(Usuario usuario);

	public Usuario buscarPorId(String id);
	public Usuario[] buscarTodosLosUsuarios();
	
	public boolean validar(Usuario usuario);
}

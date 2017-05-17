package com.ipartek.ejemplos.odeiolaso.dal;

import com.ipartek.ejemplos.odeiolaso.tipos.Usuario;

public class UsuariosDALUsuarioUnico implements UsuariosDAL {

	private Usuario usuario;

	@Override
	public void alta(Usuario usuario) {
		this.usuario = usuario;

	}

	@Override
	public boolean validar(Usuario usuario) {
		// return this.usuario.getNombre().equals(usuario.getNombre()) && this.equals(usuario.getPass());
		return this.usuario.equals(usuario);
	}

	@Override
	public void modificar(Usuario usuario) {
		if (!this.usuario.getNombre().equals(usuario.getNombre()))
			throw new DALException("Intento de modificar usuario no existe " + usuario);

		this.usuario = usuario;
	}

	@Override
	public void borrar(Usuario usuario) {
		if (this.usuario.equals(usuario))
			this.usuario = null;

	}

	@Override
	public Usuario buscarPorId(String id) {

		return null;
	}

	@Override
	public Usuario[] buscarTodosLosUsuarios() {

		return null;
	}

}

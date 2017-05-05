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

}

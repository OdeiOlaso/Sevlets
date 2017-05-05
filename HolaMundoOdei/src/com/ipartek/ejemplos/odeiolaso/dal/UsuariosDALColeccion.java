package com.ipartek.ejemplos.odeiolaso.dal;

import java.util.HashMap;
import java.util.Map;

import com.ipartek.ejemplos.odeiolaso.tipos.Usuario;

public class UsuariosDALColeccion implements UsuariosDAL {

	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	@Override
	public void alta(Usuario usuario) {
		if (usuarios.containsKey(usuario.getNombre()))
			throw new UsuarioYaExistenteDALException("Ya existe el usuario " + usuario.getNombre());
		usuarios.put(usuario.getNombre(), usuario);

	}

	@Override
	public boolean validar(Usuario usuario) {

		return usuarios.containsValue(usuario);
	}

}

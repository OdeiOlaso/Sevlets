package com.ipartek.ejemplos.odeiolaso.dal;

import com.ipartek.ejemplos.odeiolaso.tipos.Usuario;

public interface UsuariosDAL {
	
	public void alta(Usuario usuario);
	public boolean validar(Usuario usuario);
}

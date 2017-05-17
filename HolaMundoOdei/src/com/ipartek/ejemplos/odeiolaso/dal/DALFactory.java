package com.ipartek.ejemplos.odeiolaso.dal;

public class DALFactory {

	public static UsuariosDAL getUsuariosDAL() {
		// return new UsuariosDALUsuarioUnico();
		return new UsuariosDALColeccion();
	}

	public static ProductosDAL getProductosDAL() {
		// return new UsuariosDALUsuarioUnico();
		return new ProductosDALColeccion();
	}

}

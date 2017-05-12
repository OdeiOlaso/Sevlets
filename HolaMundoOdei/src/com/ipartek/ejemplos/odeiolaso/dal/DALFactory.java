package com.ipartek.ejemplos.odeiolaso.dal;

public class DALFactory {

	public static ProductosDAL getProductosDAL() {
		// return new UsuariosDALUsuarioUnico();
		return new ProductosDALColeccion();
	}

}

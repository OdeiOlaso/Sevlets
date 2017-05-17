<%@ include file="includes/cabecera.jsp" %>

<jsp:useBean id="usuario" scope="request" class="com.ipartek.ejemplos.odeiolaso.tipos.Usuario"/>
	<form action="alta" method="post">
		<fieldset>
			<label for="nombre">Nombre</label> 
			<input id="nombre" name="nombre" value="${usuario.nombre}" />
		</fieldset>
		<fieldset>
			<label for="pass">Contrase�a</label> 
			<input type="password" id="pass" name="pass" />
		</fieldset>
		<fieldset>
			<label for="pass2">Repite la contrase�a</label> 
			<input type="password" id="pass2" name="pass2" />
		</fieldset>
		<fieldset>
			<input type="submit" value="Alta" />
			<p class="errores">${usuario.errores}</p>
		</fieldset>
		<a href="login">Iniciar Sesion</a>
		</form>
<%@ include file="includes/pie.jsp" %>

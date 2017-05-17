><%@ include file="includes/cabecera.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h2>Matenimiento de Usuarios</h2>
<table>
	<thead>
		<tr>
			<th>Opciones</th><th>ID</th><th>Producto</th>
			<th>Descripcion</th><th>Precio</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${productos}" var="producto">
		<tr>
			<td>
			<a href="?op=modificar&id=${producto.id}">Modificar </a>
			<a href="?op=borrar&id=${producto.id}">Borrar</a></td>
			<td>${producto.id}</td>
			<td>${producto.nombre}</td>
			<td>${producto.descripcion}</td>
			<td>${producto.precio}</td>
		</tr>
</c:forEach>
	</tbody>
</table>


<a href="tiendacrud?op=alta">Alta</a>

<%@ include file="includes/pie.jsp" %>
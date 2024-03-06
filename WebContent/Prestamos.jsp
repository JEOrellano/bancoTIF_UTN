<%@page import="entidad.EstadoPrestamo"%>
<%@page import="entidad.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.Period"%>
<%@page import="entidad.Usuario"%>
<%@page import="entidad.Prestamo"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Prestamos</title>
	<style type="text/css">
		<jsp:include page="CSS\StyleSheet.css"></jsp:include>
	</style>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>	
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#table_id_prestamos_cliente_cuotas').DataTable();
		});
	</script>
</head>
<body>

<%
	String rol = "";
	String nombre = "Invitado";
	if(((Usuario)session.getAttribute("usuario")) != null) {
		rol = ((Usuario)session.getAttribute("usuario")).getRol().getDescripcion();
		nombre = ((Usuario)session.getAttribute("usuario")).getNombre();
	}
	
	// Variables admin
	Prestamo prestamo = new Prestamo();
	ArrayList<EstadoPrestamo> listaEstadosPrestamo = new ArrayList<EstadoPrestamo>(){};
	
	// Variables cliente
	Prestamo cuotasPrestamoCliente = new Prestamo();
	ArrayList<Cuenta> listaCuentasCliente = new ArrayList<Cuenta>(){};	
	
	switch(rol) {
	case "admin":
		if(request.getAttribute("prestamo") != null && request.getAttribute("listaEstadosPrestamo") != null) {
			prestamo = (Prestamo)request.getAttribute("prestamo");
			listaEstadosPrestamo = (ArrayList<EstadoPrestamo>)request.getAttribute("listaEstadosPrestamo");
		}
		break;
		
	case "cliente":
		if(request.getAttribute("listaCuentasCliente") == null) {
			response.sendRedirect("http://localhost:8080/TPINT_GRUPO_4_LAB4/ServletBanco?Param=irInicio");
		}
		else {
			listaCuentasCliente = (ArrayList<Cuenta>)request.getAttribute("listaCuentasCliente");
			cuotasPrestamoCliente = (Prestamo)request.getAttribute("cuotasPrestamoCliente");
		}
		break;
		
	default:
		response.sendRedirect("http://localhost:8080/TPINT_GRUPO_4_LAB4/ServletBanco?Param=irInicio");
		break;
	}
%>

<header>
	<div class="container-fluid m-0 py-5 mi-fondo-celeste text-center text-white m-0 p-0 ">
		<div class="row">
			<div class="col-12">
		    	<h1 class="font-weight-bold">Banco Integrador UTNFRGP</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
		    	<p class="font-italic">Laboratorio de computacion 4</p>	
			</div>
		</div>
	</div>
</header>

<nav>
	<div class="container-fluid m-0 p-0">
		<div class="row">
			<div class="col-12">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
				  <a class="navbar-brand" href="#"><%=nombre %></a>
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				  <div class="collapse navbar-collapse" id="navbarNavDropdown">
				    <ul class="navbar-nav">
				      <li class="nav-item active">
				        <a class="nav-link" href="ServletBanco?Param=irInicio">Inicio<span class="sr-only">(current)</span></a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="ServletBanco?Param=irContacto">Contacto</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="ServletBanco?Param=irPrestamos">Prestamos</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="ServletBanco?Param=irMovimientos">Movimientos</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="ServletBanco?Param=irNosotros">Nosotros</a>
				      </li>
				      <li class="nav-item dropdown">
				        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				          Usuario
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				          <% if(rol==""){ %>
				          <a class="dropdown-item" href="ServletBanco?Param=irRegistro">Registrarse</a>
				          <% } if(rol==""){ %>
				          <a class="dropdown-item" href="ServletBanco?Param=irIngreso">Iniciar sesion</a>
				          <% } if(!(rol=="")){ %>
				          <a class="dropdown-item" href="ServletBanco?Param=cerrarSesion">Cerrar sesion</a>
				          <% } %>
				        </div>
				      </li>
				    </ul>
				  </div>
				</nav>
			</div>
		</div>
	</div>
</nav>

<main>
	<div class="conteiner-fluid m-0 p-0">
		<article>
			<div class="row">
				<div class="col-12">
					<% switch(rol){
					case "admin": %>
					<section>
						<div class="row justify-content-center py-3">
							<fieldset>
								<legend>MODIFICAR Prestamo</legend>
								<form action="ServletBanco" method="post">
									<div class="row mt-3">
										<div class="col-8">
											<label for="codigoPrestamo">CODIGO Prestamo:</label>
										</div>
										<div class="col-4">
								    		<input type="number" readonly name="codigoPrestamo" value="<%=prestamo.getCodigoPrestamo() %>" placeholder="ingrese codigo prestamo" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-8">
											<label for="fechaPrestamo">FECHA Prestamo:</label>
										</div>
										<div class="col-4">
								    		<input type="date" name="fechaPrestamo" value="<%=prestamo.getFecha() %>" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-8">
											<label for="importePagar">IMPORTE pagar:</label>
										</div>
										<div class="col-4">
								    		<input type="number" name="importePagar" value="<%=prestamo.getImportePagar() %>" placeholder="ingrese importe a pagar" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-8">
											<label for="importePedido">IMPORTE pedido:</label>
										</div>
										<div class="col-4">
								    		<input type="number" name="importePedido" value="<%=prestamo.getImportePedido() %>" placeholder="ingrese importe pedido" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-8">
											<label for="plazoPago">PLAZO pago:</label>
										</div>
										<div class="col-4">
								    		<input type="number" name="plazoPago" value="<%=prestamo.getPlazoPago() %>" placeholder="ingrese plazo de pago" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-8">
											<label for="montoCuota">MONTO cuota:</label>
										</div>
										<div class="col-4">
								    		<input type="number" name="montoCuota" value="<%=prestamo.getMontoCuota() %>" placeholder="ingrese monto de cuota" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-8">
											<label for="cantidadCuotas">CANTIDAD cuotas:</label>
										</div>
										<div class="col-4">
								    		<input type="number" name="cantidadCuotas" min="0" max="588" value="<%=prestamo.getCuotas() %>" placeholder="ingrese cantidad de cuotas" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-8">
											<label for="estado">ESTADO prestamo:</label>
										</div>
										<div class="col-4">
								    		<input type="number" name="estado" value="<%=prestamo.getEstado() %>" placeholder="ingrese estado" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-8">
											<label for="estadoPrestamo">ESTADO PRESTAMO Condicion:</label>
										</div>
								    	<div class="col-4">
								    		<input type="text" name="estadoPrestamo" readonly value="<%=prestamo.getEstadoPrestamo().getDescripcion() %>" placeholder="aceptado - rechazado - pendiente" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-8">
											<label for="dniCliente">DNI Cliente:</label>
										</div>
										<div class="col-4">
								    		<input type="number" name="dniCliente" value="<%=prestamo.getCliente().getDni() %>" placeholder="ingrese dni cliente" required>
								    	</div>
									</div>
									<div class="row justify-content-center mt-3">
										<div class="col-6">
								  			<input type="submit" value="Aceptar" name="btnAceptarPrestamo" class="py-1 bg-success btn-block" <%=prestamo.getEstadoPrestamo().getDescripcion().equals(listaEstadosPrestamo.get(0).getDescripcion())?  "" : "disabled='disable'" %>>
								  		</div>
								  		<div class="col-6">
								  			<input type="submit" value="Rechazar" name="btnRechazarPrestamo" class="py-1 bg-danger btn-block" <%=prestamo.getEstadoPrestamo().getDescripcion().equals(listaEstadosPrestamo.get(0).getDescripcion())?  "" : "disabled='disable'" %>>
								  		</div>
								    </div>
								</form>
							</fieldset>
						</div>
					</section>
						<%break;
					case "cliente": %>
					<section>
						<div class="row justify-content-center py-3">
							<fieldset>
								<legend>CUOTAS prestamo</legend>
								<table id="table_id_prestamos_cliente_cuotas" class="display">
								    <thead>
								        <tr>
								        	<th>NUMERO CUOTA</th>
								        	<th>CODIGO PRESTAMO</th>
								            <th>FECHA PRESTAMO</th>
								            <th>IMPORTE PAGAR</th>
								            <th>IMPORTE PEDIDO</th>
								            <th>PLAZO PAGO</th>
								            <th>MONTO CUOTA</th>
								            <th>CUOTAS</th>
								            <th>ESTADO</th>
								            <th>ESTADO PRESTAMO</th>
								            <th>DNI CLIENTE</th>
								        </tr>
								    </thead>
								    <tbody>
								      	<%  
										for(int i = (1 + (cuotasPrestamoCliente.getPlazoPago() - cuotasPrestamoCliente.getCuotas())); i <= cuotasPrestamoCliente.getCuotas(); i++) 
										{
										%>
										<tr>
											<th> <%=i %> </th>
											<td><%=cuotasPrestamoCliente.getCodigoPrestamo() %> 
											<td><%=cuotasPrestamoCliente.getFecha() %></td>   
											<td><%=cuotasPrestamoCliente.getImportePagar() %></td>
											<td><%=cuotasPrestamoCliente.getImportePedido() %></td>
											<td><%=cuotasPrestamoCliente.getPlazoPago() %></td>
											<td><%=cuotasPrestamoCliente.getMontoCuota() %></td>
											<td><%=cuotasPrestamoCliente.getCuotas() %></td>
											<td><%=cuotasPrestamoCliente.getEstado() %></td>
											<td><%=cuotasPrestamoCliente.getEstadoPrestamo().getDescripcion() %></td>
											<td><%=cuotasPrestamoCliente.getCliente().getDni() %></td>
										</tr>
									<%  } %>
								    </tbody>
								</table>
							</fieldset>
						</div>
					</section>
					<hr class="my-5">
					<section>
						<div class="row justify-content-center py-3">
							<fieldset>
								<legend><b>PAGAR Cuota</b></legend>
								<form action="ServletBanco" method="post">
										<div class="row pt-3">
								        	<div class="col-6">NUMERO CUENTA</div>
								        	<div class="col-5">SALDO CUENTA</div>
								        	<div class="col-1">ELIJA</div>
										</div>
											<%for(Cuenta cc : listaCuentasCliente){	%>
										<div class="row pt-1">
											<div class="col-6"><%=cc.getNumeroCuenta() %></div>
								        	<div class="col-5"><%=cc.getSaldo() %></div>
								        	<div class="col-1"><input type="radio" name="cuentasPagarCuota" value="<%=cc.getNumeroCuenta() %>"></div>
										</div>
											<%} %>
									<div class="row pt-3">
											<div class="col-5">
								        		<label for="montoPagarCuota">MONTO Pagar:</label>
											</div>
											<div class="col-7">
								        		<input type="text" name="montoPagarCuota" readonly value="<%=cuotasPrestamoCliente.getMontoCuota() %>"><br>
											</div>
									</div>
									<div class="row pt-3">
										<div class="col-5">
											<label for="montoPagarCuota">CUOTA Pagar:</label>
										</div>
										<div class="col-7">
											<select name="prestamoCuotaPagar">
											<% for(int i = (1 + (cuotasPrestamoCliente.getPlazoPago() - cuotasPrestamoCliente.getCuotas())); i <= cuotasPrestamoCliente.getCuotas(); i++) {%>
												<option value="<%=cuotasPrestamoCliente.getCodigoPrestamo() %>"><%="CUOTA N° " + i %></option>
											<%} %>
											</select>
										</div>
									</div> 
									<div class="row py-3">
										<div class="col-5">
											<input type="submit" value="Pagar Cuota" name="btnPagrCuotaPrestamoCliente" class="mt-1 bg-warning">
										</div>
									</div>
							    </form>
							</fieldset>
						</div>
					</section>
						<%break;
					default: %>
					<section>
						<div class="row justify-content-center pt-3">
							<p>seccion prestamos default</p>
						</div>
					</section>
						<%break;}%>
				</div>
			</div>
		</article>
	</div>
</main>

<footer>	
    <div class="container-fluid m-0 py-5 mi-fondo-celeste text-white">
        <div class="row justify-content-center">
	        <p class="font-weight-bold">Laboratorio de computacion 4</p>
    	</div>
	    <div class="row justify-content-center">
	        <small>&copy; Copyright <%= LocalDate.now().getYear() %> <b>UTN FRGP</b> - Todos los Derechos Reservados</small>
	    </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
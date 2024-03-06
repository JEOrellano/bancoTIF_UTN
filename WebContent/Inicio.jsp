<%@page import="entidad.Prestamo"%>
<%@page import="entidad.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Usuario"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inicio</title>
	<style type="text/css">
		<jsp:include page="CSS\Reset.css"></jsp:include>
	</style>
	<style type="text/css">
		<jsp:include page="CSS\StyleSheet.css"></jsp:include>
	</style>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
	
	<link rel="stylesheet" type="footer/css" href="StyleSheet.css">
		
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#table_id_clientes').DataTable();
		});
		
		$(document).ready(function() {
			$('#table_id_cuentas').DataTable();
		});
		
		$(document).ready(function() {
			$('#table_id_prestamos').DataTable();
		});
		
		$(document).ready(function() {
			$('#table_id_prestamos_estadisticas').DataTable();
		});
		
		$(document).ready(function() {
			$('#table_id_cuentas_cliente').DataTable();
		});
		
		$(document).ready(function() {
			$('#table_id_prestamos_cliente').DataTable();
		});
	</script>
</head>

<body>
<%
	String rol = "";
	String nombre = "Invitado";
	
	// variables admin
	ArrayList<Usuario> listaClientes = new ArrayList<Usuario>(){};
	ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>(){};
	ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>(){};
	
	
	// variables clientes
	ArrayList<Cuenta> listaCuentasCliente = new ArrayList<Cuenta>(){};
	ArrayList<Prestamo> listaPrestamosCliente = new ArrayList<Prestamo>(){};
	
	if(((Usuario)session.getAttribute("usuario")) != null) {
		rol = ((Usuario)session.getAttribute("usuario")).getRol().getDescripcion();
		nombre = ((Usuario)session.getAttribute("usuario")).getNombre();
	}
	
	switch(rol) {
	case "admin":
		if(request.getAttribute("listaClientes") != null && request.getAttribute("listaCuentas") != null && request.getAttribute("listaPrestamos") != null) {
			listaClientes = (ArrayList<Usuario>)request.getAttribute("listaClientes");
			listaCuentas = (ArrayList<Cuenta>)request.getAttribute("listaCuentas");
			listaPrestamos = (ArrayList<Prestamo>)request.getAttribute("listaPrestamos");
		}
		break;
		
	case "cliente":
		if(request.getAttribute("listaCuentasCliente") != null) {
			listaCuentasCliente = (ArrayList<Cuenta>)request.getAttribute("listaCuentasCliente");
		}
		if(request.getAttribute("listaPrestamosCliente") != null) {
			listaPrestamosCliente = (ArrayList<Prestamo>)request.getAttribute("listaPrestamosCliente");
		}
		break;
		
	default:
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
	<div class="container-fluid m-0 px-3">
		<article>
			<div class="row">
				<div class="col-12">
					<% switch(rol){
					case "admin": %>
					<section>
						<div class="row justify-content-center pt-3 px-3">
							<fieldset>
								<legend>ABML Clientes</legend>
								<table id="table_id_clientes" class="display">
								    <thead>
								        <tr>
								            <th></th>
								            <th>DNI</th>
								            <th>CUIL</th>
								            <th>NOMBRE</th>
								            <th>APELLIDO</th>
								            <th>NACIONALIDAD</th>
								            <th>FECHA NACIMIENTO</th>
								            <th>DIRECCION</th>
								            <th>LOCALIDAD</th>
								            <th>PROVINCIA</th>
								            <th>CORREO ELECTRONICO</th>
								            <th>TELEFONO</th>
								            <th>USUARIO</th>
								            <th>CONTRASEÑA</th>
								            <th>ESTADO</th>
								            <th>SEXO</th>
								            <th>ROL</th>
								        </tr>
								    </thead>
								    <tbody>
								      	<%  
										for(Usuario usuario : listaClientes) 
										{
										%>
										<tr>  
										    <form name="formulario" action="" method="post">
												<td> <input type="submit" name="btnVerCliente" value="Ver" class="bg-warning"> </td>
												<td><%=usuario.getDni() %>    <input type="hidden" name="idUsuario" value="<%=usuario.getDni()%>"> </td> 
												<td><%=usuario.getCuil() %></td>   
												<td><%=usuario.getNombre()%></td>
												<td><%=usuario.getApellido() %></td>
												<td><%=usuario.getNacionalidad() %></td>
												<td><%=usuario.getFechaNacimiento() %></td>
												<td><%=usuario.getDireccion() %></td>
												<td><%=usuario.getLocalidad() %></td>
												<td><%=usuario.getProvincia() %></td>
												<td><%=usuario.getCorreoElectronico() %></td>
												<td><%=usuario.getTelefono() %></td>
												<td><%=usuario.getUsuario() %></td>
												<td><%=usuario.getContrasena() %></td>
												<td><%=usuario.getEstado() %></td>
												<td><%=usuario.getSexo().getDescripcion() %></td>
												<td><%=usuario.getRol().getDescripcion() %></td>
											</form> 
										</tr>
									<%  } %>
								    </tbody>
								</table>
							</fieldset>
						</div>
					</section>
					<hr class="my-5">
					<section>
						<div class="row justify-content-center pt-3 px-3">
							<fieldset>
								<legend>ABML Cuentas</legend>
								<table id="table_id_cuentas" class="display">
								    <thead>
								        <tr>
								            <th>NUMERO CUENTA</th>
								            <th>FECHA CREACION</th>
								            <th>CBU</th>
								            <th>SALDO</th>
								            <th>ESTADO</th>
								            <th>TIPO CUENTA</th>
								            <th>DNI CLIENTE</th>
								            <th></th>
								        </tr>
								    </thead>
								    <tbody>
								      	<%  
										for(Cuenta cuenta : listaCuentas) 
										{
										%>
										<tr>  
										    <form name="formulario" action="" method="post">
												<td><%=cuenta.getNumeroCuenta() %>    <input type="hidden" name="idCuenta" value="<%=cuenta.getNumeroCuenta()%>"> </td> 
												<td><%=cuenta.getFechaCreacion() %></td>   
												<td><%=cuenta.getCbu() %></td>
												<td><%=cuenta.getSaldo() %></td>
												<td><%=cuenta.getEstado() %></td>
												<td><%=cuenta.getTipoCuenta().getDescripcion() %></td>
												<td><%=cuenta.getCliente().getDni() %></td>
												<td> <input type="submit" name="btnVerCuenta" value="Ver" class="bg-warning"> </td>   
											</form> 
										</tr>
									<%  } %>
								    </tbody>
								</table>
							</fieldset>
						</div>
					</section>
					<hr class="my-5">
					<section>
						<div class="row justify-content-center pt-3 px-3">
							<fieldset>
								<legend>ABML Prestamos</legend>
								<table id="table_id_prestamos" class="display">
								    <thead>
								        <tr>
								            <th>CODIGO PRESTAMO</th>
								            <th>FECHA PEDIDO</th>
								            <th>IMPORTE PAGAR</th>
								            <th>IMPORTE PEDIDO</th>
								            <th>PLAZO PAGO</th>
								            <th>MONTO CUOTA</th>
								            <th>CUOTAS</th>
								            <th>ESTADO</th>
								            <th>ESTADO PRESTAMO</th>
								            <th>DNI CLIENTE</th>
								            <th></th>
								        </tr>
								    </thead>
								    <tbody>
								      	<%  
										for(Prestamo prestamo : listaPrestamos) 
										{
										%>
										<tr>  
										    <form name="formulario" action="" method="post">
												<td><%=prestamo.getCodigoPrestamo() %>    <input type="hidden" name="idPrestamo" value="<%=prestamo.getCodigoPrestamo()%>"> </td> 
												<td><%=prestamo.getFecha() %></td>   
												<td><%=prestamo.getImportePagar() %></td>
												<td><%=prestamo.getImportePedido() %></td>
												<td><%=prestamo.getPlazoPago() %></td>
												<td><%=prestamo.getMontoCuota() %></td>
												<td><%=prestamo.getCuotas() %></td>
												<td><%=prestamo.getEstado() %></td>
												<td><%=prestamo.getEstadoPrestamo().getDescripcion() %></td>
												<td><%=prestamo.getCliente().getDni() %></td>
												<td> <input type="submit" name="btnVerPrestamo" value="Ver" class="bg-warning"> </td>   
											</form> 
										</tr>
									<%  } %>
								    </tbody>
								</table>
							</fieldset>
						</div>
					</section>
					<hr class="my-5">
					<section>
						<div class="row justify-content-center py-3 mx-5">
							<fieldset>
								<legend>ESTADISTICAS Prestamos</legend>
								<form name="formularioFiltrosEstadistica" action="" method="post">
							    	<div class="row py-3">
							    		<div class="col-4">
									    	<label>Busqueda por importe: </label>
							    		</div>
							    		<div class="col-4">
											<input type="number" placeholder="Ingrese monto minimo" min="0" name="montoMinimo">
							    		</div>
							    		<div class="col-4">
									    	<input type="number" placeholder="Ingrese monto maximo" name="montoMaximo">
							    		</div>
							    	</div>
							    	<div class="row pb-3">
							    		<div class="col-4">
									    	<label>Busqueda por fechas: </label>
							    		</div>
							    		<div class="col-4">
											<input type=date max="<%=LocalDate.now() %>" name="fechaMinimo">
							    		</div>
							    		<div class="col-4">
									    	<input type="date" max="<%=LocalDate.now() %>" name="fechaMaximo">
							    		</div>
							    	</div>
							    	<div class="row pb-3">
							    		<div class="col-4">
									    	<label>Busqueda por cuotas: </label>
							    		</div>
							    		<div class="col-4">
											<input type="number" placeholder="minimas" min="0" max="588" name="cuotaMinimo" />
							    		</div>
							    		<div class="col-4">
									    	<input type="number" min="0" max="588" name="cuotaMaximo" placeholder="maximas" />
									    	
							    		</div>
							    	</div>
							    	<div class="row pb-3">
							    		<div class="col-12">
								    		<input type="submit" value="Filtrar" name="btnFiltrarPrestamos" class="bg-warning"/>
							    		</div>
							    	</div>
								</form>
								<table id="table_id_prestamos_estadisticas" class="display">
								    <thead>
								        <tr>
								            <th>CODIGO PRESTAMO</th>
								            <th>FECHA PEDIDO</th>
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
										for(Prestamo prestamo : listaPrestamos) 
										{
										%>
										<tr>
											<td><%=prestamo.getCodigoPrestamo() %>
											<td><%=prestamo.getFecha() %></td>   
											<td><%=prestamo.getImportePagar() %></td>
											<td><%=prestamo.getImportePedido() %></td>
											<td><%=prestamo.getPlazoPago() %></td>
											<td><%=prestamo.getMontoCuota() %></td>
											<td><%=prestamo.getCuotas() %></td>
											<td><%=prestamo.getEstado() %></td>
											<td><%=prestamo.getEstadoPrestamo().getDescripcion() %></td>
											<td><%=prestamo.getCliente().getDni() %></td>
										</tr>
									<%  } %>
								    </tbody>
								</table>
							</fieldset>
						</div>
					</section>
						<%break;
					case "cliente": %>
					<section>
						<div class="row justify-content-center pt-3">
							<fieldset>
								<legend>DATOS Cliente</legend>
								<div class="row mt-3">
									<div class="col-5">
										<lable>DNI</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getDni() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>CUIL</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getCuil() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Nombre</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getNombre() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Apellido</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getApellido() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Nacionalidad</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getNacionalidad() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Fecha Nacimiento</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getFechaNacimiento() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Direccion</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getDireccion() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Localidad</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getLocalidad() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Provincia</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getProvincia() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Correo electronico</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getCorreoElectronico() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Telefono</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getTelefono() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Usuario</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getUsuario() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Contraseña</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getContrasena() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Estado</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getEstado() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Sexo</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getSexo().getDescripcion() %>"></input>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-5">
										<lable>Rol</lable>
									</div>
									<div class="col-7">
										<input type="text" readonly disabled value="<%= ((Usuario)session.getAttribute("usuario")).getRol().getDescripcion() %>"></input>
									</div>
								</div>
							</fieldset>
						</div>
					</section>
					<hr class="my-5">
					<section>
						<div class="row justify-content-center pt-3 mx-0">
							<fieldset>
								<legend>CUENTAS Cliente</legend>
								<div class="row mt-3">
									<table id="table_id_cuentas_cliente" class="display">
								    <thead>
								        <tr>
								            <th>Numero cuenta</th>
								            <th>Fecha Creacion</th>
								            <th>CBU</th>
								            <th>Saldo</th>
								            <th>Estado</th>
								            <th>Tipo Cuenta</th>
								            <th>DNI Cliente</th>
								            <th></th>
								        </tr>
								    </thead>
								    <tbody>
								      	<%  
										for(Cuenta cuenta : listaCuentasCliente) 
										{
										%>
										<tr>  
										    <form name="formulario" action="ServletBanco" method="post">
												<td><%=cuenta.getNumeroCuenta() %>    <input type="hidden" name="idCuentaCliente" value="<%=cuenta.getNumeroCuenta()%>"> </td> 
												<td><%=cuenta.getFechaCreacion() %></td>   
												<td><%=cuenta.getCbu() %></td>
												<td><%=cuenta.getSaldo() %></td>
												<td><%=cuenta.getEstado() %></td>
												<td><%=cuenta.getTipoCuenta().getDescripcion() %></td>
												<td><%=cuenta.getCliente().getDni() %></td>
												<td> <input type="submit" name="btnCuentaCliente" value="Ver Cuenta" class="bg-warning"> </td>   
											</form> 
										</tr>
									<%  } %>
								    </tbody>
								</table>
								</div>
							</fieldset>
						</div>
					</section>
					<hr class="my-5">
					<section>
						<div class="row justify-content-center py-3 mx-0">
							<fieldset>
								<legend>PRESTAMOS Cliente</legend>
								<div class="row mt-3">
									<table id="table_id_prestamos_cliente" class="display">
									    <thead>
									        <tr>
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
									            <th></th>
									        </tr>
									    </thead>
									    <tbody>
									      	<%  
											for(Prestamo prestamo : listaPrestamosCliente) 
											{
											%>
											<tr>  
											    <form name="formulario" action="ServletBanco" method="post">
													<td><%=prestamo.getCodigoPrestamo() %>    <input type="hidden" name="idPrestamoCliente" value="<%=prestamo.getCodigoPrestamo()%>"> </td> 
													<td><%=prestamo.getFecha() %></td>   
													<td><%=prestamo.getImportePagar() %></td>
													<td><%=prestamo.getImportePedido() %></td>
													<td><%=prestamo.getPlazoPago() %></td>
													<td><%=prestamo.getMontoCuota() %></td>
													<td><%=prestamo.getCuotas() %></td>
													<td><%=prestamo.getEstado() %></td>
													<td><%=prestamo.getEstadoPrestamo().getDescripcion() %></td>
													<td><%=prestamo.getCliente().getDni() %></td>
													<td> <input type="submit" name="btnPrestamoCliente" value="Ver Prestamo" class="bg-warning"> </td>
												</form> 
											</tr>
										<%  } %>
									    </tbody>
									</table>
								</div>
							</fieldset>
						</div>
					</section>
						<%break;
					default: %>
					<section>
						<div class="row justify-content-center pt-3">
							<iframe width="560" height="315" src="https://www.youtube.com/embed/sckOZthNRiM?si=OBZealrOq53cHn4f" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
						</div>
					</section>
					<section>
						<div class="row justify-content-center pt-3">
							<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
							  <ol class="carousel-indicators">
							    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
							    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
							  </ol>
							  <div class="carousel-inner">
							    <div class="carousel-item active">
							      <img class="d-block w-100" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5tDnaCtprThQg4g7HjyjJE24ZqZv-Dkq9uQ&usqp=CAU slide" alt="First slide">
							    </div>
							    <div class="carousel-item">
							      <img class="d-block w-100" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5tDnaCtprThQg4g7HjyjJE24ZqZv-Dkq9uQ&usqp=CAU slide" alt="Second slide">
							    </div>
							    <div class="carousel-item">
							      <img class="d-block w-100" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5tDnaCtprThQg4g7HjyjJE24ZqZv-Dkq9uQ&usqp=CAU slide" alt="Third slide">
							    </div>
							  </div>
							  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
							    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
							    <span class="sr-only">Previous</span>
							  </a>
							  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
							    <span class="carousel-control-next-icon" aria-hidden="true"></span>
							    <span class="sr-only">Next</span>
							  </a>
							</div>
						</div>
					</section>
					<section>
						<div class="row justify-content-center font-italic font-weight-bold pt-3">
							<p>Obtene tu cuenta gratuita!</p>
						</div>
						<div class="row justify-content-center pb-3">
							<a href="ServletBanco?Param=irRegistro" class="text-warning">Click aqui!</a>
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
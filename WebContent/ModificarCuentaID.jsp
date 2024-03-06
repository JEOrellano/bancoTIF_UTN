<%@page import="entidad.TipoCuenta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Cuenta"%>
<%@page import="entidad.Usuario"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Modificar Cuenta</title>
	<style type="text/css">
		<jsp:include page="CSS\StyleSheet.css"></jsp:include>
	</style>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body>
<%
	String rol = "";
	String nombre = "Invitado";
	if(((Usuario)session.getAttribute("usuario")) != null) {
		rol = ((Usuario)session.getAttribute("usuario")).getRol().getDescripcion();
		nombre = ((Usuario)session.getAttribute("usuario")).getNombre();
	}
	
	Cuenta cuentaID = new Cuenta();
	ArrayList<TipoCuenta> listaTiposCuentas = new ArrayList<TipoCuenta>(){};
	int proximoIDCuenta = 0;
	
	switch(rol) {
	case "admin":
		if(request.getAttribute("cuentaID") == null) {
			response.sendRedirect("http://localhost:8080/TPINT_GRUPO_4_LAB4/ServletBanco?Param=irInicio");
		}
		else {
			if(request.getAttribute("listaTiposCuentas") != null) {
				listaTiposCuentas = (ArrayList<TipoCuenta>)request.getAttribute("listaTiposCuentas"); 
			}
			if (request.getAttribute("proximoIDCuenta") != null) {
				proximoIDCuenta = (int)request.getAttribute("proximoIDCuenta");
			}
			cuentaID = (Cuenta)request.getAttribute("cuentaID");
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
				        <a class="nav-link" href="ServletBanco?Param=irModificarClienteID">Modificar Cliente</a>
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
					<section>
						<div class="row justify-content-center py-3">
							<fieldset>
								<legend>MODIFICAR Cuenta</legend>
								<form action="ServletBanco" method="post">
									<div class="row mt-3">
										<div class="col-6">
											<label for="numeroCuenta">NUMERO cuenta:</label>
										</div>
										<div class="col-6">
								    		<input type="number" readonly name="numeroCuenta" readonly value="<%=cuentaID.getNumeroCuenta() %>" placeholder="ingrese numero cuenta" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-6">
											<label for="fechaCreacion">FECHA CREACION Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="date" name="fechaCreacion" value="<%=cuentaID.getFechaCreacion() %>" placeholder="ingrese fecha creacion" required>
								    	</div>
									</div>
								    <div class="row mt-3">
										<div class="col-6">
											<label for="cbu">CBU Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="number" name="cbu" value="<%=cuentaID.getCbu() %>" placeholder="ingrese cbu" required>
								    	</div>
									</div>
								    <div class="row mt-3">
										<div class="col-6">
											<label for="saldo">SALDO Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="number" name="saldo" value="<%=cuentaID.getSaldo() %>" placeholder="ingrese saldo" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-6">
											<label for="estado">ESTADO Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="number" min="0" max="1" name="estado" value="<%=cuentaID.getEstado() %>" placeholder="ingrese estado" required>
								    	</div>
									</div>
								    <div class="row mt-3">
										<div class="col-6">
											<label for="tipo">TIPO Cuenta</label>
										</div>
										<div class="col-6">
								    		<select name="tipo" required>
												<% for(TipoCuenta tiposCuentas : listaTiposCuentas) {%>
													<option value="<%=tiposCuentas.getCodigoTipoCuenta() %>"><%=tiposCuentas.getDescripcion() %></option>
												<%} %>
											</select>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-6">
											<label for="idCliente">DNI CLIENTE Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="text" name="idCliente" value="<%=cuentaID.getCliente().getDni() %>" placeholder="ingrese dni cliente" required>
								    	</div>
									</div>
								    <div class="row justify-content-center mt-3">
										<div class="col-6">
								  			<input type="submit" value="Editar" name="btnEditarCuenta" class="py-1 bg-warning btn-block">
								  		</div>
								  		<div class="col-6">
								  			<input type="submit" value="Borrar" name="btnBorrarCuenta" class="py-1 bg-danger btn-block">
								  		</div>
								    </div>
								</form>
							</fieldset>
						</div>
					</section>
					<hr/ class="my-5">
					<section>
						<div class="row justify-content-center py-3">
							<fieldset>
								<legend>AGREGAR Cuenta</legend>
								<form action="ServletBanco" method="post">
									<div class="row mt-3">
										<div class="col-12">
								    		<input type="hidden" name="numeroCuentaActual" readonly value="<%=cuentaID.getNumeroCuenta() %>" placeholder="ingrese numero cuenta" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-6">
											<label for="numeroCuenta">NUMERO cuenta:</label>
										</div>
										<div class="col-6">
								    		<input type="number" name="numeroCuenta" readonly value="<%=proximoIDCuenta %>" min="1" placeholder="ingrese numero cuenta" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-6">
											<label for="fechaCreacion">FECHA CREACION Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="date" name="fechaCreacion" value="<%=LocalDate.now() %>" max="<%=LocalDate.now() %>" placeholder="ingrese fecha creacion" required>
								    	</div>
									</div>
								    <div class="row mt-3">
										<div class="col-6">
											<label for="cbu">CBU Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="number" name="cbu" placeholder="ingrese cbu" required>
								    	</div>
									</div>
										<div class="col-12">
							  				<small class="text-danger"><%=request.getAttribute("mensajeAvisoCBU") != null ? request.getAttribute("mensajeAvisoCBU") : "" %></small>
							    		</div>
								    <div class="row mt-3">
										<div class="col-6">
											<label for="saldo">SALDO Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="number" name="saldo" value="10000" placeholder="ingrese saldo" required>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-6">
											<label for="estado">ESTADO Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="number" name="estado" value="1" min="0" max="1" placeholder="ingrese estado" required>
								    	</div>
									</div>
								    <div class="row mt-3">
										<div class="col-6">
											<label for="tipo">TIPO Cuenta</label>
										</div>
										<div class="col-6">
								    		<select name="tipo" required>
												<% for(TipoCuenta tiposCuentas : listaTiposCuentas) {%>
													<option value="<%=tiposCuentas.getCodigoTipoCuenta() %>"><%=tiposCuentas.getDescripcion() %></option>
												<%} %>
											</select>
								    	</div>
									</div>
									<div class="row mt-3">
										<div class="col-6">
											<label for="idCliente">DNI CLIENTE Cuenta</label>
										</div>
										<div class="col-6">
								    		<input type="text" name="idCliente" placeholder="ingrese dni cliente" required>
								    	</div>
									</div>
									<div class="col-12">
						  				<small class="text-danger"><%=request.getAttribute("mensajeAviso3Cuentas") != null ? request.getAttribute("mensajeAviso3Cuentas") : "" %></small>
						    		</div>
								    <div class="row justify-content-center mt-3">
								  		<div class="col-12">
								  			<input type="submit" value="Agregar" name="btnAgregarCuenta" class="py-1 bg-success btn-block">
								  		</div>
								    </div>
								</form>
							</fieldset>
						</div>
					</section>
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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
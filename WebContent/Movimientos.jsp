<%@page import="entidad.Movimiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Usuario"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Movimientos</title>
		<style type="text/css">
			<jsp:include page="CSS\StyleSheet.css"></jsp:include>
		</style>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>	
		<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#table_id_cuentas_cliente_movimiento').DataTable();
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

	
	
	ArrayList<Movimiento> listaMovimientosCuentaCliente = new ArrayList<Movimiento>(){};
	double saldoCuentaCliente = 0;
	int numeroCuentaCliente = 0;
	
	switch(rol) {
	case "admin":
		break;
		
	case "cliente":
		if(request.getAttribute("listaMovimientosCuentaCliente") == null) {
			response.sendRedirect("http://localhost:8080/TPINT_GRUPO_4_LAB4/ServletBanco?Param=irInicio");		
		}
		else {
			listaMovimientosCuentaCliente = (ArrayList<Movimiento>)request.getAttribute("listaMovimientosCuentaCliente");
			if(listaMovimientosCuentaCliente.size() > 0) {
				saldoCuentaCliente = listaMovimientosCuentaCliente.get(0).getCuenta().getSaldo();
				numeroCuentaCliente = listaMovimientosCuentaCliente.get(0).getCuenta().getNumeroCuenta();
			}
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
	<div class="container-fluid m-0 px-3">
		<article>
			<div class="row">
				<div class="col-12">
					<%switch(rol){
					case "admin": %>
					<section>
						<div class="row justify-content-center pt-3">
							<p>secion admin</p>
						</div>
					</section>
						<%break;
					case "cliente": %>
					<section>
						<div class="row justify-content-center pt-3">
							<fieldset>
								<legend>MOVIMIENTOS Cuenta</legend>
								<table id="table_id_cuentas_cliente_movimiento" class="display">
								    <thead>
								        <tr>
								            <th>CODIGO MOVIMIENTO</th>
								            <th>FECHA  MOVIMIENTO</th>
								            <th>DETALLE</th>
								            <th>IMPORTE</th>
								            <th>ESTADO</th>
								            <th>NUMERO CUENTA</th>
								            <th>TIPO MOVIMIENTO</th>
								        </tr>
								    </thead>
								    <tbody>
								      	<%  
										for(Movimiento movimiento : listaMovimientosCuentaCliente) 
										{
										%>
										<tr> 
											<td><%= movimiento.getCodigoMovimiento() %></td> 
											<td><%= movimiento.getFecha() %></td>   
											<td><%= movimiento.getDetalle() %></td>
											<td><%= movimiento.getImporte() %></td>
											<td><%= movimiento.getEstado() %></td>
											<td><%= movimiento.getCuenta().getNumeroCuenta() %></td>
											<td><%= movimiento.getTipoMovimiento().getDescripcion() %></td>
										</tr>
									<%  } %>
								    </tbody>
								</table>
							</fieldset>
						</div>
					</section>
					<hr class="my-5">
					<section>
						<div class="row justify-content-center pt-3">
							<fieldset>
								<legend>TRANSFERENCIA Dinero</legend>
								<form action="ServletBanco" method="post">
									<div class="row">
										<div class="col-7">
							        		<label for="numeroCuenta">NUMERO Cuenta:</label>
										</div>
										<div class="col-5">
							        		<input type="text" name="numeroCuenta" readonly value="<%=numeroCuentaCliente %>">
										</div>
									</div>
									<div class="row">
										<div class="col-7">
							        		<label for="saldoCuenta">SALDO:</label>
										</div>
										<div class="col-5">
							        		<input type="text" name="SaldoCuenta" readonly value="<%=saldoCuentaCliente%>">
										</div>
									</div>
									<div class="row">
										<div class="col-7">
							        		<label for="cbuDestiono">CBU Destino:</label>
										</div>
										<div class="col-5">
							        		<input type="text" name="cbuDestiono" required pattern="^\d{22}$" title="Deben ser 22 números"><br>
										</div>
									</div>
									<div class="row">
										<div class="col-7">
											<label for="montoTransferir">MONTO Transferencia:</label>
										</div>
										<div class="col-5">
											<input type="number" name="montoTransferir" required min="0" max="<%=saldoCuentaCliente%>" title="Debe ser monto Menor o igual a su saldo <%=saldoCuentaCliente%>"><br>
										</div>
									</div>
									<div class="row">
										<div class="col-7">
											<input type="submit" value="Transferir Dinero" name="btnTransferirDineroCuentaCliente" class="mt-1 bg-warning">
										</div>
									</div>
							    </form>
							</fieldset>
						</div>
					</section>
					<hr class="my-5">
					<section>
						<div class="row justify-content-center py-3">
							<fieldset>
								<legend>SOLICITUD Préstamo</legend>
								<form action="ServletBanco" method="post">
									<div class="row">
										<div class="col-7">
							        		<label for="numeroCuenta">NUMERO Cuenta:</label>
										</div>
										<div class="col-5">
							        		<input type="text" name="numeroCuenta" readonly value="<%=numeroCuentaCliente %>">
										</div>
									</div>
									<div class="row">
										<div class="col-7">
							        		<label for="saldoCuenta">SALDO:</label>
										</div>
										<div class="col-5">
							        		<input type="text" name="SaldoCuenta" readonly value="<%=saldoCuentaCliente%>">
										</div>
									</div>
									<div class="row">
										<div class="col-7">
							        		<label for="montoPrestamo">MONTO Préstamo:</label>
										</div>
										<div class="col-5">
							        		<input type="number" name="montoPrestamo" required min="0" max="<%=999999.99 - saldoCuentaCliente%>" title="Deben ser números positivos"><br>
										</div>
									</div>
									<div class="row">
										<div class="col-7">
											<label for="cuotasPrestamo">CUOTAS:</label>
										</div>
										<div class="col-5">
											<input type="number" name="cuotasPrestamo" required min="0" max="588" title="Deben ser cuotas mayores a 0 y menores a 588"><br>
										</div>
									</div>
									<div class="row">
										<div class="col-7">
											<input type="submit" value="Solicitar Préstamo" name="btnPedirPrestamoCuentaCliente" class="mt-1 bg-warning">
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
							<p>seccion movimientos default</p>
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
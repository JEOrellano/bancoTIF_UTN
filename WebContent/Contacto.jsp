<%@page import="entidad.Usuario"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Contacto</title>
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
	
	switch(rol) {
	case "admin":
		break;
		
	case "cliente":
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
					<section>
						<div class="row justify-content-center text-center">
							<figure>
								<img src="https://indalics.com/wp-content/uploads/2018/11/contacto-indalics.jpg" alt="Contactos" class="img-fluid" Title="Diferentes medios de contacto" style="width: 400px; height: 200px;" >
								<figcaption>Diferentes medios de contacto</figcaption>
							</figure>
						</div>
						<div class="row justify-content-center text-center">
							<figure>
								<img src="https://www.muycomputer.com/wp-content/uploads/2020/02/GoogleContacts.jpg" alt="Contactos" class="img-fluid" Title="Silueta de usuario blanca - fondo azul" style="width: 400px; height: 200px;" >
								<figcaption>Silueta de usuario blanca - fondo azul</figcaption>
							</figure>
						</div>
					</section>
					<% switch(rol){
					case "admin": %>
					<section>
						<div class="row justify-content-center pt-3">
							<p>CONTACTO ADMINISTRADOR</p>
						</div>
					</section>
					<section>
						<div class="row justify-content-center">
							<p>contacto</p>
						</div>
					</section>
					<hr/>
					<section>
						<div class="row justify-content-center">
							<p>segundo parrafo</p>
						</div>
					</section>
						<%break;
					case "cliente": %>
					<section>
						<div class="row justify-content-center pt-3">
							<p>CONTACTO CLIENTE</p>
						</div>
					</section>					
					<section>
						<div class="row justify-content-center">
							<p>contacto</p>
						</div>
					</section>
					<hr/>
					<section>
						<div class="row justify-content-center">
							<p>segundo parrafo</p>
						</div>
					</section>
						<%break;
					default: %>
					<section>
						<div class="row justify-content-center pt-3">
							<p>CONTACTO INVITADO</p>
						</div>
					</section>
					<section>
						<div class="row justify-content-center">
							<p>contacto</p>
						</div>
					</section>
					<section>
						<div class="row justify-content-center">
							<p>segundo parrafo</p>
						</div>
					</section>
					<section>
						<div class="row justify-content-center font-italic font-weight-bold">
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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
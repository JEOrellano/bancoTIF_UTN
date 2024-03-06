<%@page import="entidad.Rol"%>
<%@page import="entidad.Sexo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Usuario"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registro</title>
	<style type="text/css">
		<jsp:include page="CSS\StyleSheet.css"></jsp:include>
	</style>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet"/>
	<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
	<script>
	toastr.options = {
			  "closeButton": true,
			  "debug": false,
			  "newestOnTop": true,
			  "progressBar": true,
			  "positionClass": "toast-top-center",
			  "preventDuplicates": false,
			  "onclick": null,
			  "showDuration": "300",
			  "hideDuration": "1000",
			  "timeOut": "5000",
			  "extendedTimeOut": "1000",
			  "showEasing": "swing",
			  "hideEasing": "linear",
			  "showMethod": "fadeIn",
			  "hideMethod": "fadeOut"
			}
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
	
	ArrayList<Sexo> listaSexo = new ArrayList<Sexo>(){};
	ArrayList<Rol> listaRoles = new ArrayList<Rol>(){};
	
	switch(rol) {
	case "admin":
		if(request.getAttribute("listaSexo") == null) {
			response.sendRedirect("http://localhost:8080/TPINT_GRUPO_4_LAB4/ServletBanco?Param=irRegistro");			
		}
		else {
			listaSexo = (ArrayList<Sexo>)request.getAttribute("listaSexo");
			listaRoles = (ArrayList<Rol>)request.getAttribute("listaRoles");
		}
		break;
		
	case "cliente":
		response.sendRedirect("http://localhost:8080/TPINT_GRUPO_4_LAB4/ServletBanco?Param=irInicio");
		break;
		

	default:
		if(request.getAttribute("listaSexo") == null) {
			response.sendRedirect("http://localhost:8080/TPINT_GRUPO_4_LAB4/ServletBanco?Param=irRegistro");			
		}
		else {
			listaSexo = (ArrayList<Sexo>)request.getAttribute("listaSexo");
		}
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
						<div class="row justify-content-center text-center">
							<figure>
								<img src="https://previews.123rf.com/images/sarahdesign/sarahdesign1506/sarahdesign150604762/41443920-bot%C3%B3n-de-registrarse.jpg" alt="Contactos" Title="Bola redonda - leyenda register" class="img-fluid" style="width: 300px; height: 300px;" >
								<figcaption>Bola redonda: leyenda register</figcaption>
							</figure>
						</div>
					</section>
					<section>
						<div class="row justify-content-center py-3">
							<form action="ServletBanco" method="post">
								<div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="number" name="dni" placeholder="ingrese dni" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="number" name="cuil" placeholder="ingrese cuil" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="nombre" placeholder="ingrese nombre" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="apellido" placeholder="ingrese apellido" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="nacionalidad" placeholder="ingrese nacionalidad" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-3">
										<figure>
											<img src="./ASSETS/Registro/pastel-de-cumpleanos.png"  alt="Pastel cumpleaños" Title="Torta - Cumpleaños iconos creados por Stockio - Flaticon" class="img-fluid" style="width: 30px; height: 30px;">
										</figure>
							    	</div>
							    	<div class="col-8">
							    		<input type="date" name="fechaNacimiento" max="<%=LocalDate.now() %>" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="direccion" placeholder="ingrese direccion" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="localidad" placeholder="ingrese localidad" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="provincia" placeholder="ingrese provincia" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="email" name="correoElectronico" placeholder="email@firma.com" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="telefono" placeholder="ingrese telefono" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="usuario" placeholder="ingrese usuario" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="contrasena" placeholder="ingrese contraseña" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
							    	<div class="col-7">
											<label for="estado">Estado</label>
										</div>
									<div class="col-5">
							    		<input type="number" name="estado" min="0" max="1" value="1" placeholder="ingrese estado" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-5">
										<figure>
											<img src="./ASSETS/Registro/bano.png" alt="Silueta hombre mujer" title="Género iconos creados por Iconjam - Flatico" style="width: 30px; height: 30px;">
										</figure>
									</div>
									<div class="col-5">
							    		<select name="sexo" required>
											<% for(Sexo sexo : listaSexo) {%>
												<option value="<%=sexo.getCodigoSexo() %>"><%=sexo.getDescripcion() %></option>
											<%} %>
										</select>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
							    	<div class="col-6">
											<label for="rol">Rol</label>
										</div>
							    	<div class="col-5">
							    		<select name="rol" required>
											<% for(Rol roles : listaRoles) {%>
												<option value="<%=roles.getCodigoRol() %>"><%=roles.getDescripcion() %></option>
											<%} %>
										</select>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							  			<input type="submit" value="Registrarse" name="btnRegistrarCliente" class="py-1 bg-warning">
							  		</div>
							    </div>
							</form>
						</div>
					</section>
						<%break;
					case "cliente": %>
					<section>
						<div class="row justify-content-center pt-3">
						</div>
					</section>
						<%break;
					default: %>
					<section>
						<div class="row justify-content-center text-center">
							<figure>
								<img src="https://previews.123rf.com/images/sarahdesign/sarahdesign1506/sarahdesign150604762/41443920-bot%C3%B3n-de-registrarse.jpg" alt="Contactos" Title="Bola redonda - leyenda register" class="img-fluid" style="width: 300px; height: 300px;" >
								<figcaption>Bola redonda: leyenda register</figcaption>
							</figure>
						</div>
					</section>
					<section>
						<div class="row justify-content-center py-3">
							<form action="ServletBanco" method="post">
								<div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="number" name="dni" placeholder="ingrese dni" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="number" name="cuil" placeholder="ingrese cuil" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="nombre" placeholder="ingrese nombre" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="apellido" placeholder="ingrese apellido" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="nacionalidad" placeholder="ingrese nacionalidad" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-3">
										<figure>
											<img src="./ASSETS/Registro/pastel-de-cumpleanos.png"  alt="Pastel cumpleaños" Title="Torta - Cumpleaños iconos creados por Stockio - Flaticon" class="img-fluid" style="width: 30px; height: 30px;">
										</figure>
							    	</div>
							    	<div class="col-8">
							    		<input type="date" name="fechaNacimiento" max="<%=LocalDate.now() %>" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="direccion" placeholder="ingrese direccion" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="localidad" placeholder="ingrese localidad" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="provincia" placeholder="ingrese provincia" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="email" name="correoElectronico" placeholder="email@firma.com" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="telefono" placeholder="ingrese telefono" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="usuario" placeholder="ingrese usuario" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							    		<input type="text" name="contrasena" placeholder="ingrese contraseña" required>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-5">
										<figure>
											<img src="./ASSETS/Registro/bano.png" alt="Silueta hombre mujer" title="Género iconos creados por Iconjam - Flatico" style="width: 30px; height: 30px;">
										</figure>
									</div>
									<div class="col-5">
							    		<select name="sexo" required>
											<% for(Sexo sexo : listaSexo) {%>
												<option value="<%=sexo.getCodigoSexo() %>"><%=sexo.getDescripcion() %></option>
											<%} %>
										</select>
							    	</div>
							    </div>
							    <div class="row justify-content-center mt-3">
									<div class="col-12">
							  			<input type="submit" value="Registrarse" name="btnRegistrarCliente" class="py-1 bg-warning">
							  		</div>
							    </div>
							</form>
						</div>
					</section>
						<%break;}%>
				</div>
			</div>
		</article>
	</div>
	<% if (request.getAttribute("mensajeUsuarioAgregado") != null) { %>
		<script>toastr.success("<%=request.getAttribute("mensajeUsuarioAgregado")%>")</script>
	<% } else if (request.getAttribute("mensajeUsuarioNoAgregado") != null) { %>
		<script>toastr.error("<%=request.getAttribute("mensajeUsuarioNoAgregado")%>")</script>
	<% } %>
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
<script>

    function showAlert() {
    	if(document.querySelector('form')) {
         Swal.fire({
             title: '<%=request.getAttribute("mensajeUsuarioAgregado") != null ? "Gracias!" : "Oops..."%>' ,
             text: '<%=request.getAttribute("mensajeUsuarioAgregado") != null ? request.getAttribute("mensajeUsuarioAgregado") : request.getAttribute("mensajeUsuarioNoAgregado")%>' ,
             icon: '<%=request.getAttribute("mensajeUsuarioAgregado") != null ? "success" : "error"%>' ,
             confirmButtonText: 'OK'
         });
    		
    		
    	}
    }
</script>

</body>
</html>
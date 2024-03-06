<%@page import="entidad.Usuario"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entidad.TipoCuenta"%>
<%@page import="entidad.Cuenta"%>
<%@page import="entidad.Usuario"%>  
<%@ page import="java.util.ArrayList"%>
<%@page import="negocio.IUsuarioNeg"%>
<%@page import="negocio.ICuentaNeg"%>


<%
	
	Usuario admin = new Usuario ();
	admin = (Usuario) request.getSession().getAttribute("Usuario"); 
	
	%>
	

            
            
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Alta cuenta</title>
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


</head>
<body>

</body>
</html>


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




<!--<h1 id="titulo">Alta de clientes</h1>-->

        <div class="form-alta-cuentas">
        
           <form action="ServletBanco" method="get">
            
                <p class="details">Asignar cuenta a un cliente:</p>
                <div class="inputs">
                    <div class="text-layout">
                        <label for="CBU">CBU<span class="required-fields">*</span></label>
                        <input type="text" name="txtCbu" id="CBU" required>
                    </div>
                    
                    <div class="text-layout">
                        <label for="DNI">DNI<span class="required-fields">*</span></label>
                        <input type="number" id="DNI" placeholder=" XX-XXX-XXX" name="txtDni" required>
                    </div>
                    
                    <div class="text-layout">
                        <label for="T-Cuenta">Tipo de Cuenta<span class="required-fields">*</span></label>
                        <select name="Tipo" id="T-Cuenta">
						<% ArrayList <TipoCuenta> tCuentas = (ArrayList <TipoCuenta>)request.getAttribute("listatCuentas");
                           	   if (tCuentas != null){
                        			for(TipoCuenta tcuenta : tCuentas) { %>
                        				<option value="<%= tcuenta.getCodigoTipoCuenta()%>"><%=tcuenta.getDescripcion()%></option>
                        			<%}
                        		} else { %>
                        			<option>NO HAY</option>
                        	  <%}%>
                        </select>
                    </div>

                    <div class="text-layout">
                        <label for="adress">Numero de Cuenta<span class="required-fields">*</span></label>
                        <input type="number" name="NroCuenta" id="adress" placeholder=" 123454" required>
                    </div>

                    <div class="text-layout">
                        <label for="number1">Saldo<span class="required-fields">*</span></label>
                        <input type="number" name="Saldo" id="number1" required>
                    </div>

                </div>
                
                <h6 class="required-fields">* - Campos obligatorios.</h6>
                
                <input type="submit" name="btnAceptar" value="Agregar" id="buttonSubmit"></input>
                <button type="reset" id="buttonCancel">Cancelar</button>
                
            </form>


   <% Boolean insert = (Boolean)request.getAttribute("insert");
               if (insert != null && insert) {%>
            	   Se agrego correctamente!
            <%}%>

	</div>
		</body>






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
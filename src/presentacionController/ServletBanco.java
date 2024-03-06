package presentacionController;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Cuenta;
import entidad.Movimiento;
import entidad.Prestamo;
import entidad.Sexo;
import entidad.Usuario;
import excepciones.DuplicadaPKException;
import excepciones.DuplicadaUKException;
import negocioImpl.CuentaNegImpl;
import negocioImpl.EstadoPrestamoNegImpl;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.PrestamoNegImpl;
import negocioImpl.RolNegImpl;
import negocioImpl.SexoNegImpl;
import negocioImpl.TipoCuentaNegImpl;
import negocioImpl.TipoMovimientoNegImpl;
import negocioImpl.UsuarioNegImpl;

@WebServlet("/ServletBanco")
public class ServletBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioNegImpl usuarioNegImpl = new UsuarioNegImpl();
	private CuentaNegImpl cuentaNegImpl = new CuentaNegImpl();
	private MovimientoNegImpl movimientoNegImpl = new MovimientoNegImpl();
	private TipoMovimientoNegImpl tipoMovimientoNegImpl = new TipoMovimientoNegImpl();
	private PrestamoNegImpl prestamoNegImpl = new PrestamoNegImpl();
	private EstadoPrestamoNegImpl estadoPrestamoNegImpl = new EstadoPrestamoNegImpl();
	private SexoNegImpl sexoNegImpl = new SexoNegImpl();
	private RolNegImpl rolNegImpl = new RolNegImpl();
	private TipoCuentaNegImpl tipoCuentaNegImpl = new TipoCuentaNegImpl();
	
    public ServletBanco() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null) {
			RequestDispatcher rd;
			String rolSL = "";
			
			switch(request.getParameter("Param")) {
			case "irInicio":
				rolSL = "";
				// sino esta logeado a inicio
				if(request.getSession().getAttribute("usuario") != null) {
					rolSL = ((Usuario)request.getSession().getAttribute("usuario")).getRol().getDescripcion();
				}
				switch (rolSL) {
				case "admin":
					// Carga lista clientes
					ArrayList<Usuario> listaClientes = usuarioNegImpl.listarTodos();
					request.setAttribute("listaClientes", listaClientes);
					// Carga lista cuentas
					ArrayList<Cuenta> listaCuentas = cuentaNegImpl.listarTodos();
					request.setAttribute("listaCuentas", listaCuentas);
					// Carga lista prestamos
					ArrayList<Prestamo> listaPrestamos = prestamoNegImpl.listarTodos();
					request.setAttribute("listaPrestamos", listaPrestamos);
					// Redirije a Inicio
					request.setAttribute("Bienvenido", "Usuario logeado con exito");
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				case "cliente":
					// Cuentas Cliente
					ArrayList<Cuenta> listaCuentasCliente = cuentaNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaCuentasCliente", listaCuentasCliente);
					// Prestamos Cliente
					ArrayList<Prestamo> listaPrestamosCliente = prestamoNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaPrestamosCliente", listaPrestamosCliente);
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				default:
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				}
				break;
			case "irContacto":
				rd = request.getRequestDispatcher("/Contacto.jsp");
				rd.forward(request, response);
				break;
			case "irPrestamos":
				rolSL = "";
				// sino esta logeado a inicio
				if(request.getSession().getAttribute("usuario") != null) {
					rolSL = ((Usuario)request.getSession().getAttribute("usuario")).getRol().getDescripcion();
				}
				switch (rolSL) {
				case "admin":
					// Redirije a Inicio
					// Carga lista clientes
					ArrayList<Usuario> listaClientes = usuarioNegImpl.listarTodos();
					request.setAttribute("listaClientes", listaClientes);
					// Carga lista cuentas
					ArrayList<Cuenta> listaCuentas = cuentaNegImpl.listarTodos();
					request.setAttribute("listaCuentas", listaCuentas);
					// Carga lista prestamos
					ArrayList<Prestamo> listaPrestamos = prestamoNegImpl.listarTodos();
					request.setAttribute("listaPrestamos", listaPrestamos);
					// Redirije a Inicio
					request.setAttribute("Bienvenido", "Usuario logeado con exito");
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				case "cliente":
					// Cuentas Cliente
					ArrayList<Cuenta> listaCuentasCliente = cuentaNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaCuentasCliente", listaCuentasCliente);
					// Prestamos Cliente
					ArrayList<Prestamo> listaPrestamosCliente = prestamoNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaPrestamosCliente", listaPrestamosCliente);
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				default:
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				}
				break;
			case "irMovimientos":
				rolSL = "";
				// sino esta logeado a inicio
				if(request.getSession().getAttribute("usuario") != null) {
					rolSL = ((Usuario)request.getSession().getAttribute("usuario")).getRol().getDescripcion();
				}
				switch (rolSL) {
				case "admin":
					// Redirije a Inicio
					// Carga lista clientes
					ArrayList<Usuario> listaClientes = usuarioNegImpl.listarTodos();
					request.setAttribute("listaClientes", listaClientes);
					// Carga lista cuentas
					ArrayList<Cuenta> listaCuentas = cuentaNegImpl.listarTodos();
					request.setAttribute("listaCuentas", listaCuentas);
					// Carga lista prestamos
					ArrayList<Prestamo> listaPrestamos = prestamoNegImpl.listarTodos();
					request.setAttribute("listaPrestamos", listaPrestamos);
					// Redirije a Inicio
					request.setAttribute("Bienvenido", "Usuario logeado con exito");
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				case "cliente":
					// Cuentas Cliente
					ArrayList<Cuenta> listaCuentasCliente = cuentaNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaCuentasCliente", listaCuentasCliente);
					// Prestamos Cliente
					ArrayList<Prestamo> listaPrestamosCliente = prestamoNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaPrestamosCliente", listaPrestamosCliente);
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				default:
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				}
				break;
			case "irNosotros":
				rd = request.getRequestDispatcher("/Nosotros.jsp");
				rd.forward(request, response);
				break;
			case "irRegistro":
				rolSL = "";
				ArrayList<Sexo> listaSexo;
				// si esta logeado como cliente a inicio
				if(request.getSession().getAttribute("usuario") != null) {
					rolSL = ((Usuario)request.getSession().getAttribute("usuario")).getRol().getDescripcion();
				}
				
				switch (rolSL) {
				case "admin":
					// Obtiene lista de tipos de sexo
					listaSexo = sexoNegImpl.listarTodos();
					request.setAttribute("listaSexo", listaSexo);
					// Obtiene lista de tipos de roles
					request.setAttribute("listaRoles", rolNegImpl.listarTodos());
					// Redirije a Registro.jsp
					rd = request.getRequestDispatcher("/Registro.jsp");
					rd.forward(request, response);
					break;
				case "cliente":
					// Cuentas Cliente
					ArrayList<Cuenta> listaCuentasCliente = cuentaNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaCuentasCliente", listaCuentasCliente);
					// Prestamos Cliente
					ArrayList<Prestamo> listaPrestamosCliente = prestamoNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaPrestamosCliente", listaPrestamosCliente);
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				default:
					// Obtiene lista de tipos de sexo
					listaSexo = sexoNegImpl.listarTodos();
					request.setAttribute("listaSexo", listaSexo);
					// Redirije a Registro
					rd = request.getRequestDispatcher("/Registro.jsp");
					rd.forward(request, response);
				}
				break;
			case "irIngreso":
				rd = request.getRequestDispatcher("/Ingreso.jsp");
				rd.forward(request, response);
				break;
			case "cerrarSesion":
				request.getSession().removeAttribute("usuario");
				rd = request.getRequestDispatcher("/Gracias.jsp");
				rd.forward(request, response);
				break;
			default:
				break;
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnRegistrarCliente") != null) {
			String rolSL = "";
			RequestDispatcher rd;
			// Si esta logeado como admin
			if(request.getSession().getAttribute("usuario") != null) {
				rolSL = ((Usuario)request.getSession().getAttribute("usuario")).getRol().getDescripcion();
			}
			switch (rolSL) {
			case "admin":
				rd = request.getRequestDispatcher("/Registro.jsp");
				request.setAttribute("mensajeUsuarioNoAgregado", "Algo salio mal");
				try {
					// Valida dni no repetido
					// Insertar cliente
					if(usuarioNegImpl.insertar(new Usuario(
							request.getParameter("dni"),
							request.getParameter("cuil"),
							request.getParameter("nombre"),
							request.getParameter("apellido"),
							request.getParameter("nacionalidad"),
							LocalDate.parse((request.getParameter("fechaNacimiento"))),
							request.getParameter("direccion"),
							request.getParameter("localidad"),
							request.getParameter("provincia"),
							request.getParameter("correoElectronico"),
							request.getParameter("telefono"),
							request.getParameter("usuario"),
							request.getParameter("contrasena"),
							Integer.parseInt(request.getParameter("estado")),
							sexoNegImpl.obtenerUno(request.getParameter("sexo")),
							rolNegImpl.obtenerUno(Integer.parseInt(request.getParameter("rol"))))
							)) {
						// Obtiene cliente agregado por id
						request.setAttribute("clienteID", usuarioNegImpl.obtenerUno(request.getParameter("dni")));
						// Obtiene lista de tipos de sexo
						request.setAttribute("listaSexo", sexoNegImpl.listarTodos());
						// Obtiene lista de tipos de roles
						request.setAttribute("listaRoles", rolNegImpl.listarTodos());
						// Redirije a ModificarClienteID.jsp
						rd = request.getRequestDispatcher("/ModificarClienteID.jsp");
		
						request.setAttribute("mensajeUsuarioModificado", "Usuario Modificado con exito");
					}
				} catch (DuplicadaPKException e) {
					e.printStackTrace();
				} catch (DuplicadaUKException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				rd.forward(request, response);
				break;

			default:
				rd = request.getRequestDispatcher("/Registro.jsp");
				request.setAttribute("mensajeUsuarioNoAgregado", "Algo salio mal");
				Usuario usuario = new Usuario(
						request.getParameter("dni"),
						request.getParameter("cuil"),
						request.getParameter("nombre"),
						request.getParameter("apellido"),
						request.getParameter("nacionalidad"),
						LocalDate.parse((request.getParameter("fechaNacimiento"))),
						request.getParameter("direccion"),
						request.getParameter("localidad"),
						request.getParameter("provincia"),
						request.getParameter("correoElectronico"),
						request.getParameter("telefono"),
						request.getParameter("usuario"),
						request.getParameter("contrasena"),
						1,
						sexoNegImpl.obtenerUno("M"),
						rolNegImpl.obtenerUno(1));
				try {
					// Valida dni no repetido
					if(usuarioNegImpl.insertar(usuario)) {
						// Inserta nuevo usuario
						rd = request.getRequestDispatcher("/Ingreso.jsp");
						request.setAttribute("mensajeUsuarioAgregado", "Usuario agregado con exito");
					}
				} catch (DuplicadaPKException e) {
					e.printStackTrace();
				} catch (DuplicadaUKException e) {
					e.printStackTrace();
				}
				rd.forward(request, response);
				break;
			}
		}
		if(request.getParameter("btnIngresarCliente") != null) {
			// Verificar usuario
			String mensaje = "";
	        if(!usuarioNegImpl.existeUser(request.getParameter("user"))) {
	        	mensaje = "Usuario invalido - " + request.getParameter("user");
	        	request.setAttribute("mensajeAvisoUsuario", mensaje);
		        request.getRequestDispatcher("/Ingreso.jsp").forward(request, response);
	        }
		    // verifica contraseña
	        else if (usuarioNegImpl.login(request.getParameter("user"),request.getParameter("contrasena")).getContrasena() == null) {
	        	mensaje = "Contraseña invalido - ";
	        	request.setAttribute("mensajeAvisoContrasena", mensaje);
	        	request.getRequestDispatcher("/Ingreso.jsp").forward(request, response);
	        }
	        // Session
	        else {	        
				Usuario usuario = usuarioNegImpl.login(request.getParameter("user"),request.getParameter("contrasena"));
				request.getSession().setAttribute("usuario", usuario);
				RequestDispatcher rd;
				
				switch (usuario.getRol().getDescripcion()) {
				case "admin":
					// Carga lista clientes
					ArrayList<Usuario> listaClientes = usuarioNegImpl.listarTodos();
					request.setAttribute("listaClientes", listaClientes);
					// Carga lista cuentas
					ArrayList<Cuenta> listaCuentas = cuentaNegImpl.listarTodos();
					request.setAttribute("listaCuentas", listaCuentas);
					// Carga lista prestamos
					ArrayList<Prestamo> listaPrestamos = prestamoNegImpl.listarTodos();
					request.setAttribute("listaPrestamos", listaPrestamos);
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				case "cliente":
					// Cuentas Cliente
					ArrayList<Cuenta> listaCuentasCliente = cuentaNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaCuentasCliente", listaCuentasCliente);
					// Prestamos Cliente
					ArrayList<Prestamo> listaPrestamosCliente = prestamoNegImpl.listarFiltradosCliente(((Usuario)request.getSession().getAttribute("usuario")).getDni());
					request.setAttribute("listaPrestamosCliente", listaPrestamosCliente);
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
					break;
				default:
					// Redirije a Inicio
					rd = request.getRequestDispatcher("/Ingreso.jsp");
					rd.forward(request, response);
					break;
				}
	        }
		}
		
		/* SECCION ADMIN ABML */
		/// ADMIN abml clientes ///
		if(request.getParameter("btnVerCliente") != null) {
			// Obtiene cliente por id
			request.setAttribute("clienteID", usuarioNegImpl.obtenerUno(request.getParameter("idUsuario")));
			// Obtiene lista de tipos de sexo
			request.setAttribute("listaSexo", sexoNegImpl.listarTodos());
			// Obtiene lista de tipos de roles
			request.setAttribute("listaRoles", rolNegImpl.listarTodos());
			// Redirije a ModificarClienteID.jsp
			request.getRequestDispatcher("/ModificarClienteID.jsp").forward(request, response);
			request.setAttribute("mensajeUsuarioModificado", "Usuario Modificado con exito");
		}
		// Edita cliente
		if(request.getParameter("btnEditarCliente") != null) {
			// Edita cliente
			usuarioNegImpl.editar(new Usuario(
					request.getParameter("dni"),
					request.getParameter("cuil"),
					request.getParameter("nombre"),
					request.getParameter("apellido"),
					request.getParameter("nacionalidad"),
					LocalDate.parse((request.getParameter("fechaNacimiento"))),
					request.getParameter("direccion"),
					request.getParameter("localidad"),
					request.getParameter("provincia"),
					request.getParameter("correoElectronico"),
					request.getParameter("telefono"),
					request.getParameter("usuario"),
					request.getParameter("contrasena"),
					Integer.parseInt(request.getParameter("estado")),
					sexoNegImpl.obtenerUno(request.getParameter("sexo")),
					rolNegImpl.obtenerUno(Integer.parseInt(request.getParameter("rol"))))
			);
			// Obtiene cliente editado por id
			request.setAttribute("clienteID", usuarioNegImpl.obtenerUno(request.getParameter("dni")));
			// Obtiene lista de tipos de sexo
			request.setAttribute("listaSexo", sexoNegImpl.listarTodos());
			// Obtiene lista de tipos de roles
			request.setAttribute("listaRoles", rolNegImpl.listarTodos());
			// Redirije a ModificarClienteID.jsp
			request.setAttribute("mensajeUsuarioModificado", "Usuario Modificado con exito");
			request.getRequestDispatcher("/ModificarClienteID.jsp").forward(request, response);
			
		}
		// Baja logica cliente
		if(request.getParameter("btnBorrarCliente") != null) {
			usuarioNegImpl.borrar(request.getParameter("dni"));
			// Obtiene cliente editado por id
			request.setAttribute("clienteID", usuarioNegImpl.obtenerUno(request.getParameter("dni")));
			// Obtiene lista de tipos de sexo
			request.setAttribute("listaSexo", sexoNegImpl.listarTodos());
			// Obtiene lista de tipos de roles
			request.setAttribute("listaRoles", rolNegImpl.listarTodos());
			// Redirije a ModificarClienteID.jsp
			request.getRequestDispatcher("/ModificarClienteID.jsp").forward(request, response);
		}
		// Agregar cliente como admin
		if (request.getParameter("btnAgregarCliente") != null) {
			// Obtiene lista de tipos de sexo
			request.setAttribute("listaSexo", sexoNegImpl.listarTodos());
			// Obtiene lista de tipos de roles
			request.setAttribute("listaRoles", rolNegImpl.listarTodos());
			// Redirije a Registro.jsp
			request.getRequestDispatcher("/Registro.jsp").forward(request, response);
		}
		/// ADMIN abml cuentas ///
		if (request.getParameter("btnVerCuenta") != null) {
			// Obtiene cliente por id
			request.setAttribute("cuentaID", cuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("idCuenta"))));
			// Obtiene lista de tipos de cuentas
			request.setAttribute("listaTiposCuentas", tipoCuentaNegImpl.listarTodos());
			// Obtiene siguiente idcuenta
			request.setAttribute("proximoIDCuenta", cuentaNegImpl.listarSiguienteId());
			// Redirije a ModificarCuentaID.jsp
			request.getRequestDispatcher("/ModificarCuentaID.jsp").forward(request, response);
			
		}
		// Edita cuenta
		if (request.getParameter("btnEditarCuenta") != null) {
			cuentaNegImpl.editar(new Cuenta(
					Integer.parseInt(request.getParameter("numeroCuenta")),
					LocalDate.parse(request.getParameter("fechaCreacion")),
					request.getParameter("cbu"),
					Double.parseDouble(request.getParameter("saldo")),
					Integer.parseInt(request.getParameter("estado")),
					tipoCuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("tipo"))),
					usuarioNegImpl.obtenerUno(request.getParameter("idCliente")))
			);
			// Obtiene cuenta editado por id
			request.setAttribute("cuentaID", cuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("numeroCuenta"))));
			// Obtiene lista de tipos de cuentas
			request.setAttribute("listaTiposCuentas", tipoCuentaNegImpl.listarTodos());
			// Obtiene siguiente idcuenta
			request.setAttribute("proximoIDCuenta", cuentaNegImpl.listarSiguienteId());
			// Redirije a ModificarCuentaID.jsp
			request.getRequestDispatcher("/ModificarCuentaID.jsp").forward(request, response);
			
		}
		// Baja logica cuenta
		if (request.getParameter("btnBorrarCuenta") != null) {
			cuentaNegImpl.borrar(Integer.parseInt(request.getParameter("numeroCuenta")));
			// Obtiene cuenta editado por id
			request.setAttribute("cuentaID", cuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("numeroCuenta"))));
			// Obtiene lista de tipos de cuentas
			request.setAttribute("listaTiposCuentas", tipoCuentaNegImpl.listarTodos());
			// Obtiene siguiente idcuenta
			request.setAttribute("proximoIDCuenta", cuentaNegImpl.listarSiguienteId());
			// Redirije a ModificarCuentaID.jsp
			request.getRequestDispatcher("/ModificarCuentaID.jsp").forward(request, response);
		}
		// Alta cuenta
		if (request.getParameter("btnAgregarCuenta") != null) {
			// Validar 3 cuentas por cliente
			int cantCuentas = cuentaNegImpl.listarFiltradosCliente(request.getParameter("idCliente")).size();
			String mensajeAviso3Cuentas = "";
			if(cantCuentas < 3) {					
				// Agrega nueva cuenta
				cuentaNegImpl.insertar(new Cuenta(
						Integer.parseInt(request.getParameter("numeroCuenta")),
						LocalDate.parse(request.getParameter("fechaCreacion")),
						request.getParameter("cbu"),
						Double.parseDouble(request.getParameter("saldo")),
						Integer.parseInt(request.getParameter("estado")),
						tipoCuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("tipo"))),
						usuarioNegImpl.obtenerUno(request.getParameter("idCliente")))
				);
				// Genera movimiento nueva cuenta destino 0 es simbolico es autoincrement en DB
				movimientoNegImpl.insertar(new Movimiento(
						0,
						LocalDate.now(),
						"Se dio alta su cuenta",
						Double.parseDouble(request.getParameter("saldo")),
						1,
						cuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("numeroCuenta"))),
						tipoMovimientoNegImpl.obtenerUno(1))
				);
				// Obtiene cuenta agregada por id
				request.setAttribute("cuentaID", cuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("numeroCuenta"))));
			} else {
				// Avisa que tiene 3 cuentas
				mensajeAviso3Cuentas = "No mas de 3 cuentas - " + request.getParameter("idCliente");
	        	request.setAttribute("mensajeAviso3Cuentas", mensajeAviso3Cuentas);
	        	// Obtiene cuenta actual por id
				request.setAttribute("cuentaID", cuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("numeroCuentaActual"))));
			}
			
			// Obtiene lista de tipos de cuentas
			request.setAttribute("listaTiposCuentas", tipoCuentaNegImpl.listarTodos());
			// Obtiene siguiente idcuenta
			request.setAttribute("proximoIDCuenta", cuentaNegImpl.listarSiguienteId());
			// Redirije a ModificarCuentaID.jsp
			request.getRequestDispatcher("/ModificarCuentaID.jsp").forward(request, response);
		}
		// ADMIN abml prestamos ///
		if (request.getParameter("btnVerPrestamo") != null) {
			// Obtiene prestamo por id
			request.setAttribute("prestamo", prestamoNegImpl.obtenerUno(Integer.parseInt(request.getParameter("idPrestamo"))));
			// Obtiene lista de estados de prestamo
			request.setAttribute("listaEstadosPrestamo", estadoPrestamoNegImpl.listarTodos());
			// Redirije a Prestamos
			request.getRequestDispatcher("/Prestamos.jsp").forward(request, response);
		}
		// Aceptar prestamo
		if (request.getParameter("btnAceptarPrestamo") != null) {
			// EstadoPrestamo aceptado
			Prestamo prestamo =  prestamoNegImpl.obtenerUno(Integer.parseInt(request.getParameter("codigoPrestamo")));
			prestamo.setEstadoPrestamo(estadoPrestamoNegImpl.obtenerUno(2));
			prestamoNegImpl.editar(prestamo);
			// Obtiene prestamo por codigo
			request.setAttribute("prestamo", prestamoNegImpl.obtenerUno(Integer.parseInt(request.getParameter("codigoPrestamo"))));
			// Obtiene lista de estados de prestamo
			request.setAttribute("listaEstadosPrestamo", estadoPrestamoNegImpl.listarTodos());
			// Agrega saldo a primer cuenta del cliente
			Cuenta cuenta = cuentaNegImpl.listarFiltradosCliente(prestamo.getCliente().getDni()).get(0);
			cuenta.setSaldo(cuenta.getSaldo() + prestamo.getImportePedido());
			cuentaNegImpl.editar(cuenta);
			// Genera movimiento de cuenta prestamo aceptado 0 es simbolico es autoincrement en DB
			Movimiento movimiento = new Movimiento(
					0,
					LocalDate.now(),
					"Se acepto su prestamo",
					prestamo.getImportePedido(),
					1,
					cuenta,
					tipoMovimientoNegImpl.obtenerUno(2)
			);			
			movimientoNegImpl.insertar(movimiento);
			// Redirije a Prestamos
			request.getRequestDispatcher("/Prestamos.jsp").forward(request, response);
		}
		// Rechazar prestamo
		if (request.getParameter("btnRechazarPrestamo") != null) {
			// EstadoPrestamo aceptado
			Prestamo prestamo =  prestamoNegImpl.obtenerUno(Integer.parseInt(request.getParameter("codigoPrestamo")));
			prestamo.setEstadoPrestamo(estadoPrestamoNegImpl.obtenerUno(3));
			prestamoNegImpl.editar(prestamo);
			// Obtiene prestamo por codigo
			request.setAttribute("prestamo", prestamoNegImpl.obtenerUno(Integer.parseInt(request.getParameter("codigoPrestamo"))));
			// Obtiene lista de estados de prestamo
			request.setAttribute("listaEstadosPrestamo", estadoPrestamoNegImpl.listarTodos());
			// Redirije a Prestamos
			request.getRequestDispatcher("/Prestamos.jsp").forward(request, response);
		}
		
		// ADMIN Estadisticas Prestamos //
		if (request.getParameter("btnFiltrarPrestamos") != null) {
			// Carga lista filtrada prestamos
			System.out.println("ENTRO ESTADISTICAS ADMIN");
			System.out.println(request.getParameter("montoMinimo").trim().equals(""));
			System.out.println(request.getParameter("montoMaximo").trim().equals(""));
			System.out.println(request.getParameter("fechaMinimo").trim().equals(""));
			System.out.println(request.getParameter("fechaMaximo").trim().equals(""));
			System.out.println(request.getParameter("cuotaMinimo").trim().equals(""));
			System.out.println(request.getParameter("cuotaMaximo").trim().equals(""));
			// Carga lista prestamos
			ArrayList<Prestamo> listaPrestamos = (ArrayList<Prestamo>) prestamoNegImpl.listarFiltroEstadisticas(
					request.getParameter("montoMinimo").equals("")? 0 : Double.parseDouble(request.getParameter("montoMinimo")),
							request.getParameter("montoMaximo").equals("")? 100000000 : Double.parseDouble(request.getParameter("montoMaximo")),
									request.getParameter("fechaMinimo").equals("")? LocalDate.parse("1900-01-01") : LocalDate.parse(request.getParameter("fechaMinimo")),
											request.getParameter("fechaMaximo").equals("")? LocalDate.now() : LocalDate.parse(request.getParameter("fechaMaximo")),
													request.getParameter("cuotaMinimo").equals("")? 0 : Integer.parseInt(request.getParameter("cuotaMinimo")),
															request.getParameter("cuotaMaximo").trim().equals("")? 588 : Integer.parseInt(request.getParameter("cuotaMaximo"))
					);
			request.setAttribute("listaPrestamos", listaPrestamos);
			// Carga lista clientes
			ArrayList<Usuario> listaClientes = usuarioNegImpl.listarTodos();
			request.setAttribute("listaClientes", listaClientes);
			// Carga lista cuentas
			ArrayList<Cuenta> listaCuentas = cuentaNegImpl.listarTodos();
			request.setAttribute("listaCuentas", listaCuentas);
			
			// Redirije a Inicio
			request.getRequestDispatcher("/Inicio.jsp").forward(request, response);
		}
		
		/* SECCION CLIENTE ABML */
		if (request.getParameter("btnCuentaCliente") != null) {
			// Redirige a Movimientos cargando los de una cuenta
			ArrayList<Movimiento> listaMovimientosCuentaCliente = movimientoNegImpl.listarFiltradosCuenta(Integer.parseInt(request.getParameter("idCuentaCliente"))); 
			request.setAttribute("listaMovimientosCuentaCliente", listaMovimientosCuentaCliente);
			RequestDispatcher rd = request.getRequestDispatcher("/Movimientos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnTransferirDineroCuentaCliente") != null ) {
			// Actualiza cuenta destino por CBU
			Cuenta cuentaDestino = cuentaNegImpl.listarFiltradoCBU(request.getParameter("cbuDestiono"));
			cuentaDestino.setSaldo(cuentaDestino.getSaldo() + Double.parseDouble(request.getParameter("montoTransferir")));
			cuentaNegImpl.editar(cuentaDestino);
			// Actualiza movimiento cuenta destino 0 es simbolico es autoincrement en DB
			Movimiento movimientoDestino = new Movimiento(0, LocalDate.now(), "Se transfiere dinero a su cuenta", Double.parseDouble(request.getParameter("montoTransferir")), 1, cuentaDestino, tipoMovimientoNegImpl.obtenerUno(4));
			movimientoNegImpl.insertar(movimientoDestino);
			// Actualiza cuenta origen por numero de cuenta
			Cuenta cuentaOrigen = cuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("numeroCuenta")));
			cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - Double.parseDouble(request.getParameter("montoTransferir")));
			cuentaNegImpl.editar(cuentaOrigen);
			// Actualiza movimiento cuenta origen  0 es simbolico es autoincrement en DB
			Movimiento movimientoOrigen = new Movimiento(0,LocalDate.now(),"Se transfiere dinero de su cuenta", Double.parseDouble(request.getParameter("montoTransferir")), 1, cuentaOrigen, tipoMovimientoNegImpl.obtenerUno(4));
			movimientoNegImpl.insertar(movimientoOrigen);
			// Redirije a misma pagina actualiza datos delc uenta y movimiento
			ArrayList<Movimiento> listaMovimientosCuentaCliente = movimientoNegImpl.listarFiltradosCuenta(cuentaOrigen.getNumeroCuenta()); 
			request.setAttribute("listaMovimientosCuentaCliente", listaMovimientosCuentaCliente);
			RequestDispatcher rd = request.getRequestDispatcher("/Movimientos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnPedirPrestamoCuentaCliente") != null) {
			// Registra nuevo prestamo 0 es simbolico el id es autoincremental en BD por defecto queda en pendiente 1
			prestamoNegImpl.insertar(new Prestamo(
					0,
					LocalDate.now(),
					Double.parseDouble(request.getParameter("montoPrestamo")),
					Double.parseDouble(request.getParameter("montoPrestamo")),
					Integer.parseInt(request.getParameter("cuotasPrestamo")),
					Double.parseDouble(request.getParameter("montoPrestamo"))/Integer.parseInt(request.getParameter("cuotasPrestamo")),
					Integer.parseInt(request.getParameter("cuotasPrestamo")),
					1,
					estadoPrestamoNegImpl.obtenerUno(1),
					cuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("numeroCuenta"))).getCliente()));
			// Redirije a misma pagina actualiza datos de cuenta y movimiento
			ArrayList<Movimiento> listaMovimientosCuentaCliente = movimientoNegImpl.listarFiltradosCuenta(Integer.parseInt(request.getParameter("numeroCuenta"))); 
			request.setAttribute("listaMovimientosCuentaCliente", listaMovimientosCuentaCliente);
			RequestDispatcher rd = request.getRequestDispatcher("/Movimientos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnPrestamoCliente") != null) {
			// Redirije a Prestamos cargando las cuotas del prestamo
			// Obtener prestamo seleccionado
			Prestamo cuotasPrestamoCliente = prestamoNegImpl.obtenerUno(Integer.parseInt(request.getParameter("idPrestamoCliente"))); 
			request.setAttribute("cuotasPrestamoCliente", cuotasPrestamoCliente);
			// Cuentas Cliente
			ArrayList<Cuenta> listaCuentasCliente = cuentaNegImpl.listarFiltradosCliente(cuotasPrestamoCliente.getCliente().getDni());
			request.setAttribute("listaCuentasCliente", listaCuentasCliente);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamos.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnPagrCuotaPrestamoCliente") != null) {
			System.out.println(" PRESIONO BOTON: btnPagrCuotaPrestamoCliente");
			System.out.println("radio button " + request.getParameter("cuentasPagarCuota"));
			System.out.println("input " + request.getParameter("montoPagarCuota"));
			System.out.println("select " + request.getParameter("prestamoCuotaPagar"));
			// Persistir pago cuota en prestamo
			Prestamo prestamoCuotaPaga = prestamoNegImpl.obtenerUno(Integer.parseInt(request.getParameter("prestamoCuotaPagar")));
			prestamoCuotaPaga.setCuotas(prestamoCuotaPaga.getCuotas()-1);
			prestamoNegImpl.editar(prestamoCuotaPaga);
			// Persistir saldo cuenta
			Cuenta cuentaCuotaPaga = cuentaNegImpl.obtenerUno(Integer.parseInt(request.getParameter("cuentasPagarCuota")));
			cuentaCuotaPaga.setSaldo(cuentaCuotaPaga.getSaldo() - Double.parseDouble(request.getParameter("montoPagarCuota")));
			cuentaNegImpl.editar(cuentaCuotaPaga);
			// Persistir movimiento cuenta 0 es simbolico es autoincrement en DB
			movimientoNegImpl.insertar(new Movimiento(0, LocalDate.now(), "Se paga prestamo desde su cuenta", Double.parseDouble(request.getParameter("montoPagarCuota")), 1, cuentaCuotaPaga, tipoMovimientoNegImpl.obtenerUno(3)));
			
			// Redirije a Prestamos cargando las cuotas del prestamo
			// Obtener prestamo seleccionado
			Prestamo cuotasPrestamoCliente = prestamoNegImpl.obtenerUno(Integer.parseInt(request.getParameter("prestamoCuotaPagar"))); 
			request.setAttribute("cuotasPrestamoCliente", cuotasPrestamoCliente);
			// Cuentas Cliente
			ArrayList<Cuenta> listaCuentasCliente = cuentaNegImpl.listarFiltradosCliente(cuentaCuotaPaga.getCliente().getDni());
			request.setAttribute("listaCuentasCliente", listaCuentasCliente);
			
			// Ir prestamo cliente
			RequestDispatcher rd = request.getRequestDispatcher("/Prestamos.jsp");
			rd.forward(request, response);
		}
	}
	
	/* FUNCIONES doPost auxiliares*/
	

}

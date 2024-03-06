package pruebas;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import entidad.Prestamo;
import negocioImpl.CuentaNegImpl;
import negocioImpl.EstadoPrestamoNegImpl;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.PrestamoNegImpl;
import negocioImpl.RolNegImpl;
import negocioImpl.UsuarioNegImpl;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioNegImpl usuarioNegImpl = new UsuarioNegImpl();
		//System.out.println(usuarioNegImpl.obtenerUno("1111111"));
		//System.out.println(usuarioNegImpl.login("Usuario 1", "Clave1").getNombre());
		//System.out.println(usuarioNegImpl.existeUser("Usuario 1"));
		System.out.println(usuarioNegImpl.existeDni("17171717"));
		
		RolNegImpl rolNegImpl = new RolNegImpl();
		//System.out.println(rolNegImpl.obtenerUno(1));
		
		CuentaNegImpl cuentaNegImpl = new CuentaNegImpl();
		//System.out.println(cuentaNegImpl.listarTodos());
		//System.out.println(cuentaNegImpl.listarFiltradosCliente("1111111"));
		//System.out.println("una ves " + cuentaNegImpl.existeCBU("1000000000000000000000"));
		//System.out.println(cuentaNegImpl.listarSiguienteId());
		
		MovimientoNegImpl movimientoNegImpl = new MovimientoNegImpl();
		//System.out.println(movimientoNegImpl.listarFiltradosCuenta(1));
		
		EstadoPrestamoNegImpl estadoPrestamoNegImpl = new EstadoPrestamoNegImpl();
		//System.out.println(estadoPrestamoNegImpl.obtenerUno(1));
		
		PrestamoNegImpl prestamoNegImpl = new PrestamoNegImpl();
		//System.out.println(prestamoNegImpl.obtenerUno(1));
		/*ArrayList<Prestamo> listaPrestamosCliente = prestamoNegImpl.listarTodos();
		for (Prestamo prestamo : listaPrestamosCliente) {
			System.out.println(prestamo);
		}*/
		
		// Definir dos fechas
        /*LocalDate fecha1 = LocalDate.of(2022, 6, 1);
        LocalDate fecha2 = LocalDate.of(2023, 11, 1);*/

        // Calcular la diferencia entre las dos fechas
        /*Period diferencia = Period.between(fecha1, fecha2);*/

        // Acceder a los componentes de la diferencia
        /*int años = diferencia.getYears();
        int meses = diferencia.getMonths();
        int días = diferencia.getDays();

        System.out.println("Diferencia en años: " + años);
        System.out.println("Diferencia en meses: " + meses);
        System.out.println("Diferencia en días: " + días);*/
		

	}

}

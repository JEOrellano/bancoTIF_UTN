package entidad;

import java.time.LocalDate;

public class Prestamo {
	private int codigoPrestamo;
	private LocalDate fecha;
	private double importePagar;
	private double importePedido;
	private int plazoPago;
	private double montoCuota;
	private int cuotas;
	private int estado;
	private EstadoPrestamo estadoPrestamo;
	private Usuario cliente;
	
	public Prestamo() {
		
	}

	public Prestamo(int codigoPrestamo, LocalDate fecha, double importePagar, double importePedido, int plazoPago,
			double montoCuota, int cuotas, int estado, EstadoPrestamo estadoPrestamo, Usuario cliente) {
		super();
		this.codigoPrestamo = codigoPrestamo;
		this.fecha = fecha;
		this.importePagar = importePagar;
		this.importePedido = importePedido;
		this.plazoPago = plazoPago;
		this.montoCuota = montoCuota;
		this.cuotas = cuotas;
		this.estado = estado;
		this.estadoPrestamo = estadoPrestamo;
		this.cliente = cliente;
	}

	public int getCodigoPrestamo() {
		return codigoPrestamo;
	}

	public void setCodigoPrestamo(int codigoPrestamo) {
		this.codigoPrestamo = codigoPrestamo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getImportePagar() {
		return importePagar;
	}

	public void setImportePagar(double importePagar) {
		this.importePagar = importePagar;
	}

	public double getImportePedido() {
		return importePedido;
	}

	public void setImportePedido(double importePedido) {
		this.importePedido = importePedido;
	}

	public int getPlazoPago() {
		return plazoPago;
	}

	public void setPlazoPago(int plazoPago) {
		this.plazoPago = plazoPago;
	}

	public double getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(double montoCuota) {
		this.montoCuota = montoCuota;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public EstadoPrestamo getEstadoPrestamo() {
		return estadoPrestamo;
	}

	public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Prestamo [codigoPrestamo=" + codigoPrestamo + ", fecha=" + fecha + ", importePagar=" + importePagar
				+ ", importePedido=" + importePedido + ", plazoPago=" + plazoPago + ", montoCuota=" + montoCuota
				+ ", cuotas=" + cuotas + ", estado=" + estado + ", estadoPrestamo=" + estadoPrestamo + ", cliente="
				+ cliente + "]";
	}	
	
}

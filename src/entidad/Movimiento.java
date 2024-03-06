package entidad;

import java.time.LocalDate;

public class Movimiento {
	private int codigoMovimiento;
	private LocalDate fecha;
	private String detalle;
	private double importe;
	private int estado;
	private Cuenta cuenta;
	private TipoMovimiento tipoMovimiento;
	
	public Movimiento() {
		
	}

	public Movimiento(int codigoMovimiento, LocalDate fecha, String detalle, double importe, int estado, Cuenta cuenta,
			TipoMovimiento tipoMovimiento) {
		super();
		this.codigoMovimiento = codigoMovimiento;
		this.fecha = fecha;
		this.detalle = detalle;
		this.importe = importe;
		this.estado = estado;
		this.cuenta = cuenta;
		this.tipoMovimiento = tipoMovimiento;
	}

	public int getCodigoMovimiento() {
		return codigoMovimiento;
	}

	public void setCodigoMovimiento(int codigoMovimiento) {
		this.codigoMovimiento = codigoMovimiento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@Override
	public String toString() {
		return "Movimiento [codigoMovimiento=" + codigoMovimiento + ", fecha=" + fecha + ", detalle=" + detalle
				+ ", importe=" + importe + ", estado=" + estado + ", cuenta=" + cuenta + ", tipoMovimiento="
				+ tipoMovimiento + "]";
	}
	
}

package entidad;

import java.time.LocalDate;

public class Cuenta {
	private int numeroCuenta;
	private LocalDate fechaCreacion;
	private String cbu;
	private double saldo;
	private int estado;
	private TipoCuenta tipoCuenta;
	private Usuario cliente;
	
	public Cuenta() {
		
	}

	public Cuenta(int numeroCuenta, LocalDate fechaCreacion, String cbu, double saldo, int estado,
			TipoCuenta tipoCuenta, Usuario cliente) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.fechaCreacion = fechaCreacion;
		this.cbu = cbu;
		this.saldo = saldo;
		this.estado = estado;
		this.tipoCuenta = tipoCuenta;
		this.cliente = cliente;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", fechaCreacion=" + fechaCreacion + ", cbu=" + cbu + ", saldo="
				+ saldo + ", estado=" + estado + ", tipoCuenta=" + tipoCuenta + ", cliente=" + cliente + "]";
	}

}

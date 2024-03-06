package excepciones;

public class DuplicadaUKException extends com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException {
	private static final long serialVersionUID = 1L;
	public DuplicadaUKException() {}
	@Override
	public String getMessage() {
		return "Este CUIL ya esta registrado";
	}
	
}

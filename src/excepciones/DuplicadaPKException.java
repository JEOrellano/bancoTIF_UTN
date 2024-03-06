package excepciones;

public class DuplicadaPKException extends com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException{
	private static final long serialVersionUID = 1L;
	public DuplicadaPKException() {}
	@Override
	public String getMessage() {
		return "Este DNI ya esta registrado";
	}
}

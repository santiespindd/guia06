package excepciones;

public class LimiteCursadoException extends Exception {
	
	public LimiteCursadoException(){
		super("El alumno llego al limite de cursos en este ciclo");
	};
}

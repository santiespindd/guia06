package excepciones;

public class CupoCubiertoException extends Exception{
	public CupoCubiertoException() {
		super("El curso tiene el cupo completo");
	}
}

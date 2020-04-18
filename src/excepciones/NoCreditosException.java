package excepciones;

public class NoCreditosException extends Exception {
		
	String message;
	
	public NoCreditosException(){
		super("El alumno no posee los creditos suficientes para este curso");
	}


	
	

}

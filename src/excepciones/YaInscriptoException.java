package excepciones;

public class YaInscriptoException extends Exception{
	
	
	public YaInscriptoException(){
		super("El alumno ya esta inscripto");
	}
	//public YaInscriptoException(String msg){
		//super(msg);
	//}
}

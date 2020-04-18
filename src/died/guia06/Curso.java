package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	
	/*----------------CONSTRUCTORES---------------------*/

	public Curso() {
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}


	public Curso(Integer id, String nombre, Integer cicloLectivo, Integer cupo,
			Integer creditos, Integer creditosRequeridos) {
		
		this.id = id;
		this.nombre = nombre;
		this.cicloLectivo = cicloLectivo;
		this.cupo = cupo;
		this.creditos = creditos;
		this.creditosRequeridos = creditosRequeridos;
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}

	 /*-------------Getters & Setters --------------*/ 
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCicloLectivo() {
		return cicloLectivo;
	}


	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}


	public Integer getCupo() {
		return cupo;
	}


	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	public List<Alumno> getInscriptos() {
		return inscriptos;
	}


	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}


	public Integer getCreditos() {
		return creditos;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}


	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}


	public Registro getLog() {
		return log;
	}


	public void setLog(Registro log) {
		this.log = log;
	}


	/*--------------METODOS--------------- */
	

	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) {
		
		
			if(!this.inscriptos.contains(a)){
				if( a.creditosObtenidos() >= this.creditosRequeridos ){
					if(a.cantCursandoEnElCiclo() < 3){
						if(this.inscriptos.size()< this.cupo){
							
								try {
									log.registrar(this, "inscribir ",a.toString());	
								} catch (IOException e) {
									System.out.println("Hubo un error: " + e.getMessage());
									return false;
								}
					
								this.inscriptos.add(a);
								a.inscripcionAceptada(this);
								
						}else {
							System.out.println("Ya no hay cupo en el curso " + this.nombre);
							return false;
						}	
					}else{
						System.out.println("El aspirante "+ a.getNombre() +"esta cursando la cantidad maxima de cursos");
						return false;
					}
				}else {
					System.out.println("El aspirante "+ a.getNombre() + "no tiene los creditos suficientes para inscribirse a este curso");
					return false;
				}	
			}else{
				System.out.println("El alumno " + a.getNombre() +"ya esta inscripto");
				return false;
			}
				
		
		
		
		return true;
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 * @throws IOException 
	 */
	public void imprimirInscriptos()  {
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e) {
			System.out.println("Hubo un error " + e.getMessage());
		}
		
	}


}

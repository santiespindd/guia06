package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	/*----------------CONSTRUCTORES---------------------*/
	public Alumno(String nombre, Integer nroLibreta) {
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	public Alumno() {
	
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
	}
	
	
	
 /*-------------Getters & Setters --------------*/ 
	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public void setCursando(List<Curso> cursando) {
		this.cursando = cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public void setAprobados(List<Curso> aprobados) {
		this.aprobados = aprobados;
	}

	
	
	/*--------------METODOS--------------- */
	
	public int creditosObtenidos() {
		int creditos=0;
		for(Curso curso: aprobados){
			creditos += curso.getCreditos();
		}
		return creditos;
	}
	
	

	public void aprobar(Curso c) {
			if (cursando.contains(c)) {
			aprobados.add(c);
			cursando.remove(c);
		} else {
			System.out.println("El alumno " + this.nombre + " no esta cursando el curso " + c.getNombre());
		}
	}

	public void inscripcionAceptada(Curso c) {
		cursando.add(c);
	}
	
	public int cantCursandoEnElCiclo(){
		
		int cant = this.cursando.size();
		return cant;
	}
	

}

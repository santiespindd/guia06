package died.guia06;

import java.util.List;


public class Alumno {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public int creditosObtenidos() {
		int creditos=0;
		for(Curso curso: aprobados){
			creditos += curso.getCreditos();
		}
		return 1;
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

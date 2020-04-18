package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	Alumno alumno1;
	Alumno alumno2;
	Alumno alumno3;
	Curso curso1;
	Curso curso2;
	ArrayList<Curso> cursando;
	
	@BeforeEach
	public void init(){
		curso1 = new Curso(01, "Curso PHP", 2020, 3 , 10, 0);
		curso2 = new Curso(01, "Curso JAVA", 2020, 2 , 10, 0);
		alumno1 = new Alumno("Santiago Espindola", 23987);
		alumno2 = new Alumno("Nicolas Perez", 21587);
		alumno3 = new Alumno("Hector Lopez", 24879);
		cursando = new ArrayList<>();
	}
	
	@Test
	void testInscribir() {
		
		assertTrue(curso1.inscribir(alumno1) && curso1.getInscriptos().contains(alumno1));
	}
	@Test
	void testNoInscribir() {
		curso2.inscribir(alumno1);
		curso2.inscribir(alumno2);
		
		assertFalse(curso2.inscribir(alumno3) );
	}
	
	@Test
	void testInscribirAlumnos() throws Exception {
		
		assertTrue(curso1.inscribirAlumno(alumno1) && curso1.getInscriptos().contains(alumno1));
	}
	
	

}

package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest {
	Curso curso1;
	Curso curso2;
	Curso curso3;
	Alumno alumno1;
	ArrayList<Curso> cursosAprobados ;
	ArrayList<Curso> cursando ;
	
	@BeforeEach
	public void init(){
		
		 curso1 = new Curso(01, "Curso PHP", 2020, 3 , 10, 0);
		 curso2 = new Curso(02, "Curso ANGULAR", 2020, 5 , 25, 10);
		 curso3 = new Curso(03, "Curso SPRING BOOT", 2020, 10 , 25, 15);
		
		 alumno1 = new Alumno("Santiago Espindola", 23987);
		 
		  cursosAprobados = new ArrayList<>();
		  cursando = new ArrayList<>();
	}
	
	       
	@Test
	void testCreditosObtenidos() {
		
		cursosAprobados.add(curso1);
		cursosAprobados.add(curso2);
		cursosAprobados.add(curso3);
		alumno1.setAprobados(cursosAprobados);
		
		int esperado = alumno1.creditosObtenidos();
		
		assertEquals(60, esperado);
	}

	@Test
	void testAprobar() {
		cursando.add(curso1);
		alumno1.setCursando(cursando);
		alumno1.aprobar(curso1);
		assertTrue(alumno1.getAprobados().contains(curso1));
	}
	@Test
	void testNoAprobar() {
		alumno1.aprobar(curso1);
		assertFalse(alumno1.getAprobados().contains(curso1));
	}
	@Test
	void testInscripcionAceptada() {
		curso1.inscribir(alumno1);
		alumno1.inscripcionAceptada(curso3);
		assertTrue(alumno1.getCursando().contains(curso3));
		
	}
	@Test 
	void testCantidadCursandoEnElCiclo(){
		cursando.add(curso1);
		cursando.add(curso2);
		alumno1.setCursando(cursando);
		
		assertEquals(2,alumno1.cantCursandoEnElCiclo());
		
	}

}

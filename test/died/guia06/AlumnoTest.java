package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {
	
	Curso curso1 = new Curso(01, "Curso PHP", 2020, 3 , 10, 30);
	Curso curso2 = new Curso(02, "Curso ANGULAR", 2020, 5 , 25, 60);
	Curso curso3 = new Curso(03, "Curso SPRING BOOT", 2020, 10 , 25, 55);
	
	Alumno alumno1 = new Alumno("Santiago Espindola", 23987);
	@Test
	void testCreditosObtenidos() {
		fail("Not yet implemented");
	}

	@Test
	void testAprobar() {
		fail("Not yet implemented");
	}

	@Test
	void testInscripcionAceptada() {
		fail("Not yet implemented");
	}

}

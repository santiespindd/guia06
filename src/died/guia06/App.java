package died.guia06;

import java.util.ArrayList;

import excepciones.CupoCubiertoException;
import excepciones.LimiteCursadoException;
import excepciones.NoCreditosException;
import excepciones.RegistroAuditoriaException;
import excepciones.YaInscriptoException;

public class App {

	public static void main(String[] args) throws Exception {
		ArrayList<Curso> cursosAprobados = new ArrayList<>();
		ArrayList<Curso>  cursando = new ArrayList<>();
		 
			Alumno alumno1 = new Alumno("Santiago Espindola",23978);
			Alumno alumno2 = new Alumno("Nicolas Perez", 21487);
			Alumno alumno3 = new Alumno("Carlos Salazar",22879);
		    Alumno alumno4 = new Alumno("Sofia Lopez", 23815);
			
		
			Curso curso1 = new Curso(01, "Curso PHP", 2020, 3 , 10, 0);
			Curso curso2 = new Curso(02, "Curso ANGULAR", 2020, 5 , 25, 0);
			Curso curso3 = new Curso(03, "Curso SPRING BOOT", 2020, 10 , 25, 5);
			Curso curso4 = new Curso(04, "Curso PHP7", 2020, 3 , 10, 0);
			Curso curso5 = new Curso(05, "Curso ANGULAR9", 2020, 5 , 25, 10);
			Curso curso6 = new Curso(06, "Curso LARAVEL", 2020, 10 , 25, 15);
			
			
			/*No hay cupo para Sofia*/
			
			curso1.inscribir(alumno1);
			curso1.inscribir(alumno2);
			curso1.inscribir(alumno3);
			curso1.inscribir(alumno4);
		
			/*No cumple con los creditos*/
			
			curso6.inscribir(alumno1);
			
			/*Cantidad maxima de cursos*/
			
			curso2.inscribir(alumno1);
			
			/*Aprueba y tiene creditos para cursar el curso3*/
			
			alumno1.aprobar(curso1);
			alumno1.aprobar(curso2);
		
			cursosAprobados.add(curso1);
			cursosAprobados.add(curso2);
			
			alumno1.setAprobados(cursosAprobados);
		
		
			curso3.inscribir(alumno1);
			curso4.inscribir(alumno1);
			curso5.inscribir(alumno1);
			
			
			cursando.add(curso3);
			cursando.add(curso4);
			cursando.add(curso5);
			alumno1.setCursando(cursando);
			
			curso6.inscribir(alumno1);
			
			/*Cuantos cursos tiene alumno1*/
			System.out.println("Alumno 1 cursa : " + alumno1.cantCursandoEnElCiclo() + " cursos");
			
			/*Imprimir alumnos curso1*/
			
			System.out.print("Alumnos de " + curso1.getNombre() + " : ");
			curso1.imprimirInscriptos();
			
			
			/*Creditos Obtenidos*/
			
			alumno2.aprobar(curso1);
			
			System.out.println(alumno1.creditosObtenidos());
			System.out.println(alumno2.creditosObtenidos());
			System.out.println(alumno3.creditosObtenidos());
			
			/*Probar metodo inscribirAlumno*/
		
	         try {
	        	 curso1.inscribirAlumno(alumno1);
				
			} catch (YaInscriptoException  | CupoCubiertoException | LimiteCursadoException | NoCreditosException | RegistroAuditoriaException e  ){
				e.printStackTrace();
			}
				
	         try {
	        	 curso6.inscribirAlumno(alumno1);
				
			} catch (YaInscriptoException  | CupoCubiertoException | LimiteCursadoException | NoCreditosException | RegistroAuditoriaException e  ){
				e.printStackTrace();
			}
			
		
	}
}

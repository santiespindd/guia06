package died.guia06;

import java.util.Comparator;

public class CompararCreditosObtenidos implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		
		return (o2.creditosObtenidos() - o1.creditosObtenidos());
	}

}

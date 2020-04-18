package died.guia06;

import java.util.Comparator;

public class CompararLibreta implements Comparator<Alumno> {

	@Override
	public int compare(Alumno a1, Alumno a2) {
		
		return a2.getNroLibreta() - a1.getNroLibreta() ;
	}

	
}

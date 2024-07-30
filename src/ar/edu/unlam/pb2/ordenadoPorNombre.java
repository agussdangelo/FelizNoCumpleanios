package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ordenadoPorNombre implements Comparator<Alimento> {

	@Override
	public int compare(Alimento o1, Alimento o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}

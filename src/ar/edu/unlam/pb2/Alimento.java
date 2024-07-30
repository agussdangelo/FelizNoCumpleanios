package ar.edu.unlam.pb2;

public class Alimento implements Comparable<Alimento>{
	
	private String nombre;
	private Double precio;

	public Alimento(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public int compareTo(Alimento o) {
		return nombre.compareTo(o.getNombre());
	}
	
}

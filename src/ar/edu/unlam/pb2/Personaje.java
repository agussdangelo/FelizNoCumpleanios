package ar.edu.unlam.pb2;

public class Personaje {
	
	private Integer altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	protected Double dinero;
	
	public Personaje(Integer altura, Double peso, String nombre, Integer edad, Double dinero) {
		this.altura = altura;
		this.peso = peso;
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getDinero() {
		return dinero;
	}

	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}
	
	public Boolean comprarAlimentoAchicador(Supermercado mercado, Alimento achicador) {
		if(this.dinero > achicador.getPrecio() && mercado.cantidadDeAchicadores() != null) {
			this.dinero -= achicador.getPrecio();
			return true;
		}
		return false;
	}

	public Boolean comprarAlimentoAgrandador(Supermercado mercado, Alimento agrandador) {
		if(this.dinero > agrandador.getPrecio() && mercado.cantidadDeAgrandadores() != null) {
			this.dinero -= agrandador.getPrecio();
			return true;
		}
		return false;
	}
	
	public Integer consumirAlimento(Alimento alimento) {
	    if (alimento instanceof Agrandador) {
	        if (this.altura + 40 > 280) {
	            this.altura = 280;
	        } else {
	            this.altura += 40;
	        }
	    } else if (alimento instanceof Achicador) {
	        if (this.altura - 50 < 50) {
	            this.altura = 50;
	        } else {
	            this.altura -= 50;
	        }
	    }
	    return this.altura;
	}


}

package ar.edu.unlam.pb2;

import java.util.Comparator;
import java.util.TreeSet;

public class Supermercado{

	private TreeSet<Alimento> achicadores;
	private TreeSet<Alimento> agrandadores;
	
	public Supermercado() {
		this.achicadores = new TreeSet<Alimento>();
		this.agrandadores = new TreeSet<Alimento>();
	}

	public TreeSet<Alimento> getAchicadores() {
		return achicadores;
	}

	public void setAchicadores(TreeSet<Alimento> achicadores) {
		this.achicadores = achicadores;
	}

	public TreeSet<Alimento> getAgrandadores() {
		return agrandadores;
	}

	public void setAgrandadores(TreeSet<Alimento> agrandadores) {
		this.agrandadores = agrandadores;
	}
	
	public Boolean agregarAlimentoAchicador(Alimento achicador) {
		return achicadores.add(achicador);
	}
	
	public Boolean alimentoAchicadorConsumido(Alimento achicador) {
		return achicadores.remove(achicador);
	}
	
	public Boolean agregarAlimentoAgrandador(Alimento agrandador) {
		return agrandadores.add(agrandador);
	}
	
	public Boolean alimentoAgrandadorConsumido(Alimento agrandador) {
		return agrandadores.remove(agrandador);
	}
	
	public Integer cantidadDeAgrandadores() {
		return agrandadores.size();
	}
	
	public Integer cantidadDeAchicadores() {
		return achicadores.size();
	}

	public TreeSet<Alimento> devolverAlimentosOrdenadosPorNombre() {
		return ordenarAlimentosParaDevolver(new ordenadoPorNombre());
	}
	
	public TreeSet<Alimento> ordenarAlimentosParaDevolver(Comparator<Alimento> citerioDeOrdenacion) {
		TreeSet<Alimento> alimentoOrdenado = new TreeSet<Alimento>(citerioDeOrdenacion);
		alimentoOrdenado.addAll(achicadores);
		return alimentoOrdenado;
	}
	
	
}

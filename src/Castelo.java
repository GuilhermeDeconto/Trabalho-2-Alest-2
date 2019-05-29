import java.util.ArrayList;

public class Castelo {
	
	private int numero_castelo;
	private int tamanho_exercito;
	private int exercito_restante;
	private ArrayList<Castelo> listaCastelosProximos;
	
	public Castelo(int numero_castelo, int tamanho_exercito) {
		super();
		this.listaCastelosProximos = new ArrayList<>();
		this.numero_castelo = numero_castelo;
		this.tamanho_exercito = tamanho_exercito;
		this.exercito_restante = tamanho_exercito;
	}

	public int getExercito_restante() {
		return exercito_restante;
	}


	public void setExercito_restante(int exercito_restante) {
		this.exercito_restante = exercito_restante;
	}


	public void addCastelo(Castelo c) {
		listaCastelosProximos.add(c);
	}
	
	public ArrayList<Castelo> getCastelosProximos(){
		return this.listaCastelosProximos;
	}

	public int getNumero_castelo() {
		return numero_castelo;
	}


	public void setNumero_castelo(int numero_castelo) {
		this.numero_castelo = numero_castelo;
	}


	public int getTamanho_exercito() {
		return tamanho_exercito;
	}


	public void setTamanho_exercito(int tamanho_exercito) {
		this.tamanho_exercito = tamanho_exercito;
	}
}

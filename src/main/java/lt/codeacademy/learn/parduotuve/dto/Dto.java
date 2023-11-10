package lt.codeacademy.learn.parduotuve.dto;

import java.util.List;

import lt.codeacademy.learn.parduotuve.entities.Eilute;


public class Dto {

	Long id;
	String pavadinimas;
	double kaina;
	int kiekis;
	double suma;
	double pvm;
	double suma1;
	double pvm1;
	
	List<Eilute> prekiuSuma;
	
	public Dto(Eilute eilute){
		this.id = eilute.getId();
		this.pavadinimas = eilute.getPreke().getPavadinimas();
		this.kaina = eilute.getPreke().getKaina();
		this.kiekis = eilute.getKiekis();
		this.suma = eilute.getSuma();
		this.pvm = suma * 0.21f;
		this.suma1 = prekiuSuma.stream().mapToDouble(e -> e.getSuma()).sum();
		this.pvm1 = suma * 0.21f;
		
	}
	public Dto() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public double getKaina() {
		return kaina;
	}

	public void setKaina(double kaina) {
		this.kaina = kaina;
	}

	public int getKiekis() {
		return kiekis;
	}

	public void setKiekis(int kiekis) {
		this.kiekis = kiekis;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public double getPvm() {
		return pvm;
	}

	public void setPvm(double pvm) {
		this.pvm = pvm;
	}

	public double getSuma1() {
		return suma1;
	}

	public void setSuma1(double suma1) {
		this.suma1 = suma1;
	}

	public double getPvm1() {
		return pvm1;
	}

	public void setPvm1(double pvm1) {
		this.pvm1 = pvm1;
	}






}
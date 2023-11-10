package lt.codeacademy.learn.parduotuve.dto;

import lt.codeacademy.learn.parduotuve.entities.Eilute;

public class IrasasDto {
	
	Long id;
	String pavadinimas;
	double kaina;
	int kiekis;
	double suma;
	
	public IrasasDto() {}
	
	public IrasasDto(Eilute eilute) {
		this.id = eilute.getPreke().getId();
		this.pavadinimas = eilute.getPreke().getPavadinimas();
		this.kaina = eilute.getPreke().getKaina();
		this.kiekis = eilute.getKiekis();
		this.suma = eilute.getSuma();
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "IrasasDto [id=" + id + ", pavadinimas=" + pavadinimas + ", kaina=" + kaina + ", kiekis=" + kiekis
				+ ", suma=" + suma + "]";
	}

}

package lt.codeacademy.learn.parduotuve.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preke {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(name="prekes_pavadinimas")
	String pavadinimas;
	
	@Column(name="prekes_kaina")
	Double kaina;

	public Preke(Long id, String pavadinimas, Double kaina) {
		this.id = id;
		this.pavadinimas = pavadinimas;
		this.kaina = kaina;
	}

	public Preke(String pavadinimas, Double kaina) {
		this.pavadinimas = pavadinimas;
		this.kaina = kaina;
	}

	public Preke() {
	}

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

	public Double getKaina() {
		return kaina;
	}

	public void setKaina(Double kaina) {
		this.kaina = kaina;
	}

	@Override
	public String toString() {
		return "Preke [id=" + id + ", pavadinimas=" + pavadinimas + ", kaina=" + kaina + "]";
	}
	

}

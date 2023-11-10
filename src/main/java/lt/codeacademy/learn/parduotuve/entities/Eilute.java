package lt.codeacademy.learn.parduotuve.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Eilute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	int kiekis;
	
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="preke_id", referencedColumnName = "id")
	Preke preke;
	
	public Eilute(Long id, int kiekis, Preke preke) {
		this.id = id;
		this.kiekis = kiekis;
		this.preke = preke;
	}

	public Eilute(int kiekis, Preke preke) {
		this.kiekis = kiekis;
		this.preke = preke;
	}

	public Eilute() {
	}

	public double getSuma() {
		return preke.kaina * kiekis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKiekis() {
		return kiekis;
	}

	public void setKiekis(int kiekis) {
		this.kiekis = kiekis;
	}

	public Preke getPreke() {
		return preke;
	}

	public void setPreke(Preke preke) {
		this.preke = preke;
	}
}

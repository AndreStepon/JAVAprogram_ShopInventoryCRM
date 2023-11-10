package lt.codeacademy.learn.parduotuve.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "kvitas")
public class Kvitas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@ManyToMany
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
	@Column(name="eilute_id")
	List<Eilute> eilutes = new ArrayList<>();

	public Kvitas(Long id, List<Eilute> eilutes) {
		this.id = id;
		this.eilutes = eilutes;
	}

	public Kvitas(List<Eilute> eilutes) {
		this.eilutes = eilutes;
	}
	public Kvitas() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Eilute> getEilutes() {
		return eilutes;
	}

	public void setEilutes(List<Eilute> eilutes) {
		this.eilutes = eilutes;
	}
	
	public void addEilute(Eilute eilute) {
		this.eilutes.add(eilute);
	}
}

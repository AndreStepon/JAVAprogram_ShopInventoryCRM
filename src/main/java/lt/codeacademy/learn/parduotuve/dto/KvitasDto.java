package lt.codeacademy.learn.parduotuve.dto;

import java.util.List;

import lt.codeacademy.learn.parduotuve.entities.Kvitas;
//anotacijos nereikia
public class KvitasDto {
	
	Long id;
	List<IrasasDto> irasai;
	double suma;
	double pvm;
	
	public KvitasDto() {
	}

	public KvitasDto(Kvitas kvitas){
		this.id = kvitas.getId();
//		this.irasai = new ArrayList<>();
//		for(Eilute el : kvitas.getEilutes()) {
//			irasai.add(new IrasasDto(el));
//		}
		this.irasai = kvitas.getEilutes().stream().map( e -> new IrasasDto(e)).toList();
		this.suma = irasai.stream().mapToDouble( e -> e.getSuma()).sum();
		this.pvm = suma * 0.21f; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<IrasasDto> getIrasai() {
		return irasai;
	}

	public void setIrasai(List<IrasasDto> irasai) {
		this.irasai = irasai;
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

	@Override
	public String toString() {
			String atsakymas = "KvitasDto [id=" + id + ", suma=" + suma + ", pvm=" + pvm + "]";
			if (irasai == null)
				return atsakymas;
		for (IrasasDto irasas: irasai) {
			atsakymas += "\n" + irasas;
		}
		return atsakymas;
	}
	
	
	
}

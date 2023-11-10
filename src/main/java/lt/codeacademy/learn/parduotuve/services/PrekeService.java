package lt.codeacademy.learn.parduotuve.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.learn.parduotuve.dto.IrasasDto;
import lt.codeacademy.learn.parduotuve.dto.KvitasDto;
import lt.codeacademy.learn.parduotuve.entities.Eilute;
import lt.codeacademy.learn.parduotuve.entities.Preke;
import lt.codeacademy.learn.parduotuve.repositories.PrekeRepository;

@Service
public class PrekeService {
	
	@Autowired
	PrekeRepository prekeRepository;
	
	public List<Preke> getAllPreke(){
		return prekeRepository.findAll();
	}
	
	public KvitasDto getNewKvitasDto() {
		KvitasDto dto = new KvitasDto();
		List<IrasasDto> irasai = 
				getAllPreke()
				.stream()
				.map(p -> new Eilute(0, p))
				.map(e -> new IrasasDto(e))
				.toList();
		dto.setIrasai(irasai);
		return dto;
	}

}

package lt.codeacademy.learn.parduotuve.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.learn.parduotuve.dto.Dto;
import lt.codeacademy.learn.parduotuve.dto.IrasasDto;
import lt.codeacademy.learn.parduotuve.dto.KvitasDto;
import lt.codeacademy.learn.parduotuve.entities.Eilute;
import lt.codeacademy.learn.parduotuve.entities.Kvitas;
import lt.codeacademy.learn.parduotuve.entities.Preke;
import lt.codeacademy.learn.parduotuve.repositories.EiluteRepository;
import lt.codeacademy.learn.parduotuve.repositories.KvitasRepository;
import lt.codeacademy.learn.parduotuve.repositories.PrekeRepository;

@Service
public class KvitasService {
	
	Logger logger = LoggerFactory.getLogger(KvitasService.class);
	
	@Autowired
	KvitasRepository kvitasRepository;
	
	@Autowired
	PrekeRepository prekeRepository;
	
	@Autowired
	EiluteRepository eiluteRepository;
	

	public List<KvitasDto> getAll() {

		List<Kvitas> seniKvitai = kvitasRepository.findAll();
		return seniKvitai.stream().map( k -> new KvitasDto(k)).toList();
	}
	
	public List<Dto> getAllKvitai(){
		List<Eilute> kvitukai = eiluteRepository.findAll();
		return kvitukai.stream().map(e -> new Dto(e)).toList();
	}
	
	public void saveKvitas(KvitasDto kvitasDto) {
		logger.info(kvitasDto.toString());
		List<Eilute> eilutes = new ArrayList<>();
		for(IrasasDto irasas: kvitasDto.getIrasai()) {
			if (irasas.getKiekis()<=0)
				continue;
			Preke preke = prekeRepository.findById(irasas.getId()).get();
			Eilute eilute = new Eilute(irasas.getKiekis(), preke);
			eilutes.add(eilute);
		}
		Kvitas kvitas = new Kvitas(eilutes);
		kvitasRepository.save(kvitas);
	}

}

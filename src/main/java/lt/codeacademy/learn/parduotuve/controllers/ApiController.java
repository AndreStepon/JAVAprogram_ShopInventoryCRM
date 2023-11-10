package lt.codeacademy.learn.parduotuve.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.learn.parduotuve.dto.Dto;
import lt.codeacademy.learn.parduotuve.dto.IrasasDto;
import lt.codeacademy.learn.parduotuve.dto.KvitasDto;
import lt.codeacademy.learn.parduotuve.entities.Eilute;
import lt.codeacademy.learn.parduotuve.entities.Kvitas;
import lt.codeacademy.learn.parduotuve.entities.Preke;
import lt.codeacademy.learn.parduotuve.repositories.KvitasRepository;
import lt.codeacademy.learn.parduotuve.services.KvitasService;
import lt.codeacademy.learn.parduotuve.services.PrekeService;

@RestController //grazina objektus
@RequestMapping("api")
public class ApiController {
	
	@Autowired
	PrekeService prekeService;
	
	@Autowired
	KvitasRepository kvitasRepository;
	
	@Autowired
	KvitasService kvitasService;
	
	@GetMapping("/prekes")
	public List<Preke> getAllPreke(){
		return prekeService.getAllPreke();
	}
	
	@GetMapping("/kvitas")
	public Kvitas getKvitas() {
		return kvitasRepository.findById(1L).get();
	}
	
	@GetMapping("/kvitai")
	public List<KvitasDto> getKvitai(){
		return kvitasService.getAll();
	}
	
	@GetMapping("/kvitukai")
	public List<Dto> getKvitukai(){
		return kvitasService.getAllKvitai();
	}
	
	@GetMapping("/dto")
	public KvitasDto getEmptyDto() {
		return prekeService.getNewKvitasDto();
	}
}
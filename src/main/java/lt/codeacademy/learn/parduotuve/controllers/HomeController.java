package lt.codeacademy.learn.parduotuve.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lt.codeacademy.learn.parduotuve.dto.KvitasDto;
import lt.codeacademy.learn.parduotuve.services.KvitasService;
import lt.codeacademy.learn.parduotuve.services.PrekeService;


@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	PrekeService prekeService;
	@Autowired
	KvitasService kvitasService;
	
	@GetMapping("/addkvitas")
	public String getAddKvitas(KvitasDto kvitasDto, Model model) {
		model.addAttribute("kvitas", prekeService.getNewKvitasDto()); // idedame i model del patogumo dirbti
		return "add-kvitas";
	}
	
	@PostMapping("/submitKvitas")
	public String submitKvitas(@ModelAttribute KvitasDto kvitasDto, Model model) {
	
		kvitasService.saveKvitas(kvitasDto);
		
		model.addAttribute("kvitas", prekeService.getNewKvitasDto());
		return "redirect:/api/kvitai";
	}	
	
	@GetMapping("/kvitai")
	public String getKvitai(Model model) {
		model.addAttribute("kvitai", kvitasService.getAll());
		return "kvitai";
	}
	
	
	
}

package lt.codeacademy.learn.parduotuve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import lt.codeacademy.learn.parduotuve.entities.Eilute;
import lt.codeacademy.learn.parduotuve.entities.Kvitas;
import lt.codeacademy.learn.parduotuve.entities.Preke;
import lt.codeacademy.learn.parduotuve.repositories.KvitasRepository;
import lt.codeacademy.learn.parduotuve.repositories.PrekeRepository;

@Configuration
public class Observer {
	
	@Autowired
	PrekeRepository prekeRepository;
	
	@Autowired
	KvitasRepository kvitasRepository;
	
	@EventListener
	public void seed(ContextRefreshedEvent ev) {
		//seedPrekesDummyData();
		//seedTestKvitas();
		
	}

	private void seedPrekesDummyData() {
		List<Preke> prekes = List.of(
				new Preke("Pienas 1L, 3.2%", 0.80d),
				new Preke("Sviestas 180gr, 80%", 2.49d),
				new Preke("Juoda duona", 1.59d),
				new Preke("Cukinijos, 1vnt.", 0.99d),
				new Preke("Vistienos file, 500gr", 2.99d),
				new Preke("Grietine, 400gr, 30%", 1.99d));
		prekeRepository.saveAll(prekes);
		
		
	}
	
	private void seedTestKvitas() {
		Kvitas kvitas = new Kvitas();
		kvitas.addEilute(new Eilute(2, prekeRepository.findById(1L).get()));
		kvitas.addEilute(new Eilute(1, prekeRepository.findById(2L).get()));
		kvitas.addEilute(new Eilute(1, prekeRepository.findById(5L).get()));
		kvitas.addEilute(new Eilute(1, prekeRepository.findById(3L).get()));
		
		kvitasRepository.save(kvitas);
	}
	
	

}

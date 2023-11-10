package lt.codeacademy.learn.parduotuve.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.learn.parduotuve.entities.Eilute;

@Repository
public interface EiluteRepository extends JpaRepository<Eilute, Long>{

}

package be.vdab.repositories;

import be.vdab.entities.Brouwer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrouwerRepository extends JpaRepository<Brouwer, Long> {
	List<Brouwer> findByNaamStartsWithOrderByNaamAsc(String beginNaam);
}

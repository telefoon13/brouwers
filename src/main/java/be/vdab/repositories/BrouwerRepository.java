package be.vdab.repositories;

import be.vdab.entities.Brouwer;

import java.util.List;

public interface BrouwerRepository {
	void create(Brouwer brouwer);
	List<Brouwer> findAll();
	List<Brouwer> findByNaam(String beginNaam);
}

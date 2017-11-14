package be.vdab.services;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DefaultBrouwerService implements BrouwerService {

	private final BrouwerRepository brouwerRepository;

	DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}

	@Override
	public void create(Brouwer brouwer) {
		brouwerRepository.create(brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll();
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return brouwerRepository.findByNaam(beginNaam);
	}
}

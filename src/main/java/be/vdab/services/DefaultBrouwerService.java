package be.vdab.services;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@ReadOnlyTransactionalService
class DefaultBrouwerService implements BrouwerService {

	private final BrouwerRepository brouwerRepository;

	DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}

	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Brouwer brouwer) {
		brouwerRepository.save(brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll(new Sort("naam"));
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return brouwerRepository.findByNaamStartsWithOrderByNaamAsc(beginNaam);
	}
}

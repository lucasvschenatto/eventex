package main.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import main.domain.Text;
import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;
import main.persistence.EntityNotFoundException;

public class InMemoryAssociateRepository extends InMemoryRepository<Associate> implements AssociateRepository{
	private Map<Text, Associate> associates = new HashMap<>();
	public Associate getByCode(Text code) {
		if(hasWithCode(code))
			return makeCopy(associates.get(code));
		else
			throw new EntityNotFoundException();
	}
	
	public boolean hasWithCode(Text code) {
		return associates.containsKey(code);
	}

	public void save(Associate a){
		if(hasWithId(a.getId()))
			associates.remove(getById(a.getId()).getCode());
		super.save(a);
		associates.put(a.getCode(), getById(a.getId()));
	}

	public Iterable<Associate> getAllForCategoryId(Text categoryId) {
		Set<Associate> filteredByCategoryId = new HashSet<Associate>();
		getAll().forEach((associate)->{
			if(associate.getCategoryId().equals(categoryId))
				filteredByCategoryId.add(associate);
		});
		return filteredByCategoryId;
	}

}

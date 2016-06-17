package main.persistence.inmemory;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public void save(Associate associate){
		super.save(associate);
		associates.put(associate.getCode(), associate);
	}

}

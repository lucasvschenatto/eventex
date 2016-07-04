package main.persistence.inmemory;

import java.util.HashMap;
import java.util.Map;

import main.domain.Text;
import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;
import main.persistence.EntityNotFoundException;

public class InMemoryAdminRepository extends InMemoryRepository<Admin> implements AdminRepository {
	private Map<Text,Admin> admins = new HashMap<Text,Admin>();

	public Admin getByUserId(Text userId) {
		if(hasWithUserId(userId))
			return makeCopy(admins.get(userId));
		else
			throw new EntityNotFoundException();
	}
	public boolean hasWithUserId(Text userId) {
		return admins.containsKey(userId);
	}
	
	public void save(Admin a){
		if(hasWithId(a.getId()))
			admins.remove(getById(a.getId()).getUserId());
		super.save(a);
		admins.put(a.getUserId(), getById(a.getId()));
	}
}
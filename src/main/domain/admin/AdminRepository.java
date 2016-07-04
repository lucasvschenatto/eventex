package main.domain.admin;

import main.domain.Repository;
import main.domain.Text;

public interface AdminRepository extends Repository<Admin> {
	boolean hasWithUserId(Text userId);
	Admin getByUserId(Text userId);
}

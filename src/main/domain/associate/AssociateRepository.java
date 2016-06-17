package main.domain.associate;

import main.domain.Repository;
import main.domain.Text;
import main.domain.associate.Associate;

public interface AssociateRepository extends Repository<Associate> {

	Associate getByCode(Text associateCode);

	boolean hasWithCode(Text associateCode);
}

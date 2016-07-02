package main.persistence.inmemory;

import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;

public class InMemoryAdminRepository extends InMemoryRepository<Admin> implements AdminRepository {
}
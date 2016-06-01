package main.persistence.inmemory;

import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;

public class InMemoryActivityRepository extends InMemoryRepository<Activity> implements ActivityRepository {
}

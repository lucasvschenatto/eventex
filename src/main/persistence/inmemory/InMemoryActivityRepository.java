package main.persistence.inmemory;

import main.domain.event.activity.Activity;
import main.domain.event.activity.ActivityRepository;

public class InMemoryActivityRepository extends InMemoryRepository<Activity> implements ActivityRepository {
}

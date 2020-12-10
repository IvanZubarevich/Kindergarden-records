package by.company.kindergartens.repos;

import by.company.kindergartens.models.Kindergarten;
import org.springframework.data.repository.CrudRepository;

public interface KindergartenRepository extends CrudRepository<Kindergarten, Long> {
    Kindergarten findByKinder(String kindergarten);
}

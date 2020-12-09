package by.company.kindergartens.repos;

import by.company.kindergartens.models.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InformationRepository extends JpaRepository<Information, Long> {

}

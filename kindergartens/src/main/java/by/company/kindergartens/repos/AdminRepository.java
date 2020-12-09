package by.company.kindergartens.repos;

import by.company.kindergartens.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByKindergarten(String kindergarten);
    Admin findByUsername(String username);
    Admin findByActivationCode(String code);
    Admin findByEmail(String email);
}

package ua.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.library.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

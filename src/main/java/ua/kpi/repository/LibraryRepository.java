package ua.kpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.library.model.Library;

public interface LibraryRepository  extends JpaRepository<Library, Integer> {
}

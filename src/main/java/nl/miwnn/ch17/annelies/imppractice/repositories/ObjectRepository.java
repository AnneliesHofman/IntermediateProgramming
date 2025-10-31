package nl.miwnn.ch17.annelies.imppractice.repositories;

import nl.miwnn.ch17.annelies.imppractice.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<Object, Long> {
}

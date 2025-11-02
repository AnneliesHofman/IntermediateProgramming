package nl.miwnn.ch17.annelies.imppractice.repositories;

import nl.miwnn.ch17.annelies.imppractice.model.ColorCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorCategoryRepository extends JpaRepository<ColorCategory, Long> {
}

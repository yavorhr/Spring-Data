package xmlExercise.cardealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xmlExercise.cardealer.model.entity.Part;

public interface PartRepository extends JpaRepository<Part,Long> {
}

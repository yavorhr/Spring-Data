package xmlExercise.cardealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xmlExercise.cardealer.model.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}

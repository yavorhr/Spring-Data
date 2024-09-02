package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentTypeEnum;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

  Apartment findByTown_TownNameAndArea(String town_townName, Double area);
}

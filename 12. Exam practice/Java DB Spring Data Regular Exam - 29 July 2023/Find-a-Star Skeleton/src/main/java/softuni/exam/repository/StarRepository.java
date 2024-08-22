package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

}

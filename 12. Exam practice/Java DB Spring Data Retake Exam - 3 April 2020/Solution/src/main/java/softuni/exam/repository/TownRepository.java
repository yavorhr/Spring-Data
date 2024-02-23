package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Entity.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Town findByName(String name);
}

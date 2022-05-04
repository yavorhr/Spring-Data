package xmlExercise.cardealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xmlExercise.cardealer.model.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findCarsByMakeEqualsOrderByModelAscTravelledDistanceDesc(String make);

    @Query("SELECT c FROM Car c")
    List <Car> getAllCarsWithParts();
}

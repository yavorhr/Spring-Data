package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.CarTypeEnum;
import softuni.exam.models.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

  @Query("SELECT t FROM Task t JOIN Car c ON t.car.id = c.id WHERE c.carType=:type ORDER BY t.price DESC")
  List<Task> findAllCoupeCarsFilterByTaskPriceDesc(CarTypeEnum type);

}

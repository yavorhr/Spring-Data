package xmlExercise.cardealer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xmlExercise.cardealer.model.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c ORDER BY c.birthDate ASC, c.isYoungDriver ASC")
    List<Customer> findAllCustomersOrderedByBirthdayAndExperience();

//    @Query
//            (value = "select c.name, count(s.id) as carsBought, sum(p.price)\n" +
//                    "from customers as c\n" +
//                    "join sales s on c.id = s.customer_id\n" +
//                    "join cars_parts cp on s.car_id = cp.car_id\n" +
//                    "join parts p on p.id = cp.parts_id\n" +
//                    "group by c.id\n" +
//                    "having carsBought > 1;", nativeQuery = true)
//    List<String> findAllByCarsBoughtMoreThanOne();
//

}

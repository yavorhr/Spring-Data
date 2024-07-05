import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("code_first_exercise");

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    //     04. Hospital Database
    

//    // 03. University System
//    Teacher teacher = new Teacher();
//
//    teacher.setFirstName("Mike");
//    teacher.setLastName("Dean");
//    teacher.setPhoneNumber("+3598888888");
//    teacher.setEmail("teacher@abv.bg");
//    teacher.setSalaryPerHour(BigDecimal.valueOf(1.50));
//
//    Course course = new Course();
//    course.setName("Math");
//    course.setStartDate(LocalDate.now());
//    course.setEndDate(LocalDate.of(2005, 10, 10));
//
//    teacher.getCourses().add(course);
//    course.setTeacher(teacher);

//    em.persist(teacher);

//    02. Sales Database

//     em.getTransaction().begin();

//    //Create sale
//    Sale sale = new Sale();
//    sale.setDate(LocalDateTime.now());
//
//    //Create product
//    Product product = new Product();
//    product.setName("PC");
//    product.setPrice(BigDecimal.TEN);
//    product.setQuantity(1L);
//
//    //Cascade = cascade.PERSIST
//    product.getSales().add(sale);
//    sale.setProduct(product);
//    em.persist(product);

//    //Delete product
//    Product findProduct = em.find(Product.class, 1);
//    em.remove(findProduct);

    em.getTransaction().commit();

  }
}

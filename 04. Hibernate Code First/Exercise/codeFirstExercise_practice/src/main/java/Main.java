import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("code_first_exercise");

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
//
//    //     04. Hospital Database
//    // Create Patient
//    Patient patient = new Patient(
//            "Ivan",
//            "Ivanov",
//            "ivanov@abv.bg",
//            LocalDate.of(1991, 10, 12));
//
//    //Create Medicaments
//    Medicament med1 = new Medicament("Analgin");
//    Medicament med2 = new Medicament("teraflu");
//    med1.setPatient(patient);
//    med2.setPatient(patient);
//
//    //Create Visit
//    Visit firstVisit = new Visit(LocalDateTime.now());
//    Visit secondVisit = new Visit(LocalDateTime.now());
//    firstVisit.setPatient(patient);
//    secondVisit.setPatient(patient);
//
//    //Create diagnoses
//    Diagnose firstDiagnose = new Diagnose("Flu");
//    Diagnose secondDiagnose = new Diagnose("Headache");
//    firstDiagnose.setPatient(patient);
//    secondDiagnose.setPatient(patient);
//
//    patient.setVisitations(Set.of(firstVisit, secondVisit));
//    patient.setMedicaments(Set.of(med1,med2));
//    patient.setDiagnoses(Set.of(firstDiagnose, secondDiagnose));
//    patient.setDiagnoses(Set.of(firstDiagnose,secondDiagnose));
//
//    em.persist(patient);
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

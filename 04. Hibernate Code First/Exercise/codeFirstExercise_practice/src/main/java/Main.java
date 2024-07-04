import entities.Product;
import entities.Sale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("code_first_exercise");

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    //Create sale
    Sale sale = new Sale();
    sale.setDate(LocalDateTime.now());

    //Create product
    Product product = new Product();
    product.setName("PC");
    product.setPrice(BigDecimal.TEN);
    product.setQuantity(1L);

    //Cascade = cascade.PERSIST
    product.getSales().add(sale);
    sale.setProduct(product);
    em.persist(product);

    //Delete product
    Product findProduct = em.find(Product.class, 1);
    em.remove(findProduct);

    em.getTransaction().commit();

  }
}

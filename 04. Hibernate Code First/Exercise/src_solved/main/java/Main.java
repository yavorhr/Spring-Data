import entity.Customer;
import entity.Product;
import entity.Sale;
import entity.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("test").createEntityManager();

        entityManager.getTransaction().begin();

//        //Create sale
//        Sale sale = new Sale();
//        sale.setLocalDate(LocalDateTime.now());
//
//        //Create product
//        Product product = new Product();
//        product.setName("PC");
//        product.setPrice(BigDecimal.TEN);
//        product.setQuantity(1);
//
//        //Cascade = cascade.PERSIST
//        product.getSales().add(sale);
//        sale.setProduct(product);
//        entityManager.persist(product);

//        //Delete product
//        Product findProduct = entityManager.find(Product.class,2);
//        entityManager.remove(findProduct);

        entityManager.getTransaction().commit();
    }
}

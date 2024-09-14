package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}

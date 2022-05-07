package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("SELECT u FROM User u ORDER BY size(u.posts) DESC,u.id")
    List<User> findAllUsersOrderedByPostsCountDescThenById();
}

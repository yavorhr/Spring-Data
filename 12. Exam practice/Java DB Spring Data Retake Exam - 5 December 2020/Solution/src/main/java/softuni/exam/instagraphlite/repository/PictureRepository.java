package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.Entity.Picture;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {

    Picture findPictureByPath(String path);

    List<Picture> findAllBySizeGreaterThanOrderBySizeAsc(double size);
}

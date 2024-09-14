package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.LibraryMember;

@Repository
public interface LibraryMemberRepository extends JpaRepository<LibraryMember, Long> {

}

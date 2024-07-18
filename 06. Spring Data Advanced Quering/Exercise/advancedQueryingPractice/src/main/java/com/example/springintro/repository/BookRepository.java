package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

  List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

  List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

  List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

  List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

  List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal higherBound);

  List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate lower, LocalDate upper);

  List<Book> findAllByTitleContains(String string);

  List<Book> findAllByAuthor_LastNameStartsWith(String startsStr);

  @Query("SELECT count(b) FROM Book b WHERE LENGTH(b.title) >:param ")
  int countAllByTitleLengthMoreThan(@Param(value = "param") int length);

  List<Book> findAllByTitle(String title);

  @Query("UPDATE Book b SET b.copies = b.copies + :copies WHERE b.title IN (:titles)")
  @Modifying
  int updateBooksCopiesAfterYear(@Param(value = "titles") List<String> titles,
                                  @Param(value = "copies") int copies);

  @Modifying
  int removeAllByCopiesLessThan(Integer copies);

}

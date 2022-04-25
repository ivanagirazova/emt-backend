package mk.ukim.finki.emt.labemtbackend.repository;

import mk.ukim.finki.emt.labemtbackend.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Page<Book> findAll(Pageable pageable);
}

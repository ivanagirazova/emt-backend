package mk.ukim.finki.emt.labemtbackend.repository;

import mk.ukim.finki.emt.labemtbackend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}

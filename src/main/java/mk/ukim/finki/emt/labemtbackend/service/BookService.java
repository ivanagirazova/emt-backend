package mk.ukim.finki.emt.labemtbackend.service;

import mk.ukim.finki.emt.labemtbackend.model.Book;
import mk.ukim.finki.emt.labemtbackend.model.enumerations.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface BookService {

    List<Book> findAll();
    Page<Book> findAllWithPagination(Pageable pageable);
    Optional<Book> findById(Long id);
    Optional<Book> save(String name, Category category,Long authorId, int availableCopies);
    Optional<Book> save(Book book);
    Optional<Book> edit(Long id, String name, Category category, Long authorId, int availableCopies);
    Optional<Book> edit(Long id, Book book);
    void deleteById(Long id);
    Optional<Book> markAsTaken(Long id);
}

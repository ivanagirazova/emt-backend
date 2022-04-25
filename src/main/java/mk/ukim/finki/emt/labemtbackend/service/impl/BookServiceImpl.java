package mk.ukim.finki.emt.labemtbackend.service.impl;

import mk.ukim.finki.emt.labemtbackend.model.Author;
import mk.ukim.finki.emt.labemtbackend.model.Book;
import mk.ukim.finki.emt.labemtbackend.model.enumerations.Category;
import mk.ukim.finki.emt.labemtbackend.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.emt.labemtbackend.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.labemtbackend.repository.AuthorRepository;
import mk.ukim.finki.emt.labemtbackend.repository.BookRepository;
import mk.ukim.finki.emt.labemtbackend.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Book> save(String name, Category category, Long authorId, int availableCopies) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = new Book(name, category, author, availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(bookRepository.save(book));
    }

    @Override
    @Transactional
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, int availableCopies) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, Book b) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(b.getName());
        book.setCategory(b.getCategory());
        book.setAuthor(b.getAuthor());
        book.setAvailableCopies(b.getAvailableCopies());
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Book> markAsTaken(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setAvailableCopies(book.getAvailableCopies()-1);
        return Optional.of(bookRepository.save(book));
    }
}

package mk.ukim.finki.emt.labemtbackend.model.bootstrap;

import lombok.Getter;
import mk.ukim.finki.emt.labemtbackend.model.Author;
import mk.ukim.finki.emt.labemtbackend.model.Book;
import mk.ukim.finki.emt.labemtbackend.model.Country;
import mk.ukim.finki.emt.labemtbackend.model.enumerations.Category;
import mk.ukim.finki.emt.labemtbackend.repository.AuthorRepository;
import mk.ukim.finki.emt.labemtbackend.repository.BookRepository;
import mk.ukim.finki.emt.labemtbackend.repository.CountyRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Country> countries = new ArrayList<>();

    private final CountyRepository countyRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataHolder(CountyRepository countyRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.countyRepository = countyRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        countries.add(new Country("England","Europe"));
        countries.add(new Country("Canada","North America"));
        countries.add(new Country("Japan","Asia"));

        authors.add(new Author("Author1","Author1", countries.get(0)));
        authors.add(new Author("Author2","Author2", countries.get(1)));
        authors.add(new Author("Author3","Author3", countries.get(2)));

        books.add(new Book("Book1", Category.BIOGRAPHY, authors.get(0), 5));
        books.add(new Book("Book2", Category.THRILLER, authors.get(1), 15));
        books.add(new Book("Book2", Category.FANTASY, authors.get(2), 10));

        for (Country country: countries)
            countyRepository.save(country);

        for (Author author: authors)
            authorRepository.save(author);

        for (Book book: books)
            bookRepository.save(book);
    }

}

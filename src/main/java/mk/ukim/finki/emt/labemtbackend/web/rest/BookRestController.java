package mk.ukim.finki.emt.labemtbackend.web.rest;

import mk.ukim.finki.emt.labemtbackend.model.Book;
import mk.ukim.finki.emt.labemtbackend.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"/","/books"})
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/pageable")
    public List<Book> findAllWithPagination(Pageable pageable) {
        return this.bookService.findAllWithPagination(pageable).getContent();
    }


    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return bookService.save(book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id,
                                     @RequestBody Book book) {
        return bookService.edit(id,book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    //mark as taken
    @PutMapping("/edit/mark/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id) {
        return bookService.markAsTaken(id)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}

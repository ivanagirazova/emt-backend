package mk.ukim.finki.emt.labemtbackend.model;

import lombok.Data;
import mk.ukim.finki.emt.labemtbackend.model.enumerations.Category;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    private int availableCopies;

    public Book() {
    }

    public Book(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}

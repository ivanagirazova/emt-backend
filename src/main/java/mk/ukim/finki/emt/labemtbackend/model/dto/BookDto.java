package mk.ukim.finki.emt.labemtbackend.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.labemtbackend.model.Author;
import mk.ukim.finki.emt.labemtbackend.model.enumerations.Category;

@Data
public class BookDto {

    private String name;
    private Category category;
    private Author author;
    private int availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}

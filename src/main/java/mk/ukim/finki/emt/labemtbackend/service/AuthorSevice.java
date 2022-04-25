package mk.ukim.finki.emt.labemtbackend.service;

import mk.ukim.finki.emt.labemtbackend.model.Author;

import java.util.Optional;

public interface AuthorSevice {

    Optional<Author> findById(Long id);
}

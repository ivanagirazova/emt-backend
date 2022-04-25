package mk.ukim.finki.emt.labemtbackend.service.impl;

import mk.ukim.finki.emt.labemtbackend.model.Author;
import mk.ukim.finki.emt.labemtbackend.repository.AuthorRepository;
import mk.ukim.finki.emt.labemtbackend.service.AuthorSevice;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorSevice {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}

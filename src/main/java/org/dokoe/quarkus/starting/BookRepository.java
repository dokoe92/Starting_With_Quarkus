package org.dokoe.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue =  "Sci-Fi")
    String genre;
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Understanding Quarkus", "Antonio", 2020, genre),
                new Book(2, "Practising Quarkus", "Antonio", 2020, genre),
                new Book(3, "Effective Java", "Josh Blocj", 2001, genre),
                new Book(4, "Thinking in Java", "Bruce Eckel", 1998, genre)
                );
    }


    public int countAllBooks() {
        return getAllBooks().size();
    }


    public Optional<Book> getBook(@PathParam("id")int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }


}

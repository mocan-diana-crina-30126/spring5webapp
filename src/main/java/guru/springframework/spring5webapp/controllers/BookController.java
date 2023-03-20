package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //la accesarea /books din url, se va executa metoda getBooks care va returna un model al carui atribut va fi o lista
    //de carti preluta din repositoryul de carti -> BookRepository (using Springs dependency injection) - am instantiat o instanta a
    //repositoryului de carti
    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());


        return "books";
    }
}

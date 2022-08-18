package com.spring.boot.springbootrestapi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.springbootrestapi.Dao.BookRepository;
import com.spring.boot.springbootrestapi.model.Books;

@Component
public class BooksService {
    // private static List<Books> list = new ArrayList<>();

    // static {
    // list.add(new Books(1002, "Java frameworks", "ABC"));
    // list.add(new Books(1003, "Python frameworks", "PQR"));
    // list.add(new Books(1004, "PHP frameworks", "XYZ"));
    // list.add(new Books(1005, ".NET frameworks", "KLM"));
    // list.add(new Books(1006, "Frontend frameworks", "EFG"));
    // }

    @Autowired
    private BookRepository bookRepository;

    public List<Books> GetAllbooks() {

        List<Books> findAll = this.bookRepository.findAll();
        return findAll;
    }

    public Books GetBook(int id) {
        Books books = null;
        try {

            Optional<Books> findById = this.bookRepository.findById(id);
            books = findById.get();
            System.out.println(books);
            // books = list.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;

    }

    public Books AddBooks(Books book1) {

        Books saved = this.bookRepository.save(book1);
        // list.add(book1);
        System.out.println(saved);
        return saved;
    }

    public void Delete(int id) {

        this.bookRepository.deleteById(id);
        // List<Books> collect = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
    }

    public Books UpdateBook(Books books, int id) {
        // List<Books> collect = list.stream().map(book -> {
        //     if (book.getId() == id) {
        //         book.setTitle(books.getTitle());
        //         book.setAuthor(books.getAuthor());
        //     }
        //     return book;
        // }).collect(Collectors.toList());
        // return collect;

        books.setId(id);
        Books update = this.bookRepository.save(books);
        return update;
    }
}

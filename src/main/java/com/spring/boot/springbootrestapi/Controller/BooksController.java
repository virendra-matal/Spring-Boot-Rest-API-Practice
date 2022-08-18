package com.spring.boot.springbootrestapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.springbootrestapi.Services.BooksService;
import com.spring.boot.springbootrestapi.model.Books;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public ResponseEntity<List<Books>> name() {
        List<Books> getAllbooks = this.booksService.GetAllbooks();
        if (getAllbooks.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(getAllbooks);

    }

    @GetMapping("/book")
    public Books getSingleBook() {
        return this.booksService.GetBook(1005);

    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getSingleBookPathVariable(@PathVariable("id") int id) {

        Books getBook = this.booksService.GetBook(id);
        if (getBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(getBook));

    }

    @PostMapping("/books")
    public ResponseEntity<Books> addbook(@RequestBody Books b) {
        // List<Books> addBooks = null;
        if (b != null) {
            Books addBooks = this.booksService.AddBooks(b);
            System.out.println(addBooks);
            return ResponseEntity.of(Optional.of(addBooks));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable("id") int id) {

        try {

            this.booksService.Delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Books> UpadateRecord(@RequestBody Books books, @PathVariable("id") int id) {

        try {
            Books updatedBook = this.booksService.UpdateBook(books, id);
            return ResponseEntity.of(Optional.of(updatedBook));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

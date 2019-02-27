package com.gg.proj.webapp;

import com.gg.proj.business.BookManager;
import com.gg.proj.model.BookModel;
import com.gg.proj.model.PagedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private BookManager bookManager;

    @Autowired
    public BookController(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @RequestMapping(value = "/book")
    public String book(Model model,
                       @RequestParam Integer id) {
        BookModel bookModel = bookManager.getBookById(id);
        model.addAttribute("book", bookModel);
        return "book";
    }

    @RequestMapping(value = "/books")
    public String books(Model model) {
        List<BookModel> listBookModel = bookManager.getAllBooks();
        model.addAttribute("books", listBookModel);
        return "books";
    }

    @RequestMapping(value = "/paged_books", method = RequestMethod.GET)
    public String pagedBooks(Model model,
                             @RequestParam(defaultValue = "0", required = false) int page,
                             @RequestParam(defaultValue = "5", required = false) int size,
                             @RequestParam(defaultValue = "", required = false) String keyWord) {
        PagedBook pagedBook = bookManager.searchBooks(page, size, keyWord);
        model.addAttribute("books", pagedBook.getBookList());
        System.out.println(pagedBook.getTotalPages());
        int[] pages = new int[pagedBook.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        return "paged_books";
    }
}

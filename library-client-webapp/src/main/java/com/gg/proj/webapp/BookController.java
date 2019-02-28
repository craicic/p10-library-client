package com.gg.proj.webapp;

import com.gg.proj.business.BookManager;
import com.gg.proj.model.BookModel;
import com.gg.proj.model.PagedBookModel;
import com.gg.proj.model.SearchResultModel;
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

    @RequestMapping(value = "/book/get")
    public String book(Model model,
                       @RequestParam Integer id) {
        BookModel bookModel = bookManager.getBookById(id);
        model.addAttribute("book", bookModel);
        return "book";
    }

    @RequestMapping(value = "/book/all")
    public String books(Model model) {
        List<BookModel> listBookModel = bookManager.getAllBooks();
        model.addAttribute("books", listBookModel);
        return "books";
    }

    @RequestMapping(value = "/book/paged_book", method = RequestMethod.GET)
    public String pagedBooks(Model model,
                             @RequestParam(defaultValue = "0", required = false) int page,
                             @RequestParam(defaultValue = "5", required = false) int size,
                             @RequestParam(defaultValue = "", required = false) String keyWord) {
        PagedBookModel pagedBookModel = bookManager.getPagedBooks(page, size, keyWord);
        model.addAttribute("books", pagedBookModel.getBookList());
        int[] pages = new int[pagedBookModel.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        return "paged_books";
    }

    @RequestMapping(value = "/book/search", method = RequestMethod.GET)
    public String searchBooks(Model model,
                              @RequestParam(defaultValue = "0", required = false) int page,
                              @RequestParam(defaultValue = "5", required = false) int size,
                              @RequestParam(defaultValue = "", required = false) String keyWord) {
        SearchResultModel result = bookManager.searchBooks(page, size, keyWord);

        model.addAttribute("books", result.getBooks());
        model.addAttribute("languages", result.getLanguages());
        model.addAttribute("libraries", result.getLibraries());
        model.addAttribute("topics", result.getTopics());
        int[] pages = new int[result.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("keyWord", keyWord);
        return "search";
    }
}

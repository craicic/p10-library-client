package com.gg.proj.webapp;

import com.gg.proj.authentication.UserInfo;
import com.gg.proj.business.BookManager;
import com.gg.proj.model.BookModel;
import com.gg.proj.model.complex.BookResultModel;
import com.gg.proj.model.complex.FormResultModel;
import com.gg.proj.model.complex.PagedBookModel;
import com.gg.proj.model.complex.SearchResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private BookManager bookManager;

    @Autowired
    public BookController(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @RequestMapping(value = "/book/get")
    public String book(Model model,
                       @RequestParam Integer id) {
        BookResultModel resultModel = bookManager.getBookById(id);
        log.info("BookModel : langugageId = " + resultModel.getBookModel().getLanguageId());

        model.addAttribute("book", resultModel.getBookModel());
        model.addAttribute("library", resultModel.getLibraryModel());
        model.addAttribute("language", resultModel.getLanguageModel());
        model.addAttribute("topic", resultModel.getTopicModelList());
        String shortDescription = resultModel.getBookModel().getSummary();
        if (shortDescription.length() > 30)
            shortDescription = shortDescription.substring(0, 30) + "...";

        model.addAttribute("shortDescription", shortDescription);
        return "books/book";
    }

    @RequestMapping(value = "/book/all")
    public String books(Model model) {
        List<BookModel> listBookModel = bookManager.getAllBooks();
        model.addAttribute("books", listBookModel);
        return "books/books";
    }

    @RequestMapping(value = "/book/paged_book", method = RequestMethod.GET)
    public String pagedBooks(Model model,
                             @RequestParam(defaultValue = "0", required = false) int page,
                             @RequestParam(defaultValue = "5", required = false) int size,
                             @RequestParam(defaultValue = "", required = false) String keyWord) {
        PagedBookModel pagedBookModel = bookManager.getPagedBooks(page, size, keyWord);
        model.addAttribute("books", pagedBookModel.getBookList());
        int[] pages = new int[pagedBookModel.getTotalPages()];
        UserInfo userInfo = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.debug("user ID : " + userInfo.getId());
        log.debug("tokenUUID : " + userInfo.getTokenUUID().toString());
        model.addAttribute("pages", pages);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        return "books/paged_books";
    }

    @GetMapping(value = "/book/search")
    public String searchBooks(Model model,
                              @RequestParam(defaultValue = "0", required = false) int page,
                              @RequestParam(defaultValue = "5", required = false) int size,
                              @RequestParam(defaultValue = "", required = false, name = "keyWord") String keyWord) {
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
        model.addAttribute("formResult", new FormResultModel());
        return "books/search";
    }

    @RequestMapping(value = "/book/filter")
    public String filterBooks(Model model,
                              @RequestParam(defaultValue = "0", required = false) int page,
                              @RequestParam(defaultValue = "5", required = false) int size,
                              @RequestParam(defaultValue = "", required = false) String keyWord,
                              @ModelAttribute FormResultModel formResult) {
        PagedBookModel result = bookManager.filterBooks(page, size, keyWord, formResult.getLanguageId(), formResult.getLibraryId()
                , formResult.getTopicId(), formResult.isAvailable());
        model.addAttribute("books", result.getBookList());
        int[] pages = new int[result.getTotalPages()];
        model.addAttribute("languageId", formResult.getLanguageId());
        model.addAttribute("libraryId", formResult.getLibraryId());
        model.addAttribute("topicId", formResult.getTopicId());
        model.addAttribute("available", formResult.isAvailable());
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("keyWord", keyWord);
        return "books/filter";
    }
}

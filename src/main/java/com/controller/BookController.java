package com.controller;

import com.entity.Book;
import com.entity.BookDocument;
import com.entity.FileBucket;
import com.entity.User;
import com.service.BookDocumentService;
import com.service.BookService;
import com.service.UserService;
import com.util.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 20.03.2016.
 */

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookDocumentService bookDocumentService;

    @Autowired
    FileValidator fileValidator;

    @Autowired
    UserService userService;

    @InitBinder("fileBucket")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(fileValidator);
    }


    @RequestMapping(value = {"/findBookById" }, method = RequestMethod.GET)
    public String findById1(ModelMap model) {
        Book book=new Book();

        model.addAttribute("book", book);
        return "bookPage";
    }

        @RequestMapping(value = {"/findBookById" }, method = RequestMethod.POST)
    public String findById(@ModelAttribute Book book, @RequestParam Integer id, ModelMap model) {

        Book book1 =bookService.findById(id);
        model.addAttribute("book", book1);
        return "bookPage";
    }

    @RequestMapping(value = {"/findBookByName" }, method = RequestMethod.GET)
    public String findBookByNameGet(ModelMap model) {
        Book book=new Book();

        model.addAttribute("book", book);
        return "bookPage";

    }
    @RequestMapping(value = {"/findBookByName" }, method = RequestMethod.POST)
    public String findBookByName(@ModelAttribute Book book, @RequestParam String name, ModelMap model) {

        Book book1 =bookService.findByName(name);
        model.addAttribute("book", book1);
        return "bookPage";
    }



    @RequestMapping(value = {"/findBookByStyle" }, method = RequestMethod.GET)
    public String findBookByStyleGet(ModelMap model) {
        Book book=new Book();

        model.addAttribute("book", book);
        return "bookPage";

    }

    @RequestMapping(value = {"/findBookByStyle" }, method = RequestMethod.POST)
    public String findBookByStyle(@ModelAttribute Book book, @RequestParam String style, ModelMap model) {

        List<Book> books=bookService.findByStyle(style);
        model.addAttribute("bookss", books);
        model.addAttribute("style", style);
        return "books";
    }



    @RequestMapping(value = { "/book-{bookId}" }, method = RequestMethod.GET)
    public String rediretToBookPage(@PathVariable Integer bookId, ModelMap model) {
        Book book = bookService.findById(bookId);

        model.addAttribute("book", book);
        return "bookPage";
    }



    @RequestMapping(value = {  "/listAdmin" }, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        Book book= new Book();
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("book", book);
        return "main";
    }




    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = { "/edit-book-{bookId}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable Integer bookId, ModelMap model) {
        Book book = bookService.findById(bookId);

        model.addAttribute("book", book);
        model.addAttribute("edit", true);
        return "addbook";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-book-{bookId}" }, method = RequestMethod.POST)
    public String updatBook(@Valid Book book, BindingResult result,
                             ModelMap model, @PathVariable Integer bookId) {

        if (result.hasErrors()) {
            return "addbook";
        }

        bookService.updateBook(book);

        model.addAttribute("success", "Book " + book.getName() +" updated successfully");
        return "redirect:/listAdmin";
    }


    /**
     * This method will delete an user by it's SSOID value.
     */
    @RequestMapping(value = { "/delete-book-{bookId}" }, method = RequestMethod.GET)
    public String deleteBook(@PathVariable int bookId) {
        bookService.deleteBookById(bookId);
        return "redirect:/listAdmin";
    }


    @RequestMapping(value = { "/add-to-list-book-{bookId}" }, method = RequestMethod.GET)
    public String addToListBook(@PathVariable int bookId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
//        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        String name = user.getName(); //get logged in username

        userService.addToBookList(name, bookService.findById(bookId));


        return "redirect:/listAdmin";
    }

//    @RequestMapping(value = { "/add-to-list-book-{bookId}" }, method = RequestMethod.POST)
//    public String addToListBook1(@PathVariable int bookId,@PathVariable int userId) {
//
//        Set<Book> set= new HashSet<Book>();
//        set.add(bookService.findById(bookId));
//        userService.addToBookList(userId, set);
//
//        return "main";
//
//    }





    /**
     * Цей метод використовуэться для додавання нової книги
     */

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String newbook(ModelMap model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addbook";
    }

    /*
     * This method will be called on form submission, handling POST request It
     * also validates the book input
     */
    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String addbook(@Valid Book book,
                          BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "addbook";
        }

        bookService.save(book);



        model.addAttribute("bookadded", "Book: " + book.getName() + " has been added successfully");
        return "redirect:/add-document-"+book.getId();
    }

    @RequestMapping(value = { "/add-document-{bookId}" }, method = RequestMethod.GET)
    public String addDocuments(@PathVariable int bookId, ModelMap model) {

        Book book = bookService.findById(bookId);

        model.addAttribute("book", book);

        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);

        return "uploadBook1";
    }

    @RequestMapping(value = { "/add-document-{bookId}" }, method = RequestMethod.POST)
    public String uploadDocument(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int bookId) throws IOException {

        if (result.hasErrors()) {
            System.out.println("validation errors");

            return "uploadBook1"; //------------------FAIL!!1 CHECK
        } else {

            System.out.println("Fetching file");
            Book book = bookService.findById(bookId);
            if (fileBucket.getFile()==null){
                return "allBooks";
            }
            model.addAttribute("book", book);

            saveDocument(fileBucket, book);

            return "welcome";
        }
    }

    @RequestMapping(value = { "/download-document-{bookId}" }, method = RequestMethod.GET)
    public String downloadDocument(@PathVariable int bookId , HttpServletResponse response) throws IOException {


        BookDocument bookDocument=bookDocumentService.findById(bookService.findBookDocumentId(bookId));

        response.setContentType(bookDocument.getType());
        response.setContentLength(bookDocument.getContent().length);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + bookDocument.getName() + "\"");

        FileCopyUtils.copy(bookDocument.getContent(), response.getOutputStream());

        return "redirect:/listAdmin";
    }

    @RequestMapping(value = { "/delete-document-{bookId}}" }, method = RequestMethod.GET)
    public String deleteDocument(@PathVariable int bookId) {
        bookDocumentService.deleteById(bookService.findBookDocumentId(bookId));
        return "redirect:/listAdmin";
    }



    private void saveDocument(FileBucket fileBucket, Book book) throws IOException {


        BookDocument document = new BookDocument();

        MultipartFile multipartFile = fileBucket.getFile();

        document.setName(multipartFile.getOriginalFilename());
        document.setDescription(fileBucket.getDescription());
        document.setType(multipartFile.getContentType());
        document.setContent(multipartFile.getBytes());
        document.setBook(book);
        bookDocumentService.saveDocument(document);
    }

}

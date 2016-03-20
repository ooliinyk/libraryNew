package com.controller;


import com.entity.*;
import com.service.*;
import com.util.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;

	@Autowired
	BookService bookService;

	@Autowired
	BookDocumentService bookDocumentService;

	@Autowired
	FileValidator fileValidator;

	@InitBinder("fileBucket")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(fileValidator);
	}




	/**
	 * Цей метод використовуэться для реєстрації користувача з роллю юзер
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String savedRegistration(@Valid User user,
								   BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "registration";
		}
		Set<Role> set =new HashSet<Role>();
		set.add(roleService.findByName("USER"));
				user.setRoles(set);

		userService.save(user);

		System.out.println("First Name : " + user.getName());
		System.out.println("Last Name : "+user.getLastName());
		System.out.println("Login : "+user.getLogin());
		System.out.println("Password : "+user.getPassword());
		System.out.println("Email : "+user.getEmail());
		System.out.println("Phone : "+user.getPhone());
		System.out.println("Checking UsrProfiles....");
		if(user.getRoles()!=null){
			for(Role profile : user.getRoles()){
				System.out.println("Profile : "+ profile.getRoleName());
			}
		}


		model.addAttribute("success", "User " + user.getName() + " has been registered successfully");
		return "registrationsuccess";
	}




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
	public String uploadDocument(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int bookId) throws IOException{

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


	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to mysite");
		return "welcome";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newsRegistration(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "newuser";
	}

	/*
	 * This method will be called on form submission, handling POST request It
	 * also validates the user input
	 */
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String saveRegistration(@Valid User user,
			BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "newuser";
		}
		userService.save(user);
		

		if(user.getRoles()!=null){
			for(Role role : user.getRoles()){
				System.out.println("Profile : "+ role.getRoleName());
			}
		}
		
		model.addAttribute("success", "User " + user.getName() + " has been registered successfully");
		return "registrationsuccess";
	}

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "allBooks";
	}

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "main";
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
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
	
	
	@ModelAttribute("roles")
	public List<Role> initializeProfiles() {
		return roleService.findAll();
	}

//	@ModelAttribute("roleUser")
//	public List<Role> initializeProfiles() {
//		return roleService.findByName("USER").f();
//	}

}
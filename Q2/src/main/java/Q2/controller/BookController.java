package Q2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Q2.BookRepo;
import Q2.entity.BookEntity;
@Controller
public class BookController {
	@Autowired
	BookRepo repo;
	
	
	//Creating a URL for getNames from the Database by a get method
	@GetMapping("/getNames")
	public ModelAndView getNames() {
		ModelAndView mv = new ModelAndView();
		List<BookEntity> list= repo.findAll(); //fetch all the reocords from the database
		mv.addObject("bookList", list); //add the list into the addObject method of ModelAndView and access the List in the JSP file;
		mv.setViewName("getName"); //redirect the user to the specified page given int the parameters;
		return mv; //return the ModelAndView
	} //end of getNames method
	
	//Creating a URL for removeBook from the Database by a post method
	@PostMapping("/removeBook") //to remove the books the user will send the request via a post method with action ="removeBook";
	public ModelAndView removeBook(@RequestParam int removeBook) { //Pass the bookId of the specified bookName on the JSP;
		ModelAndView mv = new ModelAndView();
		repo.deleteById(removeBook); //Delete the sepcified book from the database
		String message = "Book Deleted";  //store a String message into the addObject method and access the message in the JSP file 
		mv.addObject("message", message);
		mv.setViewName("BookDeleted"); //redirect the user to the specified page given int the parameters;
		return mv; //return the ModelAndView object
	} //end of removeBook method
}

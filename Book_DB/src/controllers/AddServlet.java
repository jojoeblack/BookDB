package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import model.Book;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "add a new book", urlPatterns = { "/addBook" })
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get the data
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int pages= Integer.parseInt(request.getParameter("pages"));
		
		//set up a book object
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setPages(pages);
		//set up an addQuery object
		AddQuery aq = new AddQuery("scif_library","root","2xliulriI");
		//AddQuery aq = new AddQuery();
		//pass the book to add
		aq.doAdd(book);
		//pass execution control to the ReadServlet
		String url="/read";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

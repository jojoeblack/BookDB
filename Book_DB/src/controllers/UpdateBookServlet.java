package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.UpdateQuery;
import model.Book;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(description = "controller which starts the actual book update to the database", urlPatterns = { "/updateBook" })
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			this.doPost(request, response);
			response.setContentType("text/html;charset=UTF-8"); 		
			request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get the form data and set up a Book object
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8"); 
		
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		String title = request.getParameter("title");//updateForm.jsp <input name=xxx>
		String author = request.getParameter("author");
		int pages = Integer.parseInt(request.getParameter("pages"));
		
		Book book = new Book();
		book.setBookID(bookID);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPages(pages);
		//create an UpdateQuery object and use it to update the book
		UpdateQuery uq = new UpdateQuery("scif_library", "root", "2xliulriI");
		//UpdateQuery uq = new UpdateQuery();
		uq.doUpdate(book);
		
		//pass control on to the ReadServlet
		String url = "/read";
		RequestDispatcher dispatcher =request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

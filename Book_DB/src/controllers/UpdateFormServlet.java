package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ReadRecord;
import model.Book;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet(description = "this will get a book and use the datat to fill in a table for updating the record", urlPatterns = { "/update" })
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);  
		response.setContentType("text/html;charset=UTF-8"); 		
		request.setCharacterEncoding("UTF-8");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8"); 	
		request.setCharacterEncoding("UTF-8");
		//get the bookID
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		
		//create ReadRecord class
		ReadRecord rr = new ReadRecord("scif_library","root","2xliulriI",bookID);
		
		//Use ReadRecord to get he book data
		rr.doRead();
		
		Book book = rr.getBook();
		
		//pass Book and control to the updateForm.jsp

		request.setAttribute("book", book);
		
		String url = "/updateForm.jsp";
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.DeleteQuery;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(
		description = "Delete a record for a particular bookID", 
		urlPatterns = { 
				"/DeleteServlet", 
				"/delete"
		})
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get the bookID
		int bookID = Integer.parseInt(request.getParameter("bookID"));
		//create a deleteQuery object
		DeleteQuery dq= new DeleteQuery("scif_library", "root", "2xliulriI");
		//use deletQuery to delete the recored
		dq.doDelete(bookID);
		//pass execution on to the ReadServlet
		String url="/read";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

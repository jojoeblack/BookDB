package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ReadQuery;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet({ "/ReadServlet", "/read" })
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadServlet() {
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
		// Create a ReadQuery helper object
		response.setContentType("text/html;charset=UTF-8"); 		
		request.setCharacterEncoding("UTF-8");
		ReadQuery rq = new ReadQuery("scif_library","root","2xliulriI");
		//Get the html table from the ReadQuery object
		rq.doRead();
		String table = rq.getHTMLTable();
		//pass execution cntrol to read .jsp along with the table
		request.setAttribute("table", table);
		String url = "/read.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}

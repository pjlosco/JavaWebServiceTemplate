package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ProductListingServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String filter = request.getParameter("filter");
			
			// TODO - run query to get list or products, set attributes, have jsp iterate through them
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);

		} catch(Exception e) {
			throw new ServletException(e.toString());
		}
		finally{
			logger.info("Finished doGet");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}

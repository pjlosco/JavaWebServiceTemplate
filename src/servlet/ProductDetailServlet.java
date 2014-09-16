package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ProductListingServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String productID = request.getParameter("productID");
			
			// TODO - run query to get info on product, set attributes and pass to front end
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("productdetail.jsp");
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

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.CartLineItem;
import cart.ShoppingCart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ShowShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ShowShoppingCartServlet.class);
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = null;
		try{
	    	// get the session
			HttpSession session = request.getSession();
			
			//get cart from session
			ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
			
			//if null return
			if ((cart==null) || (cart.getIterator()==null)|| (!cart.getIterator().hasNext())){
			}
			else{
				Iterator<CartLineItem> iterator = cart.getIterator();
				while (iterator.hasNext()){
					CartLineItem lineItem = iterator.next();
					// TODO - get the products and output
				}
			}
			
			request.setAttribute("cartContainsItems", cart.cartHasItems());
			request.setAttribute("cartTotalAmount", cart.getTotalAmount());
			request.setAttribute("cartTotalQuantity", cart.getTotalQuantity());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("showshoppingcart.jsp");
			dispatcher.forward(request, response);

		}
		catch(Exception e){
			throw new ServletException(e.toString());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

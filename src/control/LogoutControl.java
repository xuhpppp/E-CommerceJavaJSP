package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginCookieDB;
import entity.User;

@WebServlet("/logout")
public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		//get user in case deleting cookie
		User user = (User) session.getAttribute("user");
		
		session.removeAttribute("user");
		
		try {
			if (user == null) {
				response.sendRedirect("home");
				
				return;
			}
			
			LoginCookieDB.deleteLoginCookie(user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("tokenLoginEShop") || c.getName().equals("idEShop")) {
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
		
		response.sendRedirect("home");
	}
}
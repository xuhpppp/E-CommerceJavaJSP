package control;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FindUser;
import dao.LoginCookieDB;
import entity.User;

@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		User user = null;
		try {
			user = FindUser.findUser(email);

			if (user != null && HashPassword.validatePassword(password, user.getPasswordHash()) == true) {
				request.setAttribute("user", user);
				
				HttpSession session = request.getSession();
				
				session.setAttribute("user", user);
				
				//remember me
				if (remember != null) {
					String token = LoginCookieDB.generateToken();
					
					Cookie cookieToken = new Cookie("tokenLoginEShop", token);
					Cookie cookieId = new Cookie("idEShop", String.valueOf(user.getId()));
					cookieToken.setMaxAge(100);
					cookieId.setMaxAge(100);
					response.addCookie(cookieToken);
					response.addCookie(cookieId);
					
					LoginCookieDB.insertLoginCookie(user.getId(), token);
				}
				
				response.sendRedirect("home");
			} else {
				request.setAttribute("loginCondition", "Wrong email or password");
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

}

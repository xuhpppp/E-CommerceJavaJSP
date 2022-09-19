package control;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.SignUpAccount;
import dao.checkEmailExisted;

@WebServlet("/signup")
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignUpControl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		String receiveEmail = request.getParameter("remember");
		
		//decode to UTF-8
		String nameDecoded = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		name = nameDecoded;
		
		int signupSuccess = 0;
		if (name.equals("") || email.equals("") || password.equals("") || rePassword.equals("")) {
			request.setAttribute("signupCondition", "You must fill all the blanks!");
		} else if (password.equals(rePassword)) {
			try {
				if (checkEmailExisted.check(email) == 1) {
					request.setAttribute("signupCondition", "This email was already registered!");
				} else {
					SignUpAccount.signup(name, email, password, receiveEmail);
					
					signupSuccess = 1;

					SendMail.send(email);
					
					request.setAttribute("signupCondition", "Sign up successfully!");
				}
			} catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException | MessagingException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("signupCondition", "Your re-enter password is not correct!");
		}
		
		//client don't have to re-enter the information again
		request.setAttribute("name", signupSuccess == 1 ? "" : name);
		request.setAttribute("email", signupSuccess == 1 ? "" : email);
		request.setAttribute("password", signupSuccess == 1 ? "" : password);
		request.setAttribute("rePassword", signupSuccess == 1 ? "" : rePassword);
		
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}
}

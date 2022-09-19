package control;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

@WebServlet("/changepassword")
public class ChangePasswordControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePasswordControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("changepassword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String current_password = request.getParameter("current-password");
		String new_password = request.getParameter("new-password");
		String re_enter_new_password = request.getParameter("re-enter-new-password");
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		if (user != null) {
			try {
				if (control.HashPassword.validatePassword(current_password, user.getPasswordHash())) {
					if (!new_password.isBlank()) {
						if (new_password.equals(re_enter_new_password)) {
							dao.ChangePassword.changePassword(user.getId(), new_password);
							
							request.setAttribute("changeCondition", "Changed successfully!");
						} else {
							request.setAttribute("changeCondition", "New password is mismatch!");
						}
					} else {
						request.setAttribute("changeCondition", "New password cannot be blank!");
					}
				} else {
					request.setAttribute("changeCondition", "Your password is incorrect!");
				}
			} catch (NoSuchAlgorithmException | InvalidKeySpecException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher("changepassword.jsp").forward(request, response);
	}

}

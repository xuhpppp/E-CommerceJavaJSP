package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import entity.User;

@WebServlet("/changeavatar")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class ChangeAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangeAvatar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("myaccount");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get info of user
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			response.sendRedirect("home");
			
			return;
		}
		
		//process image
		Part filePart = request.getPart("file");
		
		String fileName = filePart.getSubmittedFileName();
		
		if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
			for (Part part : request.getParts()) {
				String path = "D:\\jee-2021-09\\EcommerceV2\\WebContent\\images\\avaPic\\" + user.getId();
				for (int i = fileName.lastIndexOf("."); i < fileName.length(); i++) {
					path += fileName.charAt(i);
				}
					
				part.write(path);
				      
				try {
					path = "./images/avaPic/" + user.getId();
				    for (int i = fileName.lastIndexOf("."); i < fileName.length(); i++) {
				    	path += fileName.charAt(i);
					}
				    	 
					dao.ChangeAvatar.changeAvatar(user.getId(), path);
						
					user.setImgPic(path);
						
					session.setAttribute("user", user);
						
					request.setAttribute("changeAvatarCondition", "Your avatar will be changed in 1-2 minutes, please be patient!");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			request.setAttribute("changeAvatarCondition", "Please choose right image type!");
		}
			
		request.getRequestDispatcher("myaccount").forward(request, response);
	}
}
